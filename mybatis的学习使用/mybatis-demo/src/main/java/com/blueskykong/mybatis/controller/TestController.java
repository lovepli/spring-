package com.blueskykong.mybatis.controller;

import com.alibaba.fastjson.JSON;
import com.blueskykong.mybatis.dao.TestDao;
import com.blueskykong.mybatis.entity.TestModel;
import com.blueskykong.mybatis.service.TestService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author keets
 * @data 2018/8/22.
 */
@RestController
public class TestController {
    @Autowired
    private TestDao testDao;

    @Autowired
    private TestService testService;

    @GetMapping("/entity/{id}")
    public TestModel getEntity(@PathVariable String id) {

        return testService.getEntity(id);
    }

    //@PutMapping("/entity")
    @GetMapping("/entity")
    public Integer addEntity() {

        return testService.insertModel(new TestModel("12","小强"));
    }

    //参考：https://www.jianshu.com/p/60e469e49610
    //测试：http://localhost:8080/test?pageNo=1&pageSize=10
    @RequestMapping("/test")
    public String test(Integer pageNo,Integer pageSize, Model model){
       // List<TestModel> areas = testService.queryAllByPID("0");
        List<TestModel> areas = testDao.selectAll();
        model.addAttribute("listSize",areas.size());
        System.out.println("areas---->"+ JSON.toJSONString(areas));

        PageInfo<TestModel> page = testService.queryPage(pageNo,pageSize);
        System.out.println(JSON.toJSONString(page));
        model.addAttribute("page---->", JSON.toJSONString(page));

        return "test";
    }

    @RequestMapping("/aa")
    public String testK() {

        PageHelper.startPage(2, 4);
        List<TestModel> list = testDao.selectAll();
        PageInfo<TestModel> pageInfo = new PageInfo<>(list);
        System.out.println("pageInfo:==="+pageInfo+"===");
        List<TestModel> result = pageInfo.getList();
        System.out.println("==="+result+"===");
        for (TestModel u : result) {
            System.out.println(u.getName());
        }
        return "test";
    }



}
