package org.william.galileoIM.common;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@SpringBootApplication(scanBasePackages = {"org.william.galileoIM"})
@MapperScan({"org.william.galileoIM.common.**.mapper"})
@ServletComponentScan
public class GalileoIMCustomApplication {

    public static void main(String[] args) {
        SpringApplication.run(GalileoIMCustomApplication.class,args);
    }

}