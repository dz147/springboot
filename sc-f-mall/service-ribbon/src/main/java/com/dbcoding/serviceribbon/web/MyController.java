package com.dbcoding.serviceribbon.web;

import com.dbcoding.serviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: AAA
 * @Description: TODO
 * @Author: Stephen.Zhang
 * @CreateDate: 2020-05-21 11:38
 * @Version: 1.0
 **/
@RestController
public class MyController {

    @Autowired
    HelloService helloService;
    @GetMapping(value = "/hi")
    public String demo(@RequestParam String name) {
        return helloService.myService( name );
    }
}
