package com.reports_microservice.reports.infrastructure.http.controller;

import com.reports_microservice.reports.application.dto.sale_dto.SaleReportResponse;
import com.reports_microservice.reports.application.dto.sale_dto.SaleRequest;
import com.reports_microservice.reports.application.handler.IsaleHandler;
import com.reports_microservice.reports.domain.Util.Util;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<SaleReportResponse> createSaleReport(@Valid @RequestBody SaleRequest saleRequest) {
        SaleReportResponse response = saleHandler.generateReport(saleRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
