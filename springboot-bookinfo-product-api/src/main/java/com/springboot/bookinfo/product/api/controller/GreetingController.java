package com.springboot.bookinfo.product.api.controller;

import com.springboot.bookinfo.details.service.GreeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类GreetingController的实现描述: GreetingController
 *
 * @author hongyang 2019-10-09 17:23
 */
@RestController
public class GreetingController {

    @Autowired
    private GreeterService greeterService;

    @RequestMapping("/sayHello")
    public String sayHello(@RequestParam(defaultValue = "Michael") String name) {
        return greeterService.sayHello(name);
    }

}
