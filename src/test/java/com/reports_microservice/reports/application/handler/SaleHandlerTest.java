package com.reports_microservice.reports.application.handler;

import com.reports_microservice.reports.application.dto.sale_dto.SaleReportResponse;
import com.reports_microservice.reports.application.dto.sale_dto.SaleRequest;
import com.reports_microservice.reports.application.mapper.ISaleReportResponseMapper;
import com.reports_microservice.reports.application.mapper.ISaleRequestMapper;
import com.reports_microservice.reports.domain.api.ISaleReportModelServicePort;
import com.reports_microservice.reports.domain.model.SaleModel;
import com.reports_microservice.reports.domain.model.SaleReportModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class SaleHandlerTest {

    @Mock
    private ISaleReportModelServicePort saleReportServicePort;

    @Mock
    private ISaleRequestMapper saleRequestMapper;

    @Mock
    private ISaleReportResponseMapper saleReportResponseMapper;

    @InjectMocks
    private SaleHandler saleHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Debe retornar SaleReportResponse cuando se llama a generateReport")
    void testGenerateReport() {
        SaleRequest saleRequest = new SaleRequest();
        SaleModel saleModel = new SaleModel();
        SaleReportModel saleReportModel = new SaleReportModel();
        SaleReportResponse saleReportResponse = new SaleReportResponse();

        when(saleRequestMapper.saleRequestToSaleModel(any(SaleRequest.class))).thenReturn(saleModel);
        when(saleRequestMapper.saleModelToSaleReportModel(any(SaleModel.class))).thenReturn(saleReportModel);
        when(saleReportServicePort.generateReport(any(SaleReportModel.class))).thenReturn(saleReportModel);
        when(saleReportResponseMapper.saleReportModelToSaleReportResponse(any(SaleReportModel.class))).thenReturn(saleReportResponse);

        SaleReportResponse result = saleHandler.generateReport(saleRequest);

        assertEquals(saleReportResponse, result);
    }
}