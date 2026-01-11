package com.avdhut.api_monitoring_system.dto;

public record SlowApiDto(String endpoint, double avgResponseTimeMs) {}
