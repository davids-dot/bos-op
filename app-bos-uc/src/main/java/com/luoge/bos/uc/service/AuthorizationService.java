package com.luoge.bos.uc.service;

import com.luoge.bos.data.MenuDao;
import com.luoge.bos.data.PermissionDao;
import com.luoge.bos.data.entity.MenuDO;
import com.luoge.bos.uc.model.MenuBO;
import com.luoge.bos.data.model.PermissionMenuBO;
import com.luoge.bos.data.model.PermissionResourceBO;
import com.luoge.bos.uc.core.Constants;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AuthorizationService {
    @Resource
    private PermissionDao permissionDao;
    @Resource
    private MenuDao menuDao;

    private List<MenuDO> cacheMenus;

    // 权限和菜单的关系
    private Map<String, List<Integer>> menuMappers = new HashMap<>();

    // 资源与权限的关系
    private Map<String, List<String>> resourceMappers = new HashMap<>();

    @PostConstruct
    private void init() {
        // 缓存全部菜单
        cacheMenus = menuDao.list();

        // 缓存权限和菜单的关系
        menuMappers = permissionDao.listPermissionMenus().stream()
                .collect(Collectors.groupingBy(
                        PermissionMenuBO::getPermissionCode,
                        Collectors.mapping(PermissionMenuBO::getMenuId, Collectors.toList())));

        // 缓存资源与权限的关系
        resourceMappers = permissionDao.listPermissionResources().stream()
                .collect(Collectors.groupingBy(
                        PermissionResourceBO::getPermissionCode,
                        Collectors.mapping(PermissionResourceBO::getUrl, Collectors.toList())));
    }


    public Map<String, List<String>> getResourceMappers() {
        return resourceMappers;
    }


    public List<MenuBO> getMenus(int appId, List<String> permissions) {
        Set<Integer> menuSet = new HashSet<>();
        menuMappers.forEach((permission, menuIds) -> {
            if (permissions.contains(permission)) {
                menuSet.addAll(menuIds);
            }
        });

        var userMenus = cacheMenus.stream()
                .filter(m -> appId == Constants.ZERO || appId == m.getAppId())
                .filter(m -> menuSet.contains(m.getId()))
                .map(m -> new MenuBO(String.valueOf(m.getId()), m.getName(), m.getUrl(), String.valueOf(m.getParentId()), m.getSeq()))
                .collect(Collectors.toList());

        Set<MenuBO> parentMenus = new HashSet<>();
        userMenus.forEach(leaf -> cacheMenus.stream().filter(menu -> Objects.equals(leaf.getParent(), String.valueOf(menu.getId())))
                .forEach(menu -> parentMenus.add(new MenuBO(String.valueOf(menu.getId()), menu.getName(), menu.getUrl(), String.valueOf(menu.getParentId()), menu.getSeq()))));

        userMenus.addAll(parentMenus);

        return getMenus(userMenus);
    }

    private List<MenuBO> getMenus(List<MenuBO> userMenus) {

        userMenus.forEach(menu -> {
            var children = userMenus.stream()
                    .filter(item -> Objects.equals(item.getParent(), menu.getKey()))
                    .collect(Collectors.toList());
            if (!children.isEmpty()) {
                menu.setChildren(children);
            }
        });

        // 获取根菜单列表
        var menus = userMenus.stream().filter(menu -> Constants.ZERO == Integer.parseInt(menu.getParent())).collect(Collectors.toList());
        // 排序
        sortMenus(menus);

        return menus;
    }

    /**
     * 菜单排序
     *
     * @param menus 菜单列表
     */
    private void sortMenus(List<MenuBO> menus) {
        menus.sort(Comparator.comparingInt(MenuBO::getSeq));
        for (var menu : menus) {
            if (Objects.nonNull(menu.getChildren()) && !menu.getChildren().isEmpty()) {
                sortMenus(menu.getChildren());
            }
        }
    }
}
