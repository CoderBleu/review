package cn.lauy.aspect;

import org.aspectj.lang.annotation.*;

/**
 * @author Lauy
 * @date 2021/3/27
 */
@Aspect
public class Audience {

    /*@Pointcut 注解能够在一个 @AspectJ 切面内定义可重用的切点。*/
    @Pointcut("execution(* cn.lauy.service.Performance.perform(..))")
    public void performce() { }

    /*在演出之前，观众要就坐 takeSeats() 并将手机调至静音状态 silenceCellPhones()。*/
    @Before("execution(* cn.lauy.service.Performance.perform(..))")
    public void silenceCellPhones() {
        System.out.println("Silencing cell phones");
    }

    @Before("execution(* cn.lauy.service.Performance.perform(..))")
    public void takeSeats() {
        System.out.println("Taking seats");
    }

    /*如果演出很精彩的话，观众应该会鼓掌喝彩 applause()*/
    @AfterReturning("execution(* cn.lauy.service.Performance.perform(..))")
    public void applause() {
        System.out.println("CLAP CLAP CLAP!!!");
    }

    /*如果演出没有达到观众预期的话，观众会要求退款 demandRefund()。*/
    @AfterThrowing("execution(* cn.lauy.service.Performance.perform(..))")
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }
}
