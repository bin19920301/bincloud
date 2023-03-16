package com.bingo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.bingo.model.User;
import com.bingo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService orderService;

    @GetMapping("/detail")
    @SentinelResource(value = "/user/detail",
            blockHandler = "handleException",
            fallback = "fallbackException")
    public User detail(@RequestParam Long id) {
        return  orderService.getById(id);
    }

    public User handleException(@RequestParam Long id,BlockException ex){
        User user = new User();
        user.setId(0L);
        user.setName("已经被限流了");
        return user;
    }
    public User fallbackException(@RequestParam Long id,Throwable t){
        User user = new User();
        user.setId(0L);
        user.setName("这里是降级");
        return user;
    }
}
