package com.lankeren.pan.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author lankeren
 * @ClassName MyWebConfig
 * @Deacription:
 * @create: 2020-06-22 11:04
 */
@Configuration
public class MyWebConfig implements WebMvcConfigurer {

    /**
     * Add handlers to serve static resources such as images, js, and, css
     * files from specific locations under web application root, the classpath,
     * and others.
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // static 文件夹下的静态资源被访问
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");

        // 映射到真实路径
        registry.addResourceHandler("/upload/**").addResourceLocations("file:E:\\JavaWorkPlace\\PersonTest\\lankerenpan\\src\\main\\resources\\upload\\");

        registry.addResourceHandler("/myFiles/**").addResourceLocations("file:/usr/local/lankeren/lankerenpan/");
    }

}
