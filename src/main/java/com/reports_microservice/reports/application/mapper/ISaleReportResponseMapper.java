package com.reports_microservice.reports.application.mapper;

import com.reports_microservice.reports.application.dto.saledto.SaleReportResponse;
import com.reports_microservice.reports.domain.model.SaleReportModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ISaleReportResponseMapper {

    SaleReportResponse saleReportModelToSaleReportResponse(SaleReportModel saleReportModel);

}
