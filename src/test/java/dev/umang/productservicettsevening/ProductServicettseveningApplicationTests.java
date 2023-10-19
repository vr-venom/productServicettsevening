package dev.umang.productservicettsevening;


import dev.umang.productservicettsevening.inheritanceExample.tableperclass.User;
import dev.umang.productservicettsevening.inheritanceExample.tableperclass.Mentor;

import dev.umang.productservicettsevening.inheritanceExample.singleclass.STMentorRepository;
import dev.umang.productservicettsevening.inheritanceExample.singleclass.STUserRepository;
import dev.umang.productservicettsevening.inheritanceExample.tableperclass.TCMentorRepository;
import dev.umang.productservicettsevening.inheritanceExample.tableperclass.TCUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServicettseveningApplicationTests {
    @Autowired
    private TCUserRepository userRepository;
    @Autowired
    private TCMentorRepository mentorRepository;
    @Test
    void contextLoads() {
    }
    @Test
    void testDifferentInheritance(){
        for(int i =1; i<=5; i++) {
            User user = new User();
            user.setEmail("user"+i+"@tst.com");
            user.setPassword("password");
            userRepository.save(user);

            Mentor mentor = new Mentor();
            mentor.setEmail("mentor"+i+"@tst.com");
            mentor.setPassword("password");
            mentor.setNumberOfSessions(2);
            mentor.setNumberOfMentees(500);
            mentorRepository.save(mentor);
        }


    }

}
