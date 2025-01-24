package com.reports_microservice.reports.infrastructure.http.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.reports_microservice.reports.application.dto.sale_dto.SaleReportResponse;
import com.reports_microservice.reports.application.dto.sale_dto.SaleRequest;
import com.reports_microservice.reports.application.handler.IsaleHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class SaleReportRestControllerTest {

    @Mock
    private IsaleHandler saleHandler;

    @InjectMocks
    private SaleReportRestController saleReportRestController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Debe retornar estado Created")
    void createSaleReport_ShouldReturnCreatedStatus() {
        SaleRequest saleRequest = new SaleRequest();
        SaleReportResponse saleReportResponse = new SaleReportResponse();

        when(saleHandler.generateReport(any(SaleRequest.class))).thenReturn(saleReportResponse);

        ResponseEntity<SaleReportResponse> responseEntity = saleReportRestController.createSaleReport(saleRequest);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(saleReportResponse, responseEntity.getBody());
    }
}