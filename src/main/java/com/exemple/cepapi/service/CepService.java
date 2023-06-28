package com.exemple.cepapi.service;

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
}
