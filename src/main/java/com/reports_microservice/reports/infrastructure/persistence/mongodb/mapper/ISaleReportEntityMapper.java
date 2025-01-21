package com.reports_microservice.reports.infrastructure.persistence.mongodb.mapper;

import com.reports_microservice.reports.domain.model.SaleReportModel;
import com.reports_microservice.reports.infrastructure.persistence.mongodb.entity.SaleReportEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ISaleReportEntityMapper {

    SaleReportEntity saleResportModelToSaleReportEntity (SaleReportModel saleReport);
}
