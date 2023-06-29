package com.exemple.cepapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exemple.cepapi.client.response.CepResponse;
import com.exemple.cepapi.service.CepService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("cep/api/")
@RequiredArgsConstructor
public class CepController {
    
    private final CepService service;

    @GetMapping("cep/{cep}")
    public ResponseEntity<CepResponse> findByCep(@PathVariable String cep){
        return ResponseEntity.ok().body(service.findByCep(cep));
    }

    @GetMapping("endereco/")
    public ResponseEntity<List<CepResponse>> findByAddress(@RequestParam(value = "uf") String uf, 
                                                        @RequestParam(value = "localidade") String localidade, 
                                                        @RequestParam(value = "logradouro") String logradouro){
        return ResponseEntity.ok().body(service.findByAddress(uf, localidade, logradouro));
    }
}
