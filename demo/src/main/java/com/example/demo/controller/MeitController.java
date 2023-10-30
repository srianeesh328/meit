package com.example.demo.controller;

import javax.print.attribute.standard.Media;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
    path = "/meit"
)
public class MeitController {

    

    @GetMapping("/")
    public @ResponseBody ResponseEntity<String> getTest(){
        return ResponseEntity.ok().body("Test passed");
    }
}
