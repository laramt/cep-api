package com.exemple.cepapi.service.impl;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.exemple.cepapi.client.ViaCepClient;
import com.exemple.cepapi.client.response.CepResponse;
import com.exemple.cepapi.exceptions.InvalidInputException;
import com.exemple.cepapi.service.CepService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CepServiceImpl implements CepService{

    private final ViaCepClient client;
    
    @Override
    public CepResponse findByCep(String cep) {
        validateCep(cep);
        return client.findByCep(cep);
    }

    @Override
    public List<CepResponse> findByAddress(String uf, String localidade, String logradouro) {
        return client.findByAddress(uf, encodePathSegment(localidade), logradouro);
    }

    private void validateCep(String cep) {
        if (cep == null || cep.isEmpty() || cep.isBlank()) {
            throw new InvalidInputException("Cep não pode ser nulo ou vazio.");
        }

        if (cep.length() != 8) {
            throw new InvalidInputException("Cep deve conter 8 dígitos.");
        }

        if (!Pattern.matches("\\b\\d{8}\\b", cep)) {
            throw new InvalidInputException("Cep não pode conter letras, espaços ou caracteres especiais.");
        }
    }

    private String encodePathSegment(String segment) {
        return segment.replaceAll(" ", "%20")
                .replaceAll("\\+", "%20");
    }
}
