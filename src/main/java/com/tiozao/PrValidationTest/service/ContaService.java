package com.tiozao.PrValidationTest.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContaService {

    List<String> itens = new ArrayList<>();

    public void createConta(String item){
        System.out.println("Criando Conta");
        itens.add(item);
    }

    public void deleteConta(){
        System.out.println("Deletando Conta");
    }

    public List<String> getListagem(){
        return new ArrayList<>();
    }

}
