package com.avdhut.api_monitoring_system.service;

import com.avdhut.api_monitoring_system.dto.SlowApiDto;
import com.avdhut.api_monitoring_system.repository.ApiLogRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MonitoringServiceTest {

    @Mock
    private ApiLogRepository apiLogRepository;

    @InjectMocks
    private MonitoringService monitoringService;

    @Test
    void shouldReturnSlowApis() {
        // GIVEN (fake data)
        when(apiLogRepository.findSlowApis())
                .thenReturn(List.<Object[]>of(
                        new Object[]{"/test/db", 150.0}
                ));

        // WHEN
        List<SlowApiDto> result = monitoringService.getSlowApis();

        // THEN
        assertThat(result).hasSize(1);
        assertThat(result.get(0).endpoint()).isEqualTo("/test/db");
        assertThat(result.get(0).avgResponseTimeMs()).isEqualTo(150.0);
    }
}
