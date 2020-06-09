/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edv.antenados.config;

import javax.activation.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

 /*       
 * @author teste
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    
    //aqui voce insere todos os usuarios
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("adm").password("1234").roles("adm");
    }

    
   //aqui estou dizendo para ele ignorar na verificação tudo que tem a ver com o layout
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/layout/**");
    }

    //configuração web
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http               
            .authorizeRequests()             
                //Exigir que o usuario seja adm para acessar a pagina
                .antMatchers("/recomendacao").hasRole("adm") 
                .and()             
            .formLogin()
                //permitir que todo mundo acesse o login
                .loginPage("/login").permitAll()
                .and()
            .logout()
                //comando para fazer o logout
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
                
    }
    
    
  
}
