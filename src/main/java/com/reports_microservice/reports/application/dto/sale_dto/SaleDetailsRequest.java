package com.reports_microservice.reports.application.dto.sale_dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaleDetailsRequest {

    private Long id;

    private Long articleId;

    private Integer quantity;

    private Double price;

    private Double subtotal;

}
