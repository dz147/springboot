package com.dbcoding.mall.website;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
class MallWebsiteApplicationTests {

    @Test
    void contextLoads() {

    }
    @Before
    public void init() {
        System.out.println("--------Test start---------");
    }

    @After
    public void after() {
        System.out.println("---------Test end--------");
    }

}
