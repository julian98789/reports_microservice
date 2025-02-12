package com.reports_microservice.reports.infrastructure.http.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.reports_microservice.reports.application.dto.saledto.SaleReportResponse;
import com.reports_microservice.reports.application.dto.saledto.SaleRequest;
import com.reports_microservice.reports.application.handler.IsaleHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SaleReportRestControllerTest {

    @Mock
    private IsaleHandler saleHandler;

    @InjectMocks
    private SaleReportRestController saleReportRestController;

    private MockMvc mockMvc;

    private SaleReportResponse saleReportResponse;
    private SaleRequest saleRequest;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());


        mockMvc = MockMvcBuilders.standaloneSetup(saleReportRestController).build();

        saleReportResponse = new SaleReportResponse();
        saleRequest = new SaleRequest();
    }

    @Test
    @DisplayName("Should return Created status when a valid SaleRequest is provided")
    void createSaleReport_ShouldReturnCreatedStatus() throws Exception {

        saleRequest.setTotal(100.0);
        saleRequest.setCreationDate(LocalDate.now());
        saleRequest.setUserId(1L);
        saleRequest.setId(1L);

        when(saleHandler.generateReport(any(SaleRequest.class))).thenReturn(saleReportResponse);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/reports/sale")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(saleRequest)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(saleReportResponse)));

        verify(saleHandler, times(1)).generateReport(any(SaleRequest.class));
    }
}