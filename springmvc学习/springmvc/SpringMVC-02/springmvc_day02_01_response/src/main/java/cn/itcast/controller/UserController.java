package cn.itcast.controller;

import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 返回String
     *
     * @return
     */
    @RequestMapping("/testString")
    public String testString(){
        System.out.println("testString方法执行了...");
        return "success";
    }


    /**
     * 返回String 实例2
     * @param model
     * @return
     */
    @RequestMapping("/testString2")
    public String testString2(Model model){
        System.out.println("testString方法执行了...");
        // 模拟从数据库中查询出User对象
        User user = new User();
        user.setUsername("美美");
        user.setPassword("123");
        user.setAge(30);
        // model对象  将user对象存储到request域中
        model.addAttribute("user",user);
        return "success";
    }

    /**
     * 是void
     * 请求转发一次请求，不用编写项目的名称  （请求转发，视图解析器不会帮你找jsp文件的路径，需要你自己去写转发的文件路径，相当于视图解析器的功能需要自己手动实现）
     * 重定向是两次请求 等于又重新发了一个新的请求  （重定向请求不到/WEB-INF/pages/success.jsp路径？？）
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("testVoid方法执行了...");
        // 1。编写请求转发的程序
        // request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);

        // 2。重定向 到index.jsp页面
        // response.sendRedirect(request.getContextPath()+"/index.jsp");

        //解决响应中文乱码 设置中文乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // 3。直接会进行响应
        response.getWriter().print("你好");  //浏览器输入http://localhost:8080/springmvc_day02_01_response/user/testVoid

        return;
    }

    /**
     * 返回ModelAndView  model-->javaBean对象 View-->页面
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        // 创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        System.out.println("testModelAndView方法执行了...");
        // 模拟从数据库中查询出User对象
        User user = new User();
        user.setUsername("小凤");
        user.setPassword("456");
        user.setAge(30);

        // 把user对象存储到mv对象中，底层也会把user对象存入到request域对象
        mv.addObject("user",user);  //存对象

        // 跳转到哪个页面
        mv.setViewName("success"); //设置视图名称，点用视图解析器，寻找到那个页面

        return mv;
    }

    /**
     * 使用关键字forward 和redirect 的方式进行转发或者重定向 框架内部已经帮你写好了怎样实现
     * @return
     */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect(){
        System.out.println("testForwardOrRedirect方法执行了...");

        // 请求的转发
        // return "forward:/WEB-INF/pages/success.jsp";

        // 重定向
        return "redirect:/index.jsp";
    }


    /**
     * 模拟ajax异步请求响应 1
     *
     */
//    @RequestMapping("/testAjax")
//    public void testAjax(@RequestBody String body){  //@RequestBody 表示接收的请求体为json字符串
//        System.out.println("testAjax方法执行了...");
//        System.out.println(body);
//    }

    /**
     * 模拟ajax异步请求响应 实例2
     * 把发送过来的json封装到一个javaBean对象当中 （json字符串中的key值需要与javaBean对象中的属性名称一致）
     * 需要倒入jackson包：将json-->javaBean javaBean-->json
     *  @RequestBody    请求为json字符串
     *  @ResponseBody ：响应的为json字符串
     *
     */
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("testAjax方法执行了...");
        // 客户端发送ajax的请求，传的是json字符串，后端把json字符串封装到user对象中
        System.out.println(user);
        // 做响应，模拟查询数据库
        user.setUsername("haha");
        user.setAge(40);
        // 做响应
        return user;
    }

}














