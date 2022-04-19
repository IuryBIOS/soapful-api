package com.example.soapful;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.spring.guides.gs_producing_web_service.Pessoa;

@RestController
public class PessoaController {
 @GetMapping("/pessoa")
 public Pessoa pessoa(@RequestParam(value="nomPessoa") String nomPessoa){
  Pessoa pessoa=PessoaRepository.criarPessoa(nomPessoa);
  return pessoa;
 }
 @GetMapping("/checaPessoa")
 public Pessoa checkPessoa(@RequestParam(value="codPessoa") int codPessoa){
  Pessoa pessoa=PessoaRepository.checarPessoa(codPessoa);
  return pessoa;
 }
 @RequestMapping(
   path="/atualizarPessoa",
   method=RequestMethod.GET, 
   produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
 public Pessoa atualizarPessoa(@RequestParam(value="codPessoa") int codPessoa,@RequestParam(value="nomPessoa") String nomPessoa){
  Pessoa pessoa=PessoaRepository.atualizarPessoa(codPessoa,nomPessoa);
  return pessoa;
 }
 @RequestMapping(
   path="/pessoaXML",
   method=RequestMethod.GET, 
   produces={MediaType.APPLICATION_XML_VALUE})
 public Pessoa pessoaXML(@RequestParam(value="nomPessoa") String nomPessoa){
  Pessoa pessoa=PessoaRepository.criarPessoa(nomPessoa);
  return pessoa;
 }
 @RequestMapping(
   path="/checaPessoaXML",
   method=RequestMethod.GET, 
   produces={MediaType.APPLICATION_XML_VALUE})
 public Pessoa checkPessoaXML(@RequestParam(value="codPessoa") int codPessoa){
  Pessoa pessoa=PessoaRepository.checarPessoa(codPessoa);
  return pessoa;
 }
 @RequestMapping(path="/atualizarPessoaXML",method=RequestMethod.GET, produces={MediaType.APPLICATION_XML_VALUE})
 public Pessoa atualizarPessoaXML(@RequestParam(value="codPessoa") int codPessoa,@RequestParam(value="nomPessoa") String nomPessoa){
  Pessoa pessoa=PessoaRepository.atualizarPessoa(codPessoa,nomPessoa);
  return pessoa;
 }
 
 
}
