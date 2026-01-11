package com.avdhut.api_monitoring_system.repository;

import com.avdhut.api_monitoring_system.entity.ApiLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ApiLogRepository extends JpaRepository<ApiLog, Long> {

    // 1) Slow APIs (avg response time desc)
    @Query("""
        SELECT a.endpoint, AVG(a.responseTimeMs)
        FROM ApiLog a
        GROUP BY a.endpoint
        ORDER BY AVG(a.responseTimeMs) DESC
    """)
    List<Object[]> findSlowApis();

    // 2) Error count by endpoint (4xx/5xx)
    @Query("""
        SELECT a.endpoint, COUNT(a)
        FROM ApiLog a
        WHERE a.statusCode >= 400
        GROUP BY a.endpoint
        ORDER BY COUNT(a) DESC
    """)
    List<Object[]> findErrorCountByEndpoint();

    // 3) Traffic count per endpoint
    @Query("""
        SELECT a.endpoint, COUNT(a)
        FROM ApiLog a
        GROUP BY a.endpoint
        ORDER BY COUNT(a) DESC
    """)
    List<Object[]> findTrafficStats();

    // 4) Logs in time range (for charts)
    List<ApiLog> findByCreatedAtBetween(LocalDateTime from, LocalDateTime to);

}
