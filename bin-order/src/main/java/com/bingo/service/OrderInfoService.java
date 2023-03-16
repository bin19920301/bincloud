package com.bingo.service;

import com.bingo.dao.OrderInfoMapper;
import com.bingo.model.OrderInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrderInfoService {

    @Resource
    private OrderInfoMapper orderMapper;


    public OrderInfo getById(Long id) {
        OrderInfo order = orderMapper.selectById(id);
        return order;
    }
}
