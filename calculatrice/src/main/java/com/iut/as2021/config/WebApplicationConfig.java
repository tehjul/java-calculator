/*package com.iut.as2021.config;

import org.springframework.context.annotation.*;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import static org.springframework.context.annotation.EnableLoadTimeWeaving.AspectJWeaving.ENABLED;

@Configuration
@ComponentScan(basePackages = { "com.iut.as2021.config", "com.iut.as2021.facade", "com.iut.as2021.dao" })
@EnableAspectJAutoProxy
@EnableSpringConfigured
@EnableLoadTimeWeaving(aspectjWeaving = ENABLED)
public class WebApplicationConfig<FilterRegistrationBean> extends WebMvcConfigurationSupport
        implements LoadTimeWeavingConfigurer {

    @Override
    public LoadTimeWeaver getLoadTimeWeaver() {
        // TODO Auto-generated method stub
        return null;
    }
}*/
