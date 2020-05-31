package com.edv.antenados.config;

import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.support.DomainClassConverter;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    
    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return (container -> 
            {
                container.addErrorPages(new ErrorPage(HttpStatus.FORBIDDEN, "/403"));
                container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404"));
                container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500"));
            }
        );
    }
    
    @Bean
    public DomainClassConverter<FormattingConversionService> domainClassConverter(
        FormattingConversionService conversionService) {
        return new DomainClassConverter<FormattingConversionService>(conversionService);
    }
    
}
