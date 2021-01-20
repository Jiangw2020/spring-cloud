package jw.spring.cloud.handler;

import jw.spring.cloud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HumanResourceHandler {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/ribbon/get/employee")
    public Employee getEmployeeRemote() {
        // 远程调用方法的主机地址
        // String host = "http://localhost:1000";

        // 引入 Eureka 和 Ribbon 后，就可以使用微服务名称替代 IP 地址+端口号
        String host = "http://provider";
        // 远程调用方法的具体 URL 地址
        String url = "/provider/get/employee/remote";
        return restTemplate.getForObject(host + url, Employee.class);
    }
}
