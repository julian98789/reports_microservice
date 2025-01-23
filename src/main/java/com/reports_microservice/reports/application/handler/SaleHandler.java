package com.reports_microservice.reports.application.handler;

import com.reports_microservice.reports.application.dto.sale_dto.SaleRequest;
import com.reports_microservice.reports.application.mapper.ISaleRequestMapper;
import com.reports_microservice.reports.domain.api.ISaleReportModelServicePort;
import com.reports_microservice.reports.domain.model.SaleModel;
import com.reports_microservice.reports.domain.model.SaleReportModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaleHandler implements IsaleHandler{

    private final ISaleReportModelServicePort saleReportServicePort;
    private final ISaleRequestMapper saleRequestMapper;

    @Override
    public void generateReport(SaleRequest saleRequest) {
        SaleModel sale = saleRequestMapper.saleRequestToSaleModel(saleRequest);
        SaleReportModel saleReport = saleRequestMapper.saleModelToSaleReportModel(sale);
        saleReportServicePort.generateReport(saleReport);
    }
}
