package com.spring.boot.webapi;

import com.spring.boot.common.utils.MessageUtils;
import com.spring.boot.entity.User;
import com.spring.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = POST, produces = "application/json;charset=UTF-8")
    public String addUser(@RequestBody User user) {
        int cnt = userService.insert(user);
        return MessageUtils.getMessage("user.add") + cnt;
    }

    @RequestMapping(value = "/{id}", method = DELETE, produces = "application/json;charset=UTF-8")
    public String deleteUser(@PathVariable Integer id) {
        int cnt = userService.delete(id);
        return MessageUtils.getMessage("user.delete") + cnt;
    }

    @RequestMapping(value = "/{id}", method = PUT, produces = "application/json;charset=UTF-8")
    public String updateUser(@PathVariable Integer id, @RequestBody User user) {
        user.setId(id);
        int cnt = userService.update(user);
        return MessageUtils.getMessage("user.update") + cnt;
    }

    @RequestMapping(value = "/{id}", method = GET, produces = "application/json;charset=UTF-8")
    public User getUserById(@PathVariable Integer id) {
        User user = userService.searchById(id);
        return user;
    }

    @RequestMapping(value = "", method = GET, produces = "application/json;charset=UTF-8")
    public List<User> getUsers() {
        List<User> users = userService.search();
        return users;
    }
}
