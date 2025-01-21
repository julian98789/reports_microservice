package com.reports_microservice.reports.domain.api;

import com.reports_microservice.reports.domain.model.SaleModel;

public interface ISaleReportModelServicePort {

    void generateReport(SaleModel sale);
}
