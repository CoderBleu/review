package cn.lauy.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author Lauy
 * @date 2021/2/2
 */
@Aspect
@Component
public class MyLogAspect {

    @Pointcut("@annotation(cn.lauy.annotation.Log)")
    public void logPointCut() {
    }

    @Before("logPointCut()")
    public void beforePrintLog() {
        System.out.println("@Before切点方法执行之前，输出日志");
    }

    @After(value = "logPointCut()")
    public void afterPrintLog() {
        System.out.println("@After在切点方法后,return前执行");
    }

    /**
     * 处理完请求后执行
     *
     * @param joinPoint 切点
     */
    @AfterReturning(pointcut = "logPointCut()", returning = "jsonResult")
    public void doAfterReturning(JoinPoint joinPoint, Object jsonResult) {
        System.out.println("@AfterReturning方法执行" + " / 访问的类方法:" + joinPoint + " / 调用业务层方法的返回:" + jsonResult);
    }

    /**
     * 拦截异常操作
     *
     * @param joinPoint 切点
     * @param e         异常
     */
    @AfterThrowing(value = "logPointCut()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Exception e) {
        System.out.println("@AfterThrowing方法执行");
    }

    @Around("execution(public String cn.lauy.controller.UserController.*(..))")
    public Object aroundPrintLog(ProceedingJoinPoint point) throws Throwable {
        Object obj = null;
        System.out.println("我是环绕通知前");
        obj = point.proceed();
        System.out.println("我是环绕通知后");
        return obj;
    }
}
