package com.springcloud.userservice.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Swagger-ui 自动生成API测试文档
 * 1、 去https://github.com/swagger-api/swagger-ui.git 下载代码，然后把dist 复制到项目resources 目录下。
 * 2、添加依赖 io.springfox:springfox-swagger-ui:2.2.0
 *          io.springfox:springfox-swagger2:2.2.0
 * 3、创建配置文件，声明配置类注解（@Configuration），和启Swagger2@EnableSwagger2
 * 4、生成Docket bean
 * 5、启动项目，访问swagger-ui 页面
 * 访问URL：
 * http://localhost:8030/swagger-ui.html
 */

@Configuration  //配置类
@EnableSwagger2   //开启Swagger2
public class SwaggerConfiguration {

    //定义API接口映射路径  UserController类主机@RequestMapping映射的路径，加上通配符  *
    public static final String DEFAULT_INCLUDE_PARTERN = "/user/.*";
    private final Logger LOGGER = LoggerFactory.getLogger(SwaggerConfiguration.class);

    @Bean
    public Docket swaggerSpringfoxDocket(){
        LOGGER.debug("Starting Swagger");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        //用于生成对应API接口文档的描述信息
        ApiInfo apiInfo = new ApiInfo("用户管理API接口测试文档","description","version",
                "termsOfServiceUrl","contact","license","licenseUrl");
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                        .apiInfo(apiInfo)
                        .genericModelSubstitutes(ResponseEntity.class)
                        .forCodeGeneration(true)
                        .genericModelSubstitutes(ResponseEntity.class)
                        .directModelSubstitute(LocalDate.class,String.class)
                        .directModelSubstitute(ZonedDateTime.class, Date.class)
                        .directModelSubstitute(LocalDateTime.class,Date.class)
                        .select()
                        .paths(regex(DEFAULT_INCLUDE_PARTERN))
                        .build();
        stopWatch.stop();
        LOGGER.debug("Started Swagger in {} ms",stopWatch.getTotalTimeMillis());
        return docket;
    }



}
