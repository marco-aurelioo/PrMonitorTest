package com.tiozao.PrValidationTest.service;

import com.tiozao.PrValidationTest.domain.NovoItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ClassificadorService {

    private final Map<String, NovoItem> listaItens = new HashMap<>();

    public ClassificadorService() {
        // Pre-populating the map with some data
        NovoItem item1 = new NovoItem("item1", 25, "nick1");
        NovoItem item2 = new NovoItem("item2", 30, "nick2");
        NovoItem item3 = new NovoItem("item1", 30, "nick3");
        listaItens.put(item1.id(), item1);
        listaItens.put(item2.id(), item2);
        listaItens.put(item3.id(), item3);
    }

    public NovoItem createNovoItem(NovoItem novoItem) {
        NovoItem adicionado = new NovoItem(novoItem.nome(), novoItem.idade(), novoItem.nickname());
        listaItens.put(adicionado.id(), adicionado);
        return adicionado;
    }

    public Page<NovoItem> getItens(String nome, Integer idade, String nickname, Pageable pageable) {
        List<NovoItem> filteredList = listaItens.values().stream()
                .filter(item -> nome == null || item.nome().equalsIgnoreCase(nome))
                .filter(item -> idade == null || item.idade().equals(idade))
                .filter(item -> nickname == null || item.nickname().equalsIgnoreCase(nickname))
                .collect(Collectors.toList());

        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), filteredList.size());

        List<NovoItem> pageContent = (start > filteredList.size()) ? Collections.emptyList() : filteredList.subList(start, end);

        return new PageImpl<>(pageContent, pageable, filteredList.size());
    }
}
