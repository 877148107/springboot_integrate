package com.wmy.integrate;

import com.wmy.integrate.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootIntegrateDubboConsumeApplicationTests {

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
        userService.getTicket();
    }

}
