package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 控制器类
@Controller
@RequestMapping(path="/user")
public class HelloController {

    /**
     * 入门案例
     * @return
     */
    @RequestMapping(path="/hello")
    public String sayHello(){
        System.out.println("Hello StringMVC");
        return "success";
    }

    /**
     * RequestMapping注解1
     * @return
     *  (path="") path和value作用相同
     */
    @RequestMapping(path="/testRequestMapping1")
    public String testRequestMapping(){
        System.out.println("测试RequestMapping注解1...");
        return "success";
    }

    /**
     * RequestMapping注解2
     * @return
     * params = {"username=heihei"}  对应 ?username=heihei 请求的参数和参数值
     *
     * headers = {"Accept"} 发送的请求中必须带有这个请求头，在浏览器的session中可以查看到http请求头中包含有Accept
     *
     */
    @RequestMapping(value="/testRequestMapping2",params = {"username=heihei"},headers = {"Accept"})
    public String testRequestMapping2(){
        System.out.println("测试RequestMapping注解2...");
        return "success";
    }

}
