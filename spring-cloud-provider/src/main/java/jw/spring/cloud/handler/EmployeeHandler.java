package jw.spring.cloud.handler;

import jw.entity.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeHandler {
    @RequestMapping("/provider/get/employee/remote")
    public Employee getEmployeeRemote() {
        return new Employee(555, "tom555", 555.55);
    }
}
