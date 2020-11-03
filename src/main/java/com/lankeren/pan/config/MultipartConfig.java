package com.lankeren.pan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

/**
 * @author lankeren
 * @ClassName MultipartConfig
 * @Deacription:
 * @create: 2020-11-03 17:40
 */
@Configuration
public class MultipartConfig {


@Bean
public MultipartConfigElement multipartConfigElement(){
    // 不限制大小
    return new MultipartConfigElement("");
}

}
