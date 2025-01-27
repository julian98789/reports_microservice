package com.reports_microservice.reports.application.handler;

import com.reports_microservice.reports.application.dto.sale_dto.SaleDetailsRequest;
import com.reports_microservice.reports.application.dto.sale_dto.SaleReportResponse;
import com.reports_microservice.reports.application.dto.sale_dto.SaleRequest;
import com.reports_microservice.reports.application.mapper.ISaleReportResponseMapper;
import com.reports_microservice.reports.application.mapper.ISaleRequestMapper;
import com.reports_microservice.reports.domain.api.ISaleReportModelServicePort;
import com.reports_microservice.reports.domain.model.SaleModel;
import com.reports_microservice.reports.domain.model.SaleReportModel;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaleHandler implements IsaleHandler{

    private final ISaleReportModelServicePort saleReportServicePort;
    private final ISaleRequestMapper saleRequestMapper;
    private final ISaleReportResponseMapper saleReportResponseMapper;

    private static final Logger logger = LoggerFactory.getLogger(SaleHandler.class);

    @Override
    public SaleReportResponse generateReport(SaleRequest saleRequest) {
        logger.info("SaleRequest details - id: {}, userId: {}, total: {}, creationDate: {}",
                saleRequest.getId(), saleRequest.getUserId(), saleRequest.getTotal(), saleRequest.getCreationDate());
        SaleModel sale = saleRequestMapper.saleRequestToSaleModel(saleRequest);
        SaleReportModel saleReport = saleRequestMapper.saleModelToSaleReportModel(sale);

        return saleReportResponseMapper.saleReportModelToSaleReportResponse
                (saleReportServicePort.generateReport(saleReport));
    }
}

