package com.reports_microservice.reports.domain.usecase;

import com.reports_microservice.reports.domain.model.SaleReportModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class SaleReportModelUseCaseTest {
    
    @Test
    @DisplayName("Debe crear correctamente un modelo de reporte de venta con los valores proporcionados")
    void testSaleReportModel() {
        Long id = 1L;
        Long userId = 2L;
        Double total = 100.0;
        LocalDate creationDate = LocalDate.now();
        String userEmail = "test@example.com";

        SaleReportModel saleReportModel = new SaleReportModel(id, userId, userEmail, creationDate, total, Collections.emptyList());

        assertEquals(id, saleReportModel.getId());
        assertEquals(userId, saleReportModel.getUserId());
        assertEquals(total, saleReportModel.getTotal());
        assertEquals(creationDate, saleReportModel.getCreationDate());
        assertEquals(userEmail, saleReportModel.getUserEmail());
        assertEquals(Collections.emptyList(), saleReportModel.getSaleDetails());
    }

}