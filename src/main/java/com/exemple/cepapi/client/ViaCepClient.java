package com.exemple.cepapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ViaCepClient", url = "https://viacep.com.br/ws/")
public interface ViaCepClient {
    
    @GetMapping("/{cep}/json")
    CepResponse findByCep(@PathVariable String cep);
}
