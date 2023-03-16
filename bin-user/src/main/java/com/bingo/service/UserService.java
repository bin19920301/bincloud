package com.bingo.service;

import com.bingo.dao.UserMapper;
import com.bingo.model.User;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Resource
    private UserMapper orderMapper;


    public User getById(Long id) {
        User order = orderMapper.selectById(id);
        return order;
    }
}
