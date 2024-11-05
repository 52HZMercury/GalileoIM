package org.william.galileoim.common;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@SpringBootApplication(scanBasePackages = {"org.william.galileoim"})
@MapperScan({"org.william.galileoim.common.**.mapper"})
@ServletComponentScan
public class GalileoimCustomApplication {

    public static void main(String[] args) {
        SpringApplication.run(GalileoimCustomApplication.class,args);
    }

}