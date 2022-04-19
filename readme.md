[Documentação Postman](https://documenter.getpostman.com/view/904945/Uyr7JJji)  
[Referencia SOAP](https://spring.io/guides/gs/producing-web-service/)  
[Referencia REST](https://spring.io/guides/gs/rest-service/)  

## XSD

É preciso criar um xsd que determina o schema que a api SOAP irá seguir. O 
spring usa esse xsd e através do plugin jaxb2-maven-plugin cria as classes 
necessarias.  

O xsd se encontra em src/main/resources/pessoa.xsd  

Cada request e response soap deve ser criado dentro deste xsd, assim tambem
como todas as classes que serão usadas, como Pessoa no caso deste projeto,
```
<xs:complexType name="pessoa">
    <xs:sequence>
        <xs:element name="codPessoa" type="xs:int"/>
        <xs:element name="nomPessoa" type="xs:string"/>
    </xs:sequence>
</xs:complexType>
```
## Endpoint

Os endpoints são criados usando o decorador @Endpoint
```
@Endpoint
public class PessoaEndpoint {...
```
Deve-se também criar um metodo para cada request que o endpoint contem, esses
metodos devem ser decorados com os decoradores @PayloadRoot e @ResponsePayload.
```
@PayloadRoot(namespace=NAMESPACE_URI,localPart="pessoaRequest")
@ResponsePayload
public PessoaResponse pessoaRequest(@RequestPayload PessoaRequest request){...
```
As classes usadas como "PessoaReponse", "ChecarPessoaResponse" estão contidas em
target/generated-sources/jaxb e são criadas pelo plugin mencionado no topico XSD.

## Config

As configurações estão sendo setadas em src/main/java/WebServiceConfig.java e é onde
as informações referentes ao wsdl são determinadas, através dessas configurações a rota
wsdl será criada e o wsdl baseado no xsd passado no metodo "pessoaSchema".
```
@Bean
public XsdSchema pessoaSchema(){
 return new SimpleXsdSchema(new ClassPathResource("pessoa.xsd"));
}
```

## Considerações finais

Tive alguns erros com o projeto e precisei adicionar o profile abaixo no projeto para
resolve-los, mas não sei a necessidade do mesmo já que nos exemplos que eu usei ele não
era necessario.
```
<profiles>
    <profile>
        <id>java11</id>
        <activation>
            <jdk>[11,)</jdk>
        </activation>

        <dependencies>
            <dependency>
                <groupId>org.glassfish.jaxb</groupId>
                <artifactId>jaxb-runtime</artifactId>
            </dependency>
        </dependencies>
    </profile>
</profiles>
```