package dev.umang.productservicettsevening.clients.AuthenticationClient;

import dev.umang.productservicettsevening.clients.AuthenticationClient.dtos.ValidateTokenRequestDto;
import dev.umang.productservicettsevening.clients.AuthenticationClient.dtos.ValidateTokenResponseDtos;
import dev.umang.productservicettsevening.clients.fakeStoreApi.FakeStoreProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class AuthenticationClient {
    private RestTemplateBuilder restTemplateBuilder;

    public AuthenticationClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }
    public ValidateTokenResponseDtos validate(String token, Long userId){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ValidateTokenRequestDto request = new ValidateTokenRequestDto();
        request.setToken(token);
        request.setUserId(userId);

        ResponseEntity<ValidateTokenResponseDtos> l = restTemplate.postForEntity(
                "http://localhost:9000/auth/validate",
                request,
                ValidateTokenResponseDtos.class

        );
        return l.getBody();
    }
}
