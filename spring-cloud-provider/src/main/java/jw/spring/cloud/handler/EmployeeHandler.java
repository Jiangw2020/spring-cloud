package jw.spring.cloud.handler;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import jw.spring.cloud.entity.Employee;
import jw.spring.cloud.util.ResultEntity;
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

    private Logger logger = LoggerFactory.getLogger(EmployeeHandler.class);

    // @HystrixCommand 注解通过 fallbackMethod 属性指定断路情况下要调用的备份方法
    @HystrixCommand(fallbackMethod = "getEmpWithCircuitBreakerBackup")
    @RequestMapping("/provider/get/emp/with/circuit/breaker")
    public ResultEntity<Employee> getEmpWithCircuitBreaker(@RequestParam("signal") String signal) throws InterruptedException {
        if ("quick-bang".equals(signal)) {
            throw new RuntimeException();
        }
        if ("slow-bang".equals(signal)) {
            Thread.sleep(5000);
        }
        return ResultEntity.successWithData(new Employee(666, "sam666", 666.66));
    }

    public ResultEntity<Employee> getEmpWithCircuitBreakerBackup(@RequestParam("signal") String signal) {
        return ResultEntity.failed("circuit break workded,with signal=" + signal);
    }

    @RequestMapping("/provider/get/employee/remote")
    public Employee getEmployeeRemote() {

        return new Employee(555, "tom555", 555.55);
    }

    @RequestMapping("/provider/get/emp/list/remote")
    List<Employee> getEmpListRemote(@RequestParam("keyword") String keyword) {
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1, "empName111", 111.11));
        empList.add(new Employee(2, "empName222", 222.22));
        empList.add(new Employee(3, "empName333", 333.33));
        empList.add(new Employee(4, "empName444", 444.44));
        empList.add(new Employee(5, "empName555", 555.55));
        empList.add(new Employee(6, "empName666", 666.66));
        empList.add(new Employee(7, "empName777", 777.77));
        logger.info("keyword=============" + keyword);
        return empList;
    }
//    @RequestMapping("/provider/get/employee/remote")
//    public Employee getEmployeeRemote(HttpServletRequest request) {
//        // 获取当前 Web 应用的端口号
//        int serverPort = request.getServerPort();
//        return new Employee(555, "tom555----------"+serverPort, 555.55);
//    }
}
