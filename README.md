🚀 API Monitoring \& Observability System



A production-style backend project built using Spring Boot that provides secure REST APIs with real-time monitoring, logging, rate limiting, and observability using industry-standard tools like Prometheus and Grafana.



📌 Overview



In modern backend systems, monitoring API performance and system health is critical.

This project focuses on backend observability by tracking API traffic, latency, error rates, and JVM metrics, while also ensuring security and scalability.



The system exposes metrics via Spring Boot Actuator, which are scraped by Prometheus and visualized using Grafana dashboards.



🎯 Key Features



🔐 JWT-based Authentication \& Authorization



📊 API Traffic Monitoring (per endpoint)



⏱️ Response Time \& Latency Tracking



❌ Error Rate Monitoring (4xx / 5xx)



🚦 Redis-based Rate Limiting



🗄️ API Request Logging to MySQL



📈 Prometheus Metrics Collection



📉 Grafana Dashboards for Visualization



🧪 Unit \& Controller Testing (JUnit + Mockito)



🏗️ Architecture Overview

Client (Swagger / Browser)

        ↓

Spring Boot Application

  ├── JWT Security (Spring Security)

  ├── Rate Limiting (Redis)

  ├── API Logging (MySQL)

  ├── Actuator Metrics

        ↓

Prometheus (Metrics Scraping)

        ↓

Grafana (Monitoring Dashboards)



🔐 Security Design



Stateless authentication using JWT



No session storage



Secured endpoints using Spring Security



Public endpoints:



/auth/login



/swagger-ui/\*\*



/actuator/prometheus



All business APIs require a valid JWT token



📊 Monitoring \& Observability

Prometheus



Scrapes metrics from /actuator/prometheus



Collects:



HTTP request count



Request latency



Error rates



JVM memory usage



CPU usage



Grafana (Monitoring UI)



Visual dashboards for:



API requests per second



Average response time per endpoint



Error rate trends



JVM memory \& CPU utilization



Grafana acts as the primary UI for monitoring instead of a custom frontend.



🗄️ Database Design



MySQL is used to store API logs with the following details:



Endpoint



HTTP method



Response status



Response time



Timestamp



ORM handled using JPA + Hibernate.



🚦 Rate Limiting



Implemented using Redis



Limits API requests per client/IP



Prevents API abuse and excessive traffic



🧪 Testing Strategy

Unit Testing



Frameworks: JUnit 5, Mockito



Service layer tested by mocking repositories



JWT utility tested independently



Controller Testing



Used MockMvc



Tested REST endpoints without starting full application



Security filters bypassed for isolated tests



Ensures correctness without relying on DB or Redis during tests.



🛠️ Tech Stack

Backend



Java 21



Spring Boot



Spring Security



JWT



Database \& Caching



MySQL



Redis



Monitoring



Spring Boot Actuator



Prometheus



Grafana



Testing



JUnit 5



Mockito



MockMvc



Tools



Maven



Git



Swagger OpenAPI



▶️ How to Run (Local)

mvn clean install

mvn spring-boot:run





Swagger UI:



http://localhost:8080/swagger-ui/index.html





Prometheus Metrics:



http://localhost:8080/actuator/prometheus



📸 Screenshots (Recommended)



Add screenshots to this folder:



/screenshots/





Suggested screenshots:



Grafana dashboard (API traffic + JVM metrics)



Swagger API testing



🧠 Key Learnings



Designed observability-driven backend systems



Implemented secure, stateless authentication



Integrated real-world monitoring tools



Practiced unit \& controller testing



Gained experience with production-style debugging



🧾 Resume One-Liner



Developed an API monitoring system using Spring Boot with JWT security, Redis-based rate limiting, MySQL logging, Prometheus metrics, Grafana dashboards, and comprehensive unit and controller tests.



📌 Future Enhancements



Docker Compose for full stack deployment



Alerting with Grafana



Role-based access control



API analytics dashboard



👤 Author



Avadhut Jagtap

Backend Developer | Java | Spring Boot | Observability

