package com.reports_microservice.reports.infrastructure.http.controller;

import com.reports_microservice.reports.application.dto.sale_dto.SaleReportResponse;
import com.reports_microservice.reports.application.dto.sale_dto.SaleRequest;
import com.reports_microservice.reports.application.handler.IsaleHandler;
import com.reports_microservice.reports.domain.util.Util;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/reports/sale")
@RequiredArgsConstructor
public class SaleReportRestController {

    private final IsaleHandler saleHandler;

    @Operation(summary = "Crear un reporte de venta", description = "Genera un nuevo reporte de venta basado en la solicitud proporcionada")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Reporte de venta creado", content = @Content(schema = @Schema(implementation = SaleReportResponse.class))),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida", content = @Content(schema = @Schema(implementation = Map.class)))
    })
    @PreAuthorize(Util.ROLE_CLIENT )
    @PostMapping
    public ResponseEntity<SaleReportResponse> createSaleReport(@Valid @RequestBody SaleRequest saleRequest) {
        SaleReportResponse response = saleHandler.generateReport(saleRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
