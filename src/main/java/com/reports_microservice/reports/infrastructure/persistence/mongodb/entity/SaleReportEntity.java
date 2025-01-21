package com.reports_microservice.reports.infrastructure.persistence.mongodb.entity;


import com.reports_microservice.reports.domain.model.SaleDetailsModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Document(collection = "reports")
public class SaleReportEntity {

    @MongoId
    private String id;

    @Indexed
    private String userEmail;

    @Indexed
    private String creationDate;

    @Indexed
    private Double total;

    @Indexed
    private List<SaleDetailsModel> saleDetails;

    @Indexed
    private LocalDate saleDate;
}
