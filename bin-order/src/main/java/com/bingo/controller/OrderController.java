package com.bingo.controller;

import com.bingo.model.OrderInfo;
import com.bingo.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderInfoService orderService;

    @GetMapping("/detail")
    public OrderInfo detail(@RequestParam Long id) {
        return  orderService.getById(id);
    }
}
