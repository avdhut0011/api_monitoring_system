package com.avdhut.api_monitoring_system.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "api_logs")
public class ApiLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String endpoint;
    private int statusCode;
    private long responseTimeMs;
    private String clientIp;

    private LocalDateTime createdAt = LocalDateTime.now();
    private String method;



}

