package com.springboot.bookinfo.product.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类HealthController的实现描述: 健康检查的API
 *
 * @author hongyang 2019-10-08 19:44
 */
@RestController
public class HealthController {

    @RequestMapping("/health/status")
    public String healthCheck() {
        return "success";
    }

}
