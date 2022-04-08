package com.doromv.service;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @author Doromv
 * @create 2022-03-15-15:56
 */
@Service//dubbo的service注解，可以被扫描到，在项目启动就自动注册到zookeeper
@Component//使用了dubbo之后尽量不要用service注解
public class TicketServiceImlp implements TicketService{
    @Override
    public String getTicket() {
        return "get a ticket";
    }
}
