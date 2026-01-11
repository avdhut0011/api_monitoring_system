package com.avdhut.api_monitoring_system.controller;

import com.avdhut.api_monitoring_system.entity.ApiLog;
import com.avdhut.api_monitoring_system.repository.ApiLogRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    private final ApiLogRepository repo;

    public TestController(ApiLogRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/db")
    public String testDb() {
        ApiLog log = new ApiLog();
        log.setEndpoint("/test/db");
        log.setStatusCode(200);
        log.setResponseTimeMs(123);
        log.setClientIp("127.0.0.1");

        repo.save(log);
        return "Saved to DB";
    }
}

