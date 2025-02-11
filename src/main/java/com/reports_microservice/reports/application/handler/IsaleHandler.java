package com.reports_microservice.reports.application.handler;

import com.reports_microservice.reports.application.dto.saledto.SaleReportResponse;
import com.reports_microservice.reports.application.dto.saledto.SaleRequest;

public interface IsaleHandler {

    SaleReportResponse generateReport(SaleRequest saleRequest);
}
