package jw.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

// 启用 Zuul 代理功能
@EnableZuulProxy
@SpringBootApplication
public class ZuulStart {
    public static void main(String[] args) {
        SpringApplication.run(ZuulStart.class, args);
    }
}