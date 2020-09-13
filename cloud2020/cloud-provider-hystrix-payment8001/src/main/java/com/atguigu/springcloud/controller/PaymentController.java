package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import org.omg.CORBA.SetOverrideType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @Value(value="${server.port}")
    String serverPort;

    @GetMapping(value="/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result=paymentService.paymentInfo_OK(id);
        return result;
    }

    @GetMapping(value="/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        String result=paymentService.paymentInfo_TimeOut(id);
        return result;
    }

    //-------------服务熔断

    @GetMapping(value="/payment/circui/get/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        System.out.println("----------------");
        String result=paymentService.paymentCircuitBreaker(id);
        System.out.println("*****result="+result);
        return result;


    }
}
