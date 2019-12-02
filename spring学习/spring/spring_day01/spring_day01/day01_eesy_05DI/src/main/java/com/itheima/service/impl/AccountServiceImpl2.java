package com.itheima.service.impl;

import com.itheima.service.IAccountService;

import java.util.Date;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl2 implements IAccountService {

    //如果是经常变化的数据，并不适用于注入的方式
    private String name;
    private Integer age;
    private Date birthday;

    public void setName(String name) {  //set方法注入  依赖的数据name
        this.name = name;
    }

    public void setAge(Integer age) {  //set方法注入   依赖的数据age
        this.age = age;
    }

    public void setBirthday(Date birthday) {  //set方法注入   依赖的数据 birthday
        this.birthday = birthday;
    }

    public void  saveAccount(){
        System.out.println("service中的saveAccount方法执行了。。。"+name+","+age+","+birthday);
    }


}
