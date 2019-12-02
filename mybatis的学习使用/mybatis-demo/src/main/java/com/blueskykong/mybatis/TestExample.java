package com.blueskykong.mybatis;
import com.blueskykong.mybatis.dao.TestDao;
import com.blueskykong.mybatis.entity.TestModel;
import com.blueskykong.mybatis.service.impl.TestServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author: lipan
 * @date: 2019-06-19
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestExample {

    @Autowired
    private TestServiceImpl testService;

    @Autowired
    private TestDao testDao;

    @Test
    public void test() {
//        TestModel t=testService.getEntity(1);
//        System.out.println(t.toString());

        PageHelper.startPage(2, 2);
        List<TestModel> list = testDao.selectAll();
        PageInfo<TestModel> pageInfo = new PageInfo<TestModel>(list);
        List<TestModel> result = pageInfo.getList();
        for (TestModel u : result) {
            System.out.println(u.getName());
        }


    }
}
