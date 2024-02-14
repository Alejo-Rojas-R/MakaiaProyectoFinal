package com.makaia.MakaiaProyectoFinal.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.MockitoAnnotations.openMocks;

@SpringBootTest
@TestPropertySource(properties = {"testGorilla.base-url=http://localhost:8080"})
public class AbstractClientTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private AbstractClient abstractClient = new AbstractClient(restTemplate) {
    };

    @BeforeEach
    public void setUp() {
        openMocks(this);
    }

    @Test
    public void testBuildAuthTokenWithValidToken() {
        String token = "validToken";

        HttpHeaders headers = abstractClient.buildAuthToken(token);

        assertThat(headers.getContentType().toString()).isEqualTo("application/json");
        assertThat(headers.getFirst("Authorization")).isEqualTo("Token " + token);
    }

    @Test
    public void testBuildAuthTokenWithEmptyToken() {
        String token = "";

        HttpHeaders headers = abstractClient.buildAuthToken(token);

        assertThat(headers.getContentType().toString()).isEqualTo("application/json");
        assertThat(headers.getFirst("Authorization")).isEqualTo("Token " + token);
    }
}
