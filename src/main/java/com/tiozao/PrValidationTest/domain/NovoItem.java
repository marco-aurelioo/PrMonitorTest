package com.tiozao.PrValidationTest.domain;

import java.util.UUID;

public record NovoItem(
        String id,
        String nome,
        Integer idade,
        String nickname){

        public NovoItem(String nome, Integer idade, String nickname){
                this(UUID.randomUUID().toString(), nome, idade, nickname);
        }
}
