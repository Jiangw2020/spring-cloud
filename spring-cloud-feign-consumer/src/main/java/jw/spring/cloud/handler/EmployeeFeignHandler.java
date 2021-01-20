package jw.spring.cloud.handler;

import jw.spring.cloud.api.EmployeeRemoteService;
import jw.spring.cloud.entity.Employee;
import jw.spring.cloud.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeFeignHandler {
    @Autowired
    private EmployeeRemoteService employeeRemoteService;

    @RequestMapping("/feign/consumer/test/fallback")
    public ResultEntity<Employee> testFallBack(@RequestParam("signal") String signal){
        return employeeRemoteService.getEmpWithCircuitBreaker(signal);
    }
    @RequestMapping("/feign/consumer/get/emp")
    public Employee getEmployeeRemote() {
        return employeeRemoteService.getEmployeeRemote();
    }
    @RequestMapping("/feign/consumer/search")
    public List<Employee> getEmpListRemote(String keyword) {
        return employeeRemoteService.getEmpListRemote(keyword);
    }
}
