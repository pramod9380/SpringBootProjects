package com.perfios.srpingdemo.AOP.aspectj_annotation;

import net.bytebuddy.asm.Advice;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class TrackEmployee {

    @Pointcut("execution(* Employee.*(..))")
    public void dumyMethod(){

    }

    @Before("dumyMethod()")
    public void myAdviceBeforeMethodExecution(){
        System.out.println("Additional concern added Before Method call!!");
    }

    @After("dumyMethod()")
    public void myAdviceAfterMethodExecution(){
        System.out.println("Additional concern added After Method call!!");
    }

    @Around("dumyMethod()")
    public void myAdviceAroundMethodExecution(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Additional concern added Before Method call!!");
        pjp.proceed();
        System.out.println("Additional concern added After Method call!!");
    }

//    @AfterThrowing(pointcut= "execution(* Employee.getEmployeeExperience(..))",throwing = " ")
    public void myAdviceAfterGettingException(Exception e){
        System.out.println("Exception "+e);
    }
}
