package com.doromv;

import com.doromv.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;

@SpringBootTest
class ConsumerServiceApplicationTests {
@Autowired
    UserService userService;
    @Test
    void contextLoads() {
        userService.buyTicket();
    }


}
