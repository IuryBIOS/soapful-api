package com.example.soapful;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.AtualizarPessoaRequest;
import io.spring.guides.gs_producing_web_service.AtualizarPessoaResponse;
import io.spring.guides.gs_producing_web_service.ChecarPessoaRequest;
import io.spring.guides.gs_producing_web_service.ChecarPessoaResponse;
import io.spring.guides.gs_producing_web_service.Pessoa;
import io.spring.guides.gs_producing_web_service.PessoaRequest;
import io.spring.guides.gs_producing_web_service.PessoaResponse;

@Endpoint
public class PessoaEndpoint {
 private static final String NAMESPACE_URI="http://spring.io/guides/gs-producing-web-service";
 @PayloadRoot(namespace=NAMESPACE_URI,localPart="pessoaRequest")
 @ResponsePayload
 public PessoaResponse pessoaRequest(@RequestPayload PessoaRequest request){
  PessoaResponse response=new PessoaResponse();
  Pessoa pessoa=PessoaRepository.criarPessoa(request.getNomPessoa());
  response.setPessoa(pessoa);
  return response;
 }
 @PayloadRoot(namespace=NAMESPACE_URI,localPart="checarPessoaRequest")
 @ResponsePayload
 public ChecarPessoaResponse checarPessoaRequest(@RequestPayload ChecarPessoaRequest request){
  ChecarPessoaResponse response=new ChecarPessoaResponse();
  Pessoa pessoa=PessoaRepository.checarPessoa(request.getCodPessoa());
  response.setPessoa(pessoa);
  return response;
 }
 @PayloadRoot(namespace=NAMESPACE_URI,localPart="atualizarPessoaRequest")
 @ResponsePayload
 public AtualizarPessoaResponse atualizarPessoaRequest(@RequestPayload AtualizarPessoaRequest request){
  AtualizarPessoaResponse response=new AtualizarPessoaResponse();
  Pessoa pessoa=PessoaRepository.atualizarPessoa(request.getCodPessoa(),request.getNomPessoa());
  response.setPessoa(pessoa);
  return response;
 }
}
