package com.reports_microservice.reports.domain.usecase;

import com.reports_microservice.reports.domain.model.SaleReportModel;
import com.reports_microservice.reports.domain.security.IAuthenticationSecurityPort;
import com.reports_microservice.reports.domain.spi.ISaleReportModelPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class SaleReportModelUseCaseTest {


    @Mock
    private IAuthenticationSecurityPort authenticationSecurityPort;

    @Mock
    private ISaleReportModelPersistencePort saleReportModelPersistencePort;

    @InjectMocks
    private SaleReportModelUseCase saleReportModelUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should set user details and call persistence when generating report")
    void shouldSetUserDetailsAndCallPersistenceWhenGeneratingReport() {

        SaleReportModel saleReport = new SaleReportModel();
        Long mockUserId = 1L;
        String mockEmail = "user@example.com";

        when(authenticationSecurityPort.getAuthenticatedUserId()).thenReturn(mockUserId);
        when(authenticationSecurityPort.getAuthenticatedUserEmail()).thenReturn(mockEmail);
        when(saleReportModelPersistencePort.generateReport(any(SaleReportModel.class))).thenReturn(saleReport);


        SaleReportModel result = saleReportModelUseCase.generateReport(saleReport);

        assertEquals(mockUserId, result.getUserId());
        assertEquals(mockEmail, result.getUserEmail());

        verify(authenticationSecurityPort, times(1)).getAuthenticatedUserId();
        verify(authenticationSecurityPort, times(1)).getAuthenticatedUserEmail();
        verify(saleReportModelPersistencePort, times(1)).generateReport(saleReport);

    }

}