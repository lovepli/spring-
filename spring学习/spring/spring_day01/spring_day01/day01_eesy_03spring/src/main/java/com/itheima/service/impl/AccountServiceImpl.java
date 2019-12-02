package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

   private IAccountDao accountDao ;  //2。set方式依赖注入这个参数

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public AccountServiceImpl(){  //1。采用默认构造函数创建bean对象 默认构造函数可以不写
        System.out.println("AccountServiceImpl对象创建了");
    }


    public void  saveAccount(){
        accountDao.saveAccount();
    }
}
