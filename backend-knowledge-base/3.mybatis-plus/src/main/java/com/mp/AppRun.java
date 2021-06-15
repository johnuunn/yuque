package com.mp;

/**
 * @Date: 2021/6/15
 * @author: liu
 */
/**
 * 如果mapper 不在主方法同级包下，需要MapperScan
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@MapperScan("com.mp.mapper")
public class AppRun {

    public static void main(String[] args) {
        SpringApplication.run(AppRun.class, args);
    }
}