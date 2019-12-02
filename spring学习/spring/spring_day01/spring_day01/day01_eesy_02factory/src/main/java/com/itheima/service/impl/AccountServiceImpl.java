package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.factory.BeanFactory;
import com.itheima.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

//    private IAccountDao accountDao = new AccountDaoImpl();   //很强的依赖关系，不好

    private IAccountDao accountDao = (IAccountDao)BeanFactory.getBean("accountDao");  //调用getbean的方法传递IAccountDao的类名accountDao，返回一个IAccountDao的Class类，需要强制转换

//    private int i = 1;

    public void  saveAccount(){
        int i = 1;
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
