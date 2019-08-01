package com.oldman.controller;

import com.oldman.service.KafkaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    @RequestMapping(path = {"/index", "/"})
    @ResponseBody
    public String index() {
//        KafkaService kafkaService = new KafkaService();
//        kafkaService.do_post();
        return "Hello World";
    }
}

