package com.reports_microservice.reports.domain.usecase;

import com.reports_microservice.reports.domain.api.ISaleReportModelServicePort;
import com.reports_microservice.reports.domain.model.SaleReportModel;
import com.reports_microservice.reports.domain.security.IAuthenticationSecurityPort;
import com.reports_microservice.reports.domain.spi.ISaleReportModelPersistencePort;

public class SaleReportModelUseCase implements ISaleReportModelServicePort {

    private final IAuthenticationSecurityPort authenticationSecurityPort;
    private final ISaleReportModelPersistencePort saleReportModelPersistencePort;

    public SaleReportModelUseCase(IAuthenticationSecurityPort authenticationSecurityPort, ISaleReportModelPersistencePort saleReportModelPersistencePort) {
        this.authenticationSecurityPort = authenticationSecurityPort;
        this.saleReportModelPersistencePort = saleReportModelPersistencePort;
    }

    @Override
    public SaleReportModel generateReport(SaleReportModel saleReport) {

        Long userId = authenticationSecurityPort.getAuthenticatedUserId();
        String email = authenticationSecurityPort.getAuthenticatedUserEmail();
        saleReport.setUserId(userId);
        saleReport.setUserEmail(email);

        return saleReportModelPersistencePort.generateReport(saleReport);

    }
}
