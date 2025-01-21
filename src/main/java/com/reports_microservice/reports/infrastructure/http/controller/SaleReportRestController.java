package com.reports_microservice.reports.infrastructure.http.controller;

import com.reports_microservice.reports.application.dto.sale_dto.SaleRequest;
import com.reports_microservice.reports.application.mapper.ISaleRequestMapper;
import com.reports_microservice.reports.domain.Util.Util;
import com.reports_microservice.reports.domain.api.ISaleReportModelServicePort;
import com.reports_microservice.reports.domain.model.SaleModel;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports/sale")
@RequiredArgsConstructor
public class SaleReportRestController {

    private final ISaleReportModelServicePort saleReportServicePort;
    private final ISaleRequestMapper saleRequestMapper;

    @PreAuthorize(Util.ROLE_AUX_BODEGA )
    @PostMapping
    public void createSaleReport(@RequestBody SaleRequest saleRequest) {
        SaleModel sale = saleRequestMapper.saleRequestToSaleModel(saleRequest);
        saleReportServicePort.generateReport(sale);
    }
}
