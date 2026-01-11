package com.avdhut.api_monitoring_system.filter;

import com.avdhut.api_monitoring_system.entity.ApiLog;
import com.avdhut.api_monitoring_system.repository.ApiLogRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class ApiLoggingFilter extends OncePerRequestFilter {

    private final ApiLogRepository apiLogRepository;

    public ApiLoggingFilter(ApiLogRepository apiLogRepository) {
        this.apiLogRepository = apiLogRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        long startTime = System.currentTimeMillis();

        filterChain.doFilter(request, response); // controller executes here

        long endTime = System.currentTimeMillis();

        ApiLog log = new ApiLog();
        log.setEndpoint(request.getRequestURI());
        log.setMethod(request.getMethod());
        log.setStatusCode(response.getStatus());
        log.setResponseTimeMs(endTime - startTime);
        log.setClientIp(request.getRemoteAddr());

        apiLogRepository.save(log);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return request.getRequestURI().startsWith("/swagger")
                || request.getRequestURI().startsWith("/v3/api-docs")
                || request.getRequestURI().startsWith("/auth");
    }
}
