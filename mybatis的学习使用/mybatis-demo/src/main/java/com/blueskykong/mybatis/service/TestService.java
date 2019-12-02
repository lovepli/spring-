package com.blueskykong.mybatis.service;

import com.blueskykong.mybatis.entity.TestModel;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author keets
 * @data 2018/8/22.
 */
public interface TestService {


    TestModel getEntity(String id);

    Integer insertModel(TestModel testModel);

    List<TestModel> queryAllByPID(String Id);

    PageInfo<TestModel> queryPage(Integer pageNo, Integer pageSize);

}
