package com.luoge.bos.business.permission;

import com.luoge.ns.core.R;
import com.luoge.ns.uc.client.PermissionClient;
import com.luoge.ns.uc.model.menu.MenuBO;
import com.luoge.ns.uc.model.menu.SaveMenuBO;
import com.luoge.ns.uc.model.permission.*;
import com.luoge.ns.uc.model.resource.ResourceBO;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bos-op")
public class PermissionController {

    @Resource
    private PermissionClient permissionClient;

    @GetMapping("/resources")
    public R<List<ResourceBO>> listResources() {
        return permissionClient.listResources();
    }

    @PostMapping("/resources")
    public R<Void> saveResource(@RequestBody @Valid ResourceBO resource) {
        return permissionClient.saveResource(resource);
    }

    @DeleteMapping("/resources")
    public R<Void> deleteResource(@RequestParam("id")int id) {
        return permissionClient.deleteResource(id);
    }

    @GetMapping("/menus")
    public R<List<MenuBO>> listMenus() {
        return permissionClient.listMenus();
    }

    @PostMapping("/menus")
    public R<Void> saveMenu(@RequestBody @Valid SaveMenuBO menu) {
        return permissionClient.saveMenu(menu);
    }

    @DeleteMapping("/menus")
    public R<Void> deleteMenu(@RequestParam("id") int id) {
        return permissionClient.deleteMenu(id);
    }


    @GetMapping("/permissions")
    public R<List<PermissionBO>> listPermissions() {
        return permissionClient.listPermissions();
    }

    @PostMapping("/permissions")
    public R<Void> insertPermission(@RequestBody @Valid CreatePermissionBO permission) {
         return permissionClient.insertPermission(permission);
    }

    @PutMapping("/permissions")
    public R<Void> updatePermission(@RequestBody @Valid UpdatePermissionBO permission) {
         return permissionClient.updatePermission(permission);
    }

    @DeleteMapping("/permissions")
    public R<Void> deletePermission(@RequestParam("id") int id) {
       return permissionClient.deletePermission(id);
    }

    @PostMapping("/permissions/resources")
    public R<Void> savePermissionResources(@RequestBody @Valid SavePermissionResourceBO permissionResource) {
        return permissionClient.savePermissionResources(permissionResource);
    }

    @PostMapping("/permissions/menus")
    public R<Void> savePermissionMenus(@RequestBody @Valid SavePermissionMenusBO savePermissionMenu) {
        return permissionClient.savePermissionMenus(savePermissionMenu);
    }
}