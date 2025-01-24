package com.reports_microservice.reports.application.dto.sale_dto;

import com.reports_microservice.reports.domain.util.Util;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class SaleRequest {

    @NotNull(message = Util.ID_NOT_NULL)
    private Long id;

    @NotNull(message = Util.USER_ID_NOT_NULL)
    private Long userId;

    @NotNull(message = Util.TOTAL_NOT_NULL )
    private Double total;

    @NotNull(message = Util.CREATION_DATE_NOT_NULL)
    private LocalDate creationDate;

    @NotEmpty(message = Util.SALE_DETAILS_NOT_NULL)
    @Valid
    private List<SaleDetailsRequest> saleDetails;
}
