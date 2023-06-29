<h1 align="center">ViaCEP Java API</h1>
<p align="center">
Este é um repositório para uma API Java que permite buscar informações de CEP ou endereço utilizando o serviço gratuito ViaCEP.
</p>
<p align="center">
  <a href="https://www.java.com">
    <img src="https://img.shields.io/badge/Java-17-yellow.svg">
  </a>
  <a href="https://spring.io/">
    <img src="https://img.shields.io/badge/Spring-3.1.1-green.svg">
  </a>
</p>

## Introdução

A ViaCEP Java API é uma aplicação Java que permite buscar informações de CEP ou endereço utilizando o serviço gratuito ViaCEP. Ela utiliza o Spring Framework para criar uma API RESTful simples e fácil de usar.

## Funcionalidades

As seguintes funcionalidades estão disponíveis nesta API:

- Busca de informações de CEP por número do CEP.
- Busca de informações de endereços por UF, localidade e logradouro.

## Instalação

Para executar esta API Java localmente, siga as instruções abaixo:

### Pré-requisitos

- Java Development Kit (JDK) 17 ou posterior
- Apache Maven

### Passos

1. Clone o repositório em sua máquina local:

```bash
git clone https://github.com/laramt/cep-api.git
```
2. Importe o projeto na sua IDE preferida

3. Verifique se as configurações de porta e URL do serviço ViaCEP estão corretas.

4. Construa o projeto usando o Maven e execute a aplicação.


### Como usar
Esta API possui dois endpoints disponíveis:

- `GET /cep/{cep}`: Busca informações por um CEP expecifico.
- `GET /endereco/{uf}/{localidade}/{logradouro}`: Busca informações de endereço com base nos parâmetros informados (UF, localidade e logradouro)

Exemplo de uso:

```http
GET /cep/01001000

GET /endereco/SP/São+Paulo/Avenida+Paulista

GET /endereco/SP/São%20Paulo/Avenida%20Paulista
```

A resposta será um objeto JSON contendo as informações do endereço.

## Contato
Se você tiver alguma dúvida ou feedback sobre a API ViaCEP Java, sinta-se à vontade para entrar em contato [aqui](mailto:laramnckt@gmail.com).