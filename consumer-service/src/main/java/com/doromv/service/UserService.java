package com.doromv.service;

import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @author Doromv
 * @create 2022-03-15-15:57
 */
@Component
public class UserService {
    //去注册中心拿到服务
    @Reference//引用
    TicketService ticketService;
    public void buyTicket(){
        String ticket = ticketService.getTicket();
        System.out.println(ticket);
    }
}
