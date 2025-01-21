package com.reports_microservice.reports.domain.model;

import java.time.LocalDate;
import java.util.List;


public class SaleModel {

    private Long id;

    private Long userId;

    private Double totalAmount;

    private LocalDate creationDate;

    private List<SaleDetailsModel> saleDetails;

    public SaleModel(Long id, Double totalAmount, Long userId, LocalDate creationDate, List<SaleDetailsModel> saleDetails) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.userId = userId;
        this.creationDate = creationDate;
        this.saleDetails = saleDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public List<SaleDetailsModel> getSaleDetails() {
        return saleDetails;
    }

    public void setSaleDetails(List<SaleDetailsModel> saleDetails) {
        this.saleDetails = saleDetails;
    }
}
