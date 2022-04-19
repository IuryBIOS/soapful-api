package com.example.soapful;
import java.util.ArrayList;

import io.spring.guides.gs_producing_web_service.Pessoa;

public class PessoaRepository {
 static ArrayList<Pessoa> pessoas=new ArrayList<>();
 private static int counter=0;
 public static Pessoa criarPessoa(String nomPessoa){
  Pessoa pessoa=new Pessoa();
  pessoa.setCodPessoa(counter);
  pessoa.setNomPessoa(nomPessoa);
  counter++;
  pessoas.add(pessoa);
  return pessoa;
 }
 public static Pessoa checarPessoa(int codPessoa){
  Pessoa response=new Pessoa();
  for (Pessoa pessoa2 : pessoas) {
   if(pessoa2.getCodPessoa()==codPessoa){
    response=pessoa2;
   }
  }
  return response;
 }
 public static Pessoa atualizarPessoa(int codPessoa,String nomPessoa){
  Pessoa response=new Pessoa();
  for (int i=0;i<pessoas.size();i++) {
   System.out.println("teste");
   if(pessoas.get(i).getCodPessoa()==codPessoa){
    Pessoa pessoaAtualizada=new Pessoa();
    pessoaAtualizada.setCodPessoa(codPessoa);
    pessoaAtualizada.setNomPessoa(nomPessoa);
    pessoas.set(i,pessoaAtualizada);
    response=pessoaAtualizada;
   }
  }
  return response;
 }
}
