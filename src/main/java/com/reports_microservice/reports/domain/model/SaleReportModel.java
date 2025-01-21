package com.reports_microservice.reports.domain.model;

import java.time.LocalDate;
import java.util.List;

public class SaleReportModel {

    private String id;
    private Long userId;
    private String userEmail;
    private String creationDate;
    private Double total;
    private List<SaleDetailsModel> saleDetails;
    private LocalDate saleDate;

    public SaleReportModel(String id, Long userId, String userEmail, String creationDate, Double total, List<SaleDetailsModel> saleDetails, LocalDate saleDate) {
        this.id = id;
        this.userId = userId;
        this.userEmail = userEmail;
        this.creationDate = creationDate;
        this.total = total;
        this.saleDetails = saleDetails;
        this.saleDate = saleDate;
    }

    public SaleReportModel() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<SaleDetailsModel> getSaleDetails() {
        return saleDetails;
    }

    public void setSaleDetails(List<SaleDetailsModel> saleDetails) {
        this.saleDetails = saleDetails;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }
}
