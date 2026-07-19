package com.tiozao.PrValidationTest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tiozao.PrValidationTest.domain.NovoItem;
import com.tiozao.PrValidationTest.service.ClassificadorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TestController.class)
public class TestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClassificadorService classificadorService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetTest() throws Exception {
        NovoItem item = new NovoItem("test", 20, "test_nick");
        when(classificadorService.getItens(any(), any(), any(), any()))
                .thenReturn(new PageImpl<>(Collections.singletonList(item), PageRequest.of(0, 1), 1));

        mockMvc.perform(get("/API/Test"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].nome").value("test"));
    }

    @Test
    public void testCreateItem() throws Exception {
        NovoItem item = new NovoItem("test", 20, "test_nick");
        when(classificadorService.createNovoItem(any(NovoItem.class))).thenReturn(item);

        mockMvc.perform(post("/API/Test")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(item)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("test"));
    }
}
