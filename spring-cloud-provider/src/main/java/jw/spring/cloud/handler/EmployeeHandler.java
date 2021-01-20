package jw.spring.cloud.handler;

import jw.spring.cloud.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeHandler {

    private Logger logger= LoggerFactory.getLogger(EmployeeHandler.class);
    @RequestMapping("/provider/get/employee/remote")
    public Employee getEmployeeRemote() {

        return new Employee(555, "tom555", 555.55);
    }
    @RequestMapping("/provider/get/emp/list/remote")
    List<Employee> getEmpListRemote(@RequestParam("keyword") String keyword){
        List<Employee> empList=new ArrayList<>();
        empList.add(new Employee(1,"empName111",111.11));
        empList.add(new Employee(2,"empName222",222.22));
        empList.add(new Employee(3,"empName333",333.33));
        empList.add(new Employee(4,"empName444",444.44));
        empList.add(new Employee(5,"empName555",555.55));
        empList.add(new Employee(6,"empName666",666.66));
        empList.add(new Employee(7,"empName777",777.77));
        logger.info("keyword============="+keyword);
        return empList;
    }
//    @RequestMapping("/provider/get/employee/remote")
//    public Employee getEmployeeRemote(HttpServletRequest request) {
//        // 获取当前 Web 应用的端口号
//        int serverPort = request.getServerPort();
//        return new Employee(555, "tom555----------"+serverPort, 555.55);
//    }
}
