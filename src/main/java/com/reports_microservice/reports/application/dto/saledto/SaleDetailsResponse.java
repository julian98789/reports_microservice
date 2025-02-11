package com.reports_microservice.reports.application.dto.saledto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaleDetailsResponse {

    private Long id;

    private Long articleId;

    private Integer quantity;

    private Double price;

    private Double subtotal;

}
