package com.piotr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by jalos on 05.04.2016.
 */
public class LibraryWebInitiatilizer extends AbstractAnnotationConfigDispatcherServletInitializer{
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class}; // przekazanie info ze taka klase chcemy przekazac
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebConfig.class};  // tablice klas zwraca
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};  // nawiasami inicjuemy  string tab.. stra.. 0  i 1
    //  slash kateksst  glowny aplikacji
    }
    // skonfigurowac servlet


}
