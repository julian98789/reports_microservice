package com.reports_microservice.reports.domain.security;

public interface IAuthenticationSecurityPort {
    Long getAuthenticatedUserId();
    String getAuthenticatedUserEmail();
}
