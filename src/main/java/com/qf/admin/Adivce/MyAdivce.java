package com.qf.admin.Adivce;

public class MyAdivce {
    public void before(){
        System.out.println("前置增强");
    }
    public void afterReturning(){
        System.out.println("后置增强");
    }
    public void afterException(){
        System.out.println("异常增强!");
    }
    public void after(){
        System.out.println("后置!");
    }
}
