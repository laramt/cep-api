package com.exemple.cepapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.exemple.cepapi.client.CepResponse;
import com.exemple.cepapi.client.ViaCepClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CepService {

    private final ViaCepClient client;
    
    public CepResponse findByCep(String cep){
        return client.findByCep(cep);
    }

    public List<CepResponse> findByAddress(String uf, String localidade, String logradouro) {
        return client.findByAddress(uf, encodePathSegment(localidade), logradouro);
    }

    private String encodePathSegment(String segment) {
        return segment.replaceAll(" ", "%20")
                .replaceAll("\\+", "%20");
    }
}
