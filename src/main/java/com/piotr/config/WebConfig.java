package com.piotr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by jalos on 05.04.2016.
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.piotr")  // ustawiam pakiet bazowy w ktorym rozpoczynam poszukiwanie wszystkich komponentow
public class WebConfig extends WebMvcConfigurerAdapter {
// ctrl + o
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
       configurer.enable();
    }
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver= new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }
}


// skleja sciezke i zwraca widok .  wysyla do przegladarki strone
//wspierac kontroler w dzialaniu.