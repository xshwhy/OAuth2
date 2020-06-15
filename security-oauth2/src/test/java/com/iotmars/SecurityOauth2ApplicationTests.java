package com.iotmars;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = SecurityOauth2Application.class)
@RunWith(SpringRunner.class)
class SecurityOauth2ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void BCrypt() {
        String hashpw = BCrypt.hashpw("secret", BCrypt.gensalt());
        System.out.println(hashpw);
        // 校验密码
       /* boolean checkpw = BCrypt.checkpw();
        System.out.println(checkpw);*/



    }


}
