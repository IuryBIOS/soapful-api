package com.example.soapful;

public class PessoaDAO {
 private int codPessoa;
 private String nomPessoa;
 public PessoaDAO(int codPessoa, String nomPessoa){
  this.codPessoa=codPessoa;
  this.nomPessoa=nomPessoa;
 }
 
 public int getCodPessoa(){
  return codPessoa;
 }
 public void setCodPessoa(int codPessoa){
  this.codPessoa=codPessoa;
 }
 public String getNomPessoa(){
  return nomPessoa;
 }
 public void setNomPessoa(String nomPessoa){
  this.nomPessoa=nomPessoa;
 }
}
