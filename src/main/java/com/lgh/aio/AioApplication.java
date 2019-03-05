package com.lgh.aio;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.lgh.aio.mapper")
public class AioApplication {

    public static void main(String[] args) {
        SpringApplication.run(AioApplication.class, args);
    }

}
