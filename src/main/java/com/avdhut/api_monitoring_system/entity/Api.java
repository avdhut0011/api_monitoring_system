package com.avdhut.api_monitoring_system.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "apis")
public class Api {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String endpoint;
    private String method;
}

