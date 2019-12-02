package com.itheima.dao.impl;

import com.itheima.dao.IAccountDao;

/**
 * 账户的持久层实现类
 */
public class AccountDaoImpl implements IAccountDao {

    public AccountDaoImpl() {  //采用默认构造函数创建bean对象 默认构造函数可以不写
        System.out.println("AccountDaoImpl对象创建了");
    }

    public  void saveAccount(){

        System.out.println("保存了账户");
    }
}
