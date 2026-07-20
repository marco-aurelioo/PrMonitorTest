package com.tiozao.PrValidationTest.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContaService {

    public void createConta(){
        System.out.println("Criando Conta");
    }

    public void deleteConta(){
        System.out.println("Deletando Conta");
    }

    public List<String> getListagem(){
        return new ArrayList<>();
    }
}
