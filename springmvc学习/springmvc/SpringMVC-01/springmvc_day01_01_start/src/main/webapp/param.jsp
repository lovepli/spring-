<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/29
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
     <%-- 页面访问：http://localhost:8080/param.jsp --%>

     <%-- 请求参数绑定    传递多个参数 a=1&b=2--%>
    <%--
    <a href="param/testParam?username=hehe&password=123">请求参数绑定</a>
    --%>

         <%--把数据封装javaBean(Account类)中 :实例一  username，password等参数名应该与JavaBean中的属性相同--%>
         <%--
         <form action="param/saveAccount" method="post">
             姓名：<input type="text" name="username" /><br/>
             密码：<input type="text" name="password" /><br/>
             金额：<input type="text" name="money" /><br/>
             <input type="submit" value="提交" />
         </form>
          --%>

     <%--把数据封装javaBean(Account类)中 :实例二：有引用类型的封装--%>
    <%--
    <form action="param/saveAccount2" method="post">
        姓名：<input type="text" name="username" /><br/>
        密码：<input type="text" name="password" /><br/>
        金额：<input type="text" name="money" /><br/>
        用户姓名：<input type="text" name="user.uname" /><br/>
        用户年龄：<input type="text" name="user.age" /><br/>
        <input type="submit" value="提交" />
    </form>
     --%>


    <%--把数据封装javaBean(Account类)中 :实例三：有集合类型的封装 （类中存在list和map的集合）--%>
    <%--
    <form action="param/saveAccount3" method="post">
        姓名：<input type="text" name="username" /><br/>
        密码：<input type="text" name="password" /><br/>
        金额：<input type="text" name="money" /><br/>

        用户姓名：<input type="text" name="list[0].uname" /><br/>
        用户年龄：<input type="text" name="list[0].age" /><br/>

        用户姓名：<input type="text" name="map['one'].uname" /><br/>
        用户年龄：<input type="text" name="map['one'].age" /><br/>
        <input type="submit" value="提交" />
    </form>
    --%>

    <%-- 自定义类型转换器 实现日期转换 --%>
    <%--
    <form action="param/saveUser" method="post">
        用户姓名：<input type="text" name="uname" /><br/>
        用户年龄：<input type="text" name="age" /><br/>
        用户生日：<input type="text" name="date" /><br/>
        <input type="submit" value="提交" />
    </form>
    --%>

 <%--获取Servlet原生的API--%>
 <%--
    <a href="param/testServlet">Servlet原生的API</a>
  --%>

</body>
</html>
