package com.avdhut.api_monitoring_system.security;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JwtUtilTest {

    private final JwtUtil jwtUtil = new JwtUtil();

    @Test
    void shouldGenerateTokenAndExtractEmail() {
        // GIVEN
        String email = "test@gmail.com";

        // WHEN
        String token = jwtUtil.generateToken(email);
        String extractedEmail = jwtUtil.extractEmail(token);

        // THEN
        assertThat(token).isNotNull();
        assertThat(extractedEmail).isEqualTo(email);
    }
}
