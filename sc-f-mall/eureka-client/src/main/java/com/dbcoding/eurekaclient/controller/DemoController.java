package com.dbcoding.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: AAA
 * @Description: TODO
 * @Author: Stephen.Zhang
 * @CreateDate: 2020-05-20 16:39
 * @Version: 1.0
 **/
@RestController
public class DemoController {

    @Value("${server.port}")
    String port;

    @GetMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "dbcoding") String name) {
        return "hi " + name + " ,i am from port:" + port;
    }
}
