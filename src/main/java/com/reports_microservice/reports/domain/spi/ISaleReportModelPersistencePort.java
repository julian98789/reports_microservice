package com.reports_microservice.reports.domain.spi;

import com.reports_microservice.reports.domain.model.SaleReportModel;

public interface ISaleReportModelPersistencePort {

    SaleReportModel generateReport(SaleReportModel saleReport);
}
