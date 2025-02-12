package com.reports_microservice.reports.application.handler;

import com.reports_microservice.reports.application.dto.saledto.SaleReportResponse;
import com.reports_microservice.reports.application.dto.saledto.SaleRequest;
import com.reports_microservice.reports.application.mapper.ISaleReportResponseMapper;
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
    private final ISaleReportResponseMapper saleReportResponseMapper;


    @Override
    public SaleReportResponse generateReport(SaleRequest saleRequest) {

        SaleModel sale = saleRequestMapper.saleRequestToSaleModel(saleRequest);
        SaleReportModel saleReport = saleRequestMapper.saleModelToSaleReportModel(sale);

        return saleReportResponseMapper.saleReportModelToSaleReportResponse
                (saleReportServicePort.generateReport(saleReport));
    }
}

