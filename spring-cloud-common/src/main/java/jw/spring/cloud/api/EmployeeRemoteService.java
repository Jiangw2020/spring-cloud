package jw.spring.cloud.api;

import jw.spring.cloud.entity.Employee;
import jw.spring.cloud.factory.MyFallBackFactory;
import jw.spring.cloud.util.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
// 在@FeignClient 注解中增加 fallbackFactory 属性
// 指定 consumer 调用 provider 时如果失败所采取的备用方案
// fallbackFactory 指定 FallbackFactory 类型的类，保证备用方案返回相同类型的数据
@FeignClient(value = "provider",fallbackFactory = MyFallBackFactory.class)
public interface EmployeeRemoteService {
    @RequestMapping("/provider/get/employee/remote")
    public Employee getEmployeeRemote();

    @RequestMapping("/provider/get/emp/list/remote")
    List<Employee> getEmpListRemote(@RequestParam("keyword") String keyword);

    @RequestMapping("/provider/get/emp/with/circuit/breaker")
    public ResultEntity<Employee> getEmpWithCircuitBreaker(@RequestParam("signal") String signal);
}