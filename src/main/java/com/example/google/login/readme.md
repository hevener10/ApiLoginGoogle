Projeto Spring Boot com Spring Security e OAuth2
Este projeto demonstra o uso da biblioteca Spring Boot e Spring Security para autenticação e autorização utilizando o protocolo OAuth2. Neste exemplo, o Google é utilizado como o provedor de autenticação.

Requisitos
Java 8 ou superior
Maven 3.6.0 ou superior
Uma conta Google para configurar a aplicação no Google Developer Console
Configuração
Acesse o Google Developer Console e crie um novo projeto.

No menu "APIs & Services" > "Credentials", clique em "Create Credentials" e selecione "OAuth client ID".

Escolha a aplicação do tipo "Web application", preencha o campo "Name" e adicione os URIs de redirecionamento autorizados no campo "Authorized redirect URIs". Por exemplo, http://localhost:8080/login/oauth2/code/google.

Clique em "Create" e guarde o "Client ID" e "Client Secret" gerados.

No seu projeto Spring Boot, adicione as seguintes dependências no arquivo pom.xml:

xml
Copy code
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-security</artifactId>
</dependency>
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-oauth2-client</artifactId>
</dependency>
Configure o application.properties do seu projeto Spring Boot com as informações do seu projeto no Google Developer Console:
properties
Copy code
spring.security.oauth2.client.registration.google.client-id=SEU_CLIENT_ID
spring.security.oauth2.client.registration.google.client-secret=SEU_CLIENT_SECRET
spring.security.oauth2.client.registration.google.redirect-uri={baseUrl}/login/oauth2/code/google
spring.security.oauth2.client.registration.google.scope=openid,email,profile
Implemente a configuração de segurança para a aplicação utilizando a classe WebSecurityConfigurerAdapter:
java
Copy code
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .anyRequest().authenticated()
                .and()
            .oauth2Login();
    }

}
Executando o projeto
Para executar o projeto, execute o seguinte comando no diretório raiz do projeto:

arduino
Copy code
mvn spring-boot:run
Acesse a aplicação em http://localhost:8080 e você será redirecionado para a página de login do Google.

Referências
Documentação oficial do Spring Security com OAuth2: https://docs.spring.io/spring-security/reference/servlet/oauth2/index.html
Documentação oficial do Google OpenID Connect: https://developers.google.com/identity/protocols/OpenIDConnect