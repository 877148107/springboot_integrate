package com.wmy.integrate;

import com.wmy.integrate.reposity.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootIntegratSecurityApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Test
    void contextLoads() {
        System.out.println(userRepository.findById(1));
    }

}
