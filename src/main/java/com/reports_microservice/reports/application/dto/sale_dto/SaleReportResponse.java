package com.reports_microservice.reports.application.dto.sale_dto;

import com.reports_microservice.reports.domain.model.SaleDetailsModel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class SaleReportResponse {
    private Long id;
    private Long userId;
    private String userEmail;
    private LocalDate creationDate;
    private Double total;
    private List<SaleDetailsModel> saleDetails;
}
