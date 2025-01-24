package com.reports_microservice.reports.application.dto.sale_dto;

import com.reports_microservice.reports.domain.util.Util;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaleDetailsRequest {

    @NotNull(message = Util.ID_NOT_NULL)
    private Long id;

    @NotNull(message = Util.ARTICLE_ID_NOT_NULL)
    private Long articleId;

    @NotNull(message = Util.QUANTITY_NOT_NULL)
    private Integer quantity;

    @NotNull(message = Util.PRICE_NOT_NULL)
    private Double price;

    @NotNull(message = Util.SUBTOTAL_NOT_NULL)
    private Double subtotal;

}
