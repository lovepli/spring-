package com.itheima.utils;

import com.itheima.service.IAccountService;

/**
 * 用于记录日志的工具类，它里面提供了公共的代码
 */
public class Logger {


    private IAccountService iAccountService;
     //set方法注入
    public void setiAccountService(IAccountService iAccountService) {
        this.iAccountService = iAccountService;
    }

    /**
     * 用于打印日志：计划让其在切入点方法执行之前执行（切入点方法就是业务层方法）
     */
    public  void printLog(){
        //System.out.println("操作处理的业务类是："+iAccountService);

        System.out.println("Logger类中的pringLog方法开始记录日志了。。。");
    }
}
