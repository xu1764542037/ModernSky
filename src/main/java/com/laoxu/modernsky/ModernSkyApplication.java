package com.laoxu.modernsky;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.laoxu.modernsky.bll","com.laoxu.modernsky.inspect","com.laoxu.modernsky.entity","com.laoxu.modernsky.dao","com.laoxu.modernsky.controller"})
@MapperScan(basePackages = {"com.laoxu.modernsky.dao.inter"})
public class ModernSkyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModernSkyApplication.class, args);
    }

}
