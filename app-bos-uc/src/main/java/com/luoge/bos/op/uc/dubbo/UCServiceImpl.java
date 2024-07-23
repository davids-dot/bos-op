package com.luoge.bos.op.uc.dubbo;

import com.luoge.bos.op.uc.service.AuthenticationService;
import com.luoge.bos.op.uc.service.AuthorizationService;
import com.luoge.bos.op.uc.service.UserService;
import com.luoge.bos.uc.dubbo.UCService;
import com.luoge.bos.uc.model.User;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UCServiceImpl implements UCService {

    @Resource
    private AuthenticationService authenticationService;

    @Resource
    private AuthorizationService authorizationService;

    @Resource
    private UserService ucService;

    @Override
    public User getUser(int userId) {
        return authenticationService.getUser(userId);
    }


    @Override
    public Map<String, List<String>> getResourceMappers() {
        return authorizationService.getResourceMappers();
    }
}
