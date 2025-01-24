package com.reports_microservice.reports.domain.api;

import com.reports_microservice.reports.domain.model.SaleReportModel;

public interface ISaleReportModelServicePort {

    SaleReportModel generateReport(SaleReportModel sale);
}
