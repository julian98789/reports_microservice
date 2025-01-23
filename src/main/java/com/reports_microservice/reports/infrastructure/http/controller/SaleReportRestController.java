package com.reports_microservice.reports.infrastructure.http.controller;

import com.reports_microservice.reports.application.dto.sale_dto.SaleRequest;
import com.reports_microservice.reports.application.handler.IsaleHandler;
import com.reports_microservice.reports.domain.Util.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reports/sale")
@RequiredArgsConstructor
public class SaleReportRestController {

    private final IsaleHandler saleHandler;

    @PreAuthorize(Util.ROLE_CLIENT )
    @PostMapping
    public void createSaleReport(@RequestBody SaleRequest saleRequest) {
        saleHandler.generateReport(saleRequest);
    }
}
