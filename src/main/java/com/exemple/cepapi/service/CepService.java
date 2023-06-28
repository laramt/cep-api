package com.exemple.cepapi.service;

import java.util.List;

import com.exemple.cepapi.client.response.CepResponse;

public interface CepService {

    CepResponse findByCep(String cep);
    List<CepResponse> findByAddress(String uf, String localidade, String logradouro);
}
