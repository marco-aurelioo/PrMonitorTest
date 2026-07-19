package com.tiozao.PrValidationTest.service;

import com.tiozao.PrValidationTest.domain.NovoItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClassificadorServiceTest {

    private ClassificadorService classificadorService;

    @BeforeEach
    public void setUp() {
        classificadorService = new ClassificadorService();
    }

    @Test
    public void testCreateNovoItem() {
        NovoItem item = new NovoItem("test", 20, "test_nick");
        NovoItem createdItem = classificadorService.createNovoItem(item);
        assertEquals(item.nome(), createdItem.nome());
    }

    @Test
    public void testGetItens() {
        Page<NovoItem> result = classificadorService.getItens(null, null, null, PageRequest.of(0, 10));
        assertEquals(3, result.getTotalElements());
    }

    @Test
    public void testGetItensWithFilter() {
        Page<NovoItem> result = classificadorService.getItens("item1", null, null, PageRequest.of(0, 10));
        assertEquals(2, result.getTotalElements());
        assertEquals("item1", result.getContent().get(0).nome());
    }
}
