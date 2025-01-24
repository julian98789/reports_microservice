package com.reports_microservice.reports.infrastructure.security.adapter;

import com.reports_microservice.reports.domain.security.IAuthenticationSecurityPort;
import com.reports_microservice.reports.infrastructure.security.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

@RequiredArgsConstructor
public class AuthenticationAdapter implements IAuthenticationSecurityPort {

    private final JwtService jwtService;

    @Override
    public Long getAuthenticatedUserId() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return Long.valueOf( userDetails.getUsername());
    }

    @Override
    public String getAuthenticatedUserEmail() {
        String jwt = (String) SecurityContextHolder.getContext().getAuthentication().getCredentials();
        return jwtService.extractEmail(jwt);
    }
}
