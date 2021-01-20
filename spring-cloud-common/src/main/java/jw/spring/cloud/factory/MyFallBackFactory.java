package jw.spring.cloud.factory;

import feign.hystrix.FallbackFactory;
import jw.spring.cloud.api.EmployeeRemoteService;
import jw.spring.cloud.entity.Employee;
import jw.spring.cloud.util.ResultEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

// 请注意自动扫描包的规则
// 比如：feign-consumer 工程需要使用 MyFallBackFactory，那么 MyFallBackFactory 应该在 feign-consumer 工程的主启动类所在包或它的子包下
// 简单来说：哪个工程用这个类，哪个工程必须想办法扫描到这个类
@Component
public class MyFallBackFactory implements FallbackFactory<EmployeeRemoteService> {
    // cause 对象是失败原因对应的异常对象
    @Override
    public EmployeeRemoteService create(Throwable cause) {
        return new EmployeeRemoteService() {

            @Override
            public Employee getEmployeeRemote() {
                return null;
            }

            @Override
            public List<Employee> getEmpListRemote(String keyword) {
                return null;
            }

            @Override
            public ResultEntity<Employee> getEmpWithCircuitBreaker(String signal) {
                return ResultEntity.failed("降级机制生效"+cause.getMessage());
            }

        };
    }
}