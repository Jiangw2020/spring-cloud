package jw.spring.cloud.api;

import jw.spring.cloud.entity.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("provider")
public interface EmployeeRemoteService {
    @RequestMapping("/provider/get/employee/remote")
    public Employee getEmployeeRemote();

    @RequestMapping("/provider/get/emp/list/remote")
    List<Employee> getEmpListRemote(@RequestParam("keyword") String keyword);
}