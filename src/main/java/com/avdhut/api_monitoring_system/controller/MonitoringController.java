package com.avdhut.api_monitoring_system.controller;

import com.avdhut.api_monitoring_system.dto.ErrorStatDto;
import com.avdhut.api_monitoring_system.dto.SlowApiDto;
import com.avdhut.api_monitoring_system.dto.TrafficStatDto;
import com.avdhut.api_monitoring_system.service.MonitoringService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monitoring")
public class MonitoringController {

    private final MonitoringService service;

    public MonitoringController(MonitoringService service) {
        this.service = service;
    }

    // 1️⃣ Slow APIs
    @GetMapping("/slow-apis")
    public List<SlowApiDto> slowApis() {
        return service.getSlowApis();
    }

    // 2️⃣ Error statistics
    @GetMapping("/errors")
    public List<ErrorStatDto> errorStats() {
        return service.getErrorStats();
    }

    // 3️⃣ Traffic stats
    @GetMapping("/traffic")
    public List<TrafficStatDto> traffic() {
        return service.getTrafficStats();
    }
}
