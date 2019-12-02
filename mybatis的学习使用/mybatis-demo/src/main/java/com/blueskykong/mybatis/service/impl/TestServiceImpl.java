package com.blueskykong.mybatis.service.impl;

import com.blueskykong.mybatis.dao.TestDao;
import com.blueskykong.mybatis.entity.TestModel;
import com.blueskykong.mybatis.service.TestService;
import com.github.pagehelper.PageHelper;  //分页查询
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author keets
 * @data 2018/8/22.
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Override
    public TestModel getEntity(String id) {
        return testDao.selectByPrimaryKey(id);
    }

    @Override
    public Integer insertModel(TestModel testModel) {

        return testDao.insertTestModel(testModel);
    }

    /**
     * 什么意思？？
     * @param Id
     * @return
     */
//    @Override
//    public List<TestModel> queryAllByPID(Integer Id) {
//        TestModel area = new TestModel();
//        area.setId(Id);
//        return testDao.select(area);
//    }

    @Override
    public List<TestModel> queryAllByPID(String Id) {
        TestModel area = new TestModel();
        area.setId(Id);
        return testDao.select(area);
    }

    /**
     * 分页
     * @param pageNo
     * @param pageSize
     * @param
     * @return
     *
     * 分页 查询总数 不返回大于页码的数据
     * PageHelper.startPage(page,pageSize ,true,false);
     * 分页 查询总数 如果页码大于最大页，返回最后一页数据
     * PageHelper.startPage(page,pageSize ,true,true);
     *
     * //PageHelper.startPage(pageNum, pageSize)
     * PageHelper.startPage(pageNum, pageSize, count)
     * PageHelper.startPage(pageNum, pageSize, count, reasonable)
     * PageHelper.startPage(pageNum, pageSize, count, reasonable, pageSizeZero)
     * 参数说明
     * pageNum 页码
     * pageSize 每页显示数量
     * count 是否进行count查询
     * reasonable 分页合理化,null时用默认配置
     * pageSizeZero true且pageSize=0时返回全部结果，false时分页,null时用默认配置
     * PageInfo page = new PageInfo(list);
     * //PageInfo全部属性
     * //PageInfo包含了非常全面的分页属性
     * page.getPageNum();
     * page.getPageSize();
     * page.getStartRow();
     * page.getEndRow();
     * page.getTotal();
     * page.getPages();
     * page.getFirstPage();
     * page.getLastPage();
     * page.isIsFirstPage();
     * page.isIsLastPage();
     * page.isHasPreviousPage();
     * page.isHasNextPage();
     *
     */
    @Override
    public PageInfo<TestModel> queryPage(Integer pageNo, Integer pageSize) {

        PageHelper.startPage(pageNo,pageSize);
        //获取第几页 几条内容 默认查询总数count   //PageHelper只对紧跟着的第一个SQL语句起作用 //后面的不会被分页，除非再次调用PageHelper.startPage
        //List<TestModel> list = this.queryAllByPID(Id);
        List<TestModel> list =  testDao.selectAll();
        return new PageInfo<>(list);
    }
}
