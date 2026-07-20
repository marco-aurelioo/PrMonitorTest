package com.tiozao.PrValidationTest.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContaService {

    List<String> itens = new ArrayList<>();

    public void createConta(String item){
        System.out.println("Criando Conta");
        itens.add(item);
    }

    public void deleteConta(String item){
        System.out.println("Deletando Conta");
        itens.remove(item);
    }

    public List<String> getListagem(){
        return itens;
    }

    public List<String> getListagemLike(String item){
        if (item == null || item.isEmpty()) {
            return new ArrayList<>();
        }
        return itens.stream()
                .filter(x -> x.contains(item))
                .collect(Collectors.toList());
    }

}
