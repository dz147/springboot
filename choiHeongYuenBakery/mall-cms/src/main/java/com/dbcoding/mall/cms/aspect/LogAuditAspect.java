package com.dbcoding.mall.cms.aspect;

import com.dbcoding.mall.cms.aspect.annotation.SystemLogs;
import com.dbcoding.mall.cms.service.SellChannelAddressService;
import com.dbcoding.mall.utils.PropertiesUtil;
import com.dbcoding.mall.utils.RequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: AAA
 * @Description: TODO
 * @Author: Stephen.Zhang
 * @CreateDate: 2020-05-15 09:37
 * @Version: 1.0
 **/
@Aspect
@Component
@Slf4j
public class LogAuditAspect {
    private String LOG_AUDIT_MESSAGE = "log_audit.properties";
    @Autowired
    private SellChannelAddressService sellService;

    //切入点使用自定义注解 SystemLogs
    @Pointcut("@annotation(com.dbcoding.mall.cms.aspect.annotation.SystemLogs)")
    public void aspect() {
    }

    //后置通知
    @After("aspect()")
    public void doAfter(JoinPoint joinPoint) {
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            Map<String, Object> map = null;
            map = getControllerMethodDescription(joinPoint);
            String key = (String) map.get("key");
            String description = PropertiesUtil.getProperties(this.LOG_AUDIT_MESSAGE, key);
            log.info(key);//key Value
            log.info(description);//描述
            log.info(RequestUtil.getRealIp(request));//IP
            log.info(request.getRequestURI());//请求具体URL
            log.info(request.getMethod());//请求方法 GET...
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.getMessage());
        }
    }

    //异常通知
    @AfterThrowing(pointcut = "aspect()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        log.info("Enter the abnormal log...");
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                    .getRequest();
            Map<String, Object> map = getControllerMethodDescription(joinPoint);
            String key = (String) map.get("key");
            String description = PropertiesUtil.getProperties(this.LOG_AUDIT_MESSAGE, key);
            log.info(key);//注解value值
            log.info(description);//描述
            log.info(RequestUtil.getRealIp(request));//IP
            log.info(request.getRequestURI());//请求具体URL
            log.info(request.getMethod());//请求方法 GET...
            log.info(e.getMessage());//异常消息
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    private Map<String, Object> getControllerMethodDescription(JoinPoint joinPoint) throws Exception {
        Map<String, Object> map = new HashMap();
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    map.put("key", ((SystemLogs) method.getAnnotation(SystemLogs.class)).key());
                    break;
                }
            }
        }
        return map;
    }
}
