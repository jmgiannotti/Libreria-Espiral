package com.biblioteca.libreria.api;

import com.biblioteca.libreria.models.Book;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
@Service
public class OpenLibraryApi {
    private final WebClient webClient;
    private final String apiBaseUrl = "https://openlibrary.org"; // /subjects/subject.json
    //private final String searchUrl = "https://openlibrary.org/search.json/"; // https://openlibrary.org/search.json?q=the+lord+of+the+rings

    public OpenLibraryApi(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(apiBaseUrl).build();
    }

    public Flux<Object> getBooksBySubject(String subject) {
        return webClient.get()
                .uri("/subjects/{subject}.json", subject)
                .retrieve()
                .bodyToFlux(Object.class);
    }


        }
