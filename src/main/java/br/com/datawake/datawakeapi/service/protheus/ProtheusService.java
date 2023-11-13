package br.com.datawake.datawakeapi.service.protheus;

import br.com.datawake.datawakeapi.service.protheus.dto.GetSavDTO;
import br.com.datawake.datawakeapi.service.protheus.dto.ProtheusSavDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Service
public class ProtheusService {
    private final WebClient client;

    public ProtheusService(
            @Value("${app.protheus.service.url:}") String url
    ) {
        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(url);
        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.URI_COMPONENT);

        this.client = WebClient.builder()
                .uriBuilderFactory(factory)
                .baseUrl(url)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public ProtheusSavDTO getSav(String id){
        GetSavDTO response = client.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/REST/WS_LIBERACAO_VENDAS/api/v1/getSAV")
                        .queryParam("filter", String.format("projeto eq '%s'", id))
                        .build())
                .retrieve()
                .bodyToMono(GetSavDTO.class)
                .blockOptional(Duration.of(1000, ChronoUnit.MILLIS))
                .orElse(null);

        if (response == null || response.getItens() == null || response.getItens().isEmpty())
            return null;

        return response.getItens().stream().findFirst().orElse(null);
    }
}
