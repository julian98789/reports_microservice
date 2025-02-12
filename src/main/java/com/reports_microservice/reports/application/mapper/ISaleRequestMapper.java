package com.reports_microservice.reports.application.mapper;

import com.reports_microservice.reports.application.dto.saledto.SaleRequest;
import com.reports_microservice.reports.domain.model.SaleModel;
import com.reports_microservice.reports.domain.model.SaleReportModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ISaleRequestMapper {

    SaleModel saleRequestToSaleModel (SaleRequest saleRequest);

    SaleReportModel saleModelToSaleReportModel (SaleModel saleModel);
}
