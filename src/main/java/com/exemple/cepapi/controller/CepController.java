package com.exemple.cepapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemple.cepapi.client.CepResponse;
import com.exemple.cepapi.service.CepService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("cep/api/")
@RequiredArgsConstructor
public class CepController {
    
    private final CepService service;

    @GetMapping("/{cep}")
    public ResponseEntity<CepResponse> findByCep(@PathVariable String cep){
        return ResponseEntity.ok().body(service.findByCep(cep));
    }

    @GetMapping("{uf}/{localidade}/{logradouro}")
    public ResponseEntity<CepResponse> findByAdress(@PathVariable(value = "uf") String uf, 
                                                    @PathVariable(value = "localidade") String localidade, 
                                                    @PathVariable(value = "logradouro") String logradouro){
        return ResponseEntity.ok().body(service.findByAddress(uf, localidade, logradouro));
    }

}
