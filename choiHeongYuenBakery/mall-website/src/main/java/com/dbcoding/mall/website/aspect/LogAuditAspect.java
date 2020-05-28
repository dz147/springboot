package com.dbcoding.mall.website.aspect;

import com.dbcoding.mall.website.aspect.annotation.SystemLogs;
import com.dbcoding.mall.website.service.SellChannelAddressService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.PropertiesUtil;
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

    @Pointcut("@annotation(com.dbcoding.mall.website.aspect.annotation.SystemLogs)")
    public void aspect() {
    }

    @After("aspect()")
    public void doAfter(JoinPoint joinPoint) throws Exception {

    }

    @AfterThrowing(pointcut = "aspect()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {

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
