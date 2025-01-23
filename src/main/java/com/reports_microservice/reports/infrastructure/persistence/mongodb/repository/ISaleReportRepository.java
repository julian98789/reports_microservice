package com.reports_microservice.reports.infrastructure.persistence.mongodb.repository;

import com.reports_microservice.reports.infrastructure.persistence.mongodb.entity.SaleReportEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ISaleReportRepository extends MongoRepository<SaleReportEntity,Long> {

}
