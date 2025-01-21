package com.reports_microservice.reports.infrastructure.persistence.mongodb.adapter;

import com.reports_microservice.reports.domain.model.SaleReportModel;
import com.reports_microservice.reports.domain.spi.ISaleReportModelPersistencePort;
import com.reports_microservice.reports.infrastructure.persistence.mongodb.entity.SaleReportEntity;
import com.reports_microservice.reports.infrastructure.persistence.mongodb.mapper.ISaleReportEntityMapper;
import com.reports_microservice.reports.infrastructure.persistence.mongodb.repository.ISaleReportRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SaleReportAdapter implements ISaleReportModelPersistencePort {

    private final ISaleReportRepository saleReportRepository;
    private final ISaleReportEntityMapper saleReportEntityMapper;

    @Override
    public void generateReport(SaleReportModel saleReport) {

        SaleReportEntity saleReportEntity = saleReportEntityMapper.saleResportModelToSaleReportEntity(saleReport);

        saleReportRepository.save(saleReportEntity);
    }
}
