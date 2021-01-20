package jw.spring.cloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class MyZuulFilter extends ZuulFilter {
    Logger logger= LoggerFactory.getLogger(MyZuulFilter.class);
    @Override
    public boolean shouldFilter() {
        // 1.获取当前 RequestContext 对象
        RequestContext context = RequestContext.getCurrentContext();
        // 2.获取当前请求对象
        HttpServletRequest request = context.getRequest();
        // 3.获取当前请求要访问的目标地址
        String servletPath = request.getServletPath();
        // 4.打印
        System.err.println("servletPath="+servletPath);
        // 5.当前方法返回值
        // true：表示应该过滤，下面继续执行 run()方法
        // false：表示不过滤，直接放行
        String signal = request.getParameter("signal");
        return "hello".equals(signal);
    }

    @Override
    public Object run() throws ZuulException {
        // 执行具体过滤逻辑
        System.err.println("run() ...");
        // 官方文档说：当前实现会忽略这个返回值，所以返回 null 即可
        return null;
    }

    @Override
    public String filterType() {
        // 返回当前过滤器类型
        // 可选类型包括：pre、route、post、static
        // 如果需要在目标微服务前面执行过滤操作，选用 pre 类型
        return "pre";
    }

    @Override
    public int filterOrder() {
        // 过滤器执行顺序
        return 0;
    }
}