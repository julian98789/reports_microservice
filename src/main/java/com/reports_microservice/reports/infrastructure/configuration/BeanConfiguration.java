package com.reports_microservice.reports.infrastructure.configuration;

import com.reports_microservice.reports.domain.UseCase.SaleReportModelUseCase;
import com.reports_microservice.reports.domain.api.ISaleReportModelServicePort;
import com.reports_microservice.reports.domain.security.IAuthenticationSecurityPort;
import com.reports_microservice.reports.domain.spi.ISaleReportModelPersistencePort;
import com.reports_microservice.reports.infrastructure.persistence.mongodb.adapter.SaleReportAdapter;
import com.reports_microservice.reports.infrastructure.persistence.mongodb.mapper.ISaleReportEntityMapper;
import com.reports_microservice.reports.infrastructure.persistence.mongodb.repository.ISaleReportRepository;
import com.reports_microservice.reports.infrastructure.security.adapter.AuthenticationAdapter;
import com.reports_microservice.reports.infrastructure.security.service.JwtService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    ISaleReportModelPersistencePort saleReportModelPersistencePort(ISaleReportRepository saleReportRepository,
                                                                   ISaleReportEntityMapper saleReportEntityMapper) {
        return new SaleReportAdapter(saleReportRepository, saleReportEntityMapper);
    }

    @Bean
    public IAuthenticationSecurityPort authenticationSecurityPort(JwtService jwtService){
        return new AuthenticationAdapter(jwtService);
    }

    @Bean
    public ISaleReportModelServicePort iSaleReportModelServicePort(IAuthenticationSecurityPort authenticationSecurityPort,
                                                                   ISaleReportModelPersistencePort iSaleReportModelPersistencePort){
        return new SaleReportModelUseCase(authenticationSecurityPort, iSaleReportModelPersistencePort);

    }




}
