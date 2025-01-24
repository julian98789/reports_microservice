package com.reports_microservice.reports.application.handler;

import com.reports_microservice.reports.application.dto.sale_dto.SaleReportResponse;
import com.reports_microservice.reports.application.dto.sale_dto.SaleRequest;

public interface IsaleHandler {

    SaleReportResponse generateReport(SaleRequest saleRequest);
}
