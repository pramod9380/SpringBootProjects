package com.perfios.srpingdemo.AOP;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundAdvisor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        System.out.println("Method called before actual logic!!!!!!!");
        Object obj = invocation.proceed();
        System.out.println("Method called after actual logic!!!!!!!!");
        return obj;
    }
}
