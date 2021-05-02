package com.zjy.job.carrental;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;


@EnableAspectJAutoProxy
@MapperScan(basePackages = {"com.zjy.job.carrental.mapper"})
@SpringBootApplication
@EnableSwagger2
public class CarrentalApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarrentalApplication.class, args);
    }

}
