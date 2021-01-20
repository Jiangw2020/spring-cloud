package jw.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

// 启用 Feign 客户端功能
@EnableFeignClients
@SpringBootApplication
public class FeignConsumerStart {
    public static void main(String[] args) {
        SpringApplication.run(FeignConsumerStart.class, args);
    }
}
