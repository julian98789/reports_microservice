package com.reports_microservice.reports.domain.spi;

import com.reports_microservice.reports.domain.model.SaleReportModel;

public interface ISaleReportModelPersistencePort {

    void generateReport(SaleReportModel saleReport);
}
