<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/24
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>美食团购吃吃吃</title>
    <%-- logo --%>
    <%--<link rel="icon" href="<%=basePath%>"--%>
    <%--<link rel="shortcut icon" href="static/images/merle.ico" >--%>
    <%-- 引入Bootstrap样式 --%>
    <link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <!--引入jquery脚本-->
    <script src="static/bootstrap/js/jquery-3.2.1.js" type="text/javascript"></script>
    <!--引入bootstrap脚本-->
    <script src="static/bootstrap/js/bootstrap.js" type="text/javascript"></script>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <nav class="navbar navbar-default" role="navigation">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse"
                            data-target="#bs-example-navbar-collapse-1"><span
                            class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span
                            class="icon-bar"></span><span class="icon-bar"></span></button>
                    <a class="navbar-brand" href="#">美食团购网</a>
                </div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="active">
                            <a href="index.jsp">首页</a>
                        </li>
                    </ul>
                    <%-- 右边题头--%>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="login">
                        </li>

                        <li class="active">
                            <a class="btn-default" href="login.jsp">登录</a>
                        </li>

                        <li class="active">
                            <a class="btn-default" href="register.jsp">用户注册</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
    </div>
</div>
</body>
</html>

