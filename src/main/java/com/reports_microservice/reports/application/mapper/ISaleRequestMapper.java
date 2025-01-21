package com.reports_microservice.reports.application.mapper;

import com.reports_microservice.reports.application.dto.sale_dto.SaleRequest;
import com.reports_microservice.reports.domain.model.SaleModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ISaleRequestMapper {

    SaleModel saleRequestToSaleModel (SaleRequest saleRequest);
}
