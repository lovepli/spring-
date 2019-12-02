package com.blueskykong.mybatis.dao;

import com.blueskykong.mybatis.config.BaseDao;
import com.blueskykong.mybatis.entity.TestModel;
import org.apache.ibatis.annotations.Insert;

/**
 * @author keets
 * @data 2018/8/22.
 */

public interface TestDao extends BaseDao<TestModel> {


    @Insert("insert into test(id, name) values(#{id}, #{name})")
    Integer insertTestModel(TestModel testModel);
}
