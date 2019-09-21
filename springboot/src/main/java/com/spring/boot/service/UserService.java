package com.spring.boot.service;

import com.spring.boot.common.utils.I18nUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.mapper.UserMapper;
import com.spring.boot.entity.User;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void insert(User user) {
        userMapper.insert(user);
    }

    /**
     * 登录验证
     *
     * @param loginName
     * @param password
     * @return
     */
    public String login(String loginName, String password) {
        if (loginName == null || "".equals(loginName) || password == null || "".equals(password)) {
            return I18nUtils.getMessage("login.error.empty");
        }
        User user = new User();
        user.setLoginName(loginName);
        user.setPassword(password);
        User users = userMapper.selectOneByCondition(user);
        if (users != null) {
            return I18nUtils.getMessage("login.success");
        }
        return I18nUtils.getMessage("login.error.password");
    }
}
