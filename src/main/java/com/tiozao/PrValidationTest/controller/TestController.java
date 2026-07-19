package com.tiozao.PrValidationTest.controller;

import com.tiozao.PrValidationTest.domain.NovoItem;
import com.tiozao.PrValidationTest.service.ClassificadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @Autowired
    private ClassificadorService service;

    @GetMapping("/API/Test")
    public ResponseEntity<Page<NovoItem>> getTest(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) Integer idade,
            @RequestParam(required = false) String nickname,
            Pageable pageable) {
        return ResponseEntity.ok(service.getItens(nome, idade, nickname, pageable));
    }

    @PostMapping("/API/Test")
    public ResponseEntity<NovoItem> createItem(@RequestBody NovoItem novoItem) {
        return ResponseEntity.ok(service.createNovoItem(novoItem));
    }
}
