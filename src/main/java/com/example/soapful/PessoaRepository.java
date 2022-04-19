package com.example.soapful;
import io.spring.guides.gs_producing_web_service.Pessoa;

public class PessoaRepository {
 static Pessoa pessoa=new Pessoa();
 public static Pessoa criarPessoa(int codPessoa,String nomPessoa){
  pessoa.setCodPessoa(codPessoa);
  pessoa.setNomPessoa(nomPessoa);
  return pessoa;
 }
 public static Pessoa checarPessoa(){
  return pessoa;
 }
 public static Pessoa atualizarPessoa(int codPessoa,String nomPessoa){
  pessoa.setCodPessoa(codPessoa);
  pessoa.setNomPessoa(nomPessoa);
  return pessoa;
 }
}
