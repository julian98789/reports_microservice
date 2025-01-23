package com.reports_microservice.reports.domain.api;

import com.reports_microservice.reports.domain.model.SaleModel;
import com.reports_microservice.reports.domain.model.SaleReportModel;

public interface ISaleReportModelServicePort {

    void generateReport(SaleReportModel sale);
}
