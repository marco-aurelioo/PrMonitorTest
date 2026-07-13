package com.tiozao.PrValidationTest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/API/Test")
    public ResponseEntity<String> getTest(){
        return ResponseEntity.ok("Sucesso");
    }

}
