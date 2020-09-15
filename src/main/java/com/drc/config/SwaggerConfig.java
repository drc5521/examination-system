package com.drc.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket docket1() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }

    @Bean
    public Docket docket2() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }

    @Bean
    public Docket docket3() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("drc")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.drc.controller"))
                //.paths(PathSelectors.ant("/drc/**"))
                .build();
    }


    public static final Contact DEFAULT_CONTACT
            = new Contact(
            "drc",
            "https://drc5521.top",
            "851041856@qq.com");

    public ApiInfo apiInfo() {

        return new ApiInfo(
                "我的小测试",
                "再难也要站起来走",
                "1.0",
                "https://drc5521.top",
                DEFAULT_CONTACT,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>());
    }
}
