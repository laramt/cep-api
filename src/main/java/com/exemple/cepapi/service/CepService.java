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

     public CepResponse findByAddress(String uf, String localidade, String logradouro) {
        List<CepResponse> responses = client.findByAddress(uf, localidade, logradouro);
        if (responses != null && !responses.isEmpty()) {
            return responses.get(0);
        }

        return null; // Return null if no response or empty response array
    }
}
