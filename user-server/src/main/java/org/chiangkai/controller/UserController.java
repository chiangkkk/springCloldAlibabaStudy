package org.chiangkai.controller;

import lombok.AllArgsConstructor;
import org.chiangkai.domain.User;
import org.chiangkai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ChiangKai
 * @date 2022/9/22
 */
@RestController
@RequestMapping("/user")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    final UserService userService;

    @GetMapping("{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @RequestMapping("/remain/{uid}")
    public Integer userRemain(@PathVariable("uid") int uid) {
        return userService.getRemain(uid);
    }

    @RequestMapping("/user/borrow/{uid}")
    public boolean userBorrow(@PathVariable("uid") int uid){
        return userService.setRemain(uid);
    }
}
