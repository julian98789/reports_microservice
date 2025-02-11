package com.reports_microservice.reports.infrastructure.persistence.mongodb.adapter;

import com.reports_microservice.reports.domain.model.SaleReportModel;
import com.reports_microservice.reports.infrastructure.persistence.mongodb.entity.SaleReportEntity;
import com.reports_microservice.reports.infrastructure.persistence.mongodb.mapper.ISaleReportEntityMapper;
import com.reports_microservice.reports.infrastructure.persistence.mongodb.repository.ISaleReportRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class SaleReportAdapterTest {

    @Mock
    private ISaleReportRepository saleReportRepository;

    @Mock
    private ISaleReportEntityMapper saleReportEntityMapper;

    @InjectMocks
    private SaleReportAdapter saleReportAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should return SaleReportModel when generateReport is called")
    void shouldReturnSaleReportModelWhenGenerateReportIsCalled() {

        SaleReportModel saleReportModel = new SaleReportModel();
        SaleReportEntity saleReportEntity = new SaleReportEntity();

        when(saleReportEntityMapper.saleResportModelToSaleReportEntity(any(SaleReportModel.class))).thenReturn(saleReportEntity);
        when(saleReportRepository.save(any(SaleReportEntity.class))).thenReturn(saleReportEntity);
        when(saleReportEntityMapper.saleReportEntityToSaleReportModel(any(SaleReportEntity.class))).thenReturn(saleReportModel);

        SaleReportModel result = saleReportAdapter.generateReport(saleReportModel);

        assertEquals(saleReportModel, result);

        verify(saleReportEntityMapper).saleResportModelToSaleReportEntity(saleReportModel);
        verify(saleReportRepository).save(saleReportEntity);
        verify(saleReportEntityMapper).saleReportEntityToSaleReportModel(saleReportEntity);
    }
}