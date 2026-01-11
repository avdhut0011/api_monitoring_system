package com.avdhut.api_monitoring_system.service;

import com.avdhut.api_monitoring_system.dto.ErrorStatDto;
import com.avdhut.api_monitoring_system.dto.SlowApiDto;
import com.avdhut.api_monitoring_system.dto.TrafficStatDto;
import com.avdhut.api_monitoring_system.repository.ApiLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitoringService {

    private final ApiLogRepository repo;

    public MonitoringService(ApiLogRepository repo) {
        this.repo = repo;
    }

    public List<SlowApiDto> getSlowApis() {
        return repo.findSlowApis().stream()
                .map(r -> new SlowApiDto(
                        (String) r[0],
                        ((Number) r[1]).doubleValue()
                ))
                .toList();
    }

    public List<ErrorStatDto> getErrorStats() {
        return repo.findErrorCountByEndpoint().stream()
                .map(r -> new ErrorStatDto(
                        (String) r[0],
                        ((Number) r[1]).longValue()
                ))
                .toList();
    }

    public List<TrafficStatDto> getTrafficStats() {
        return repo.findTrafficStats().stream()
                .map(r -> new TrafficStatDto(
                        (String) r[0],
                        ((Number) r[1]).longValue()
                ))
                .toList();
    }
}
