<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/25
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>系统管理员页面</title>
    <link href="/static/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <!--引入jquery脚本-->
    <script src="/static/bootstrap/js/jquery-3.2.1.js" type="text/javascript"></script>
    <!--引入bootstrap脚本-->
    <script src="/static/bootstrap/js/bootstrap.js" type="text/javascript"></script>

    <%-- city-select --%>
    <%--<link rel="stylesheet" href="/static/city-select/assets/css/bootstrap.min.css"/>--%>
    <script src="/static/city-select/assets/js/data.js"></script>
    <script src="/static/city-select/assets/js/jquery-1.11.3.min.js"></script>
    <script src="/static/city-select/dist/jquery.city.select.min.js"></script>
    <script src="/static/city-select/assets/js/prettify.js"></script>
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
                            <a href="/tuanfood/admin/admin_index.jsp">管理员首页</a>
                        </li>
                    </ul>
                    <%-- 右边题头--%>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="login">
                        </li>

                        <li class="active">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">城市管理
                                <strong class="caret"></strong></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a class="btn-default" href="/tuanfood/admin/admin_addCity.jsp">添加城市</a>
                                </li>
                                <li>
                                    <a class="btn-default" href="showCity.action">查看当前所有城市</a>
                                </li>
                                <%--<li>--%>
                                    <%--<a class="btn-default" href="#">删除城市</a>--%>
                                <%--</li>--%>
                            </ul>
                        </li>
                        <%-- todo --%>
                        <li class="active">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">地区管理
                                <strong class="caret"></strong></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a class="btn-default" href="getAllCityId.action">添加地区</a>
                                </li>
                                <li>
                                    <a class="btn-default" href="showDistrict.action">查看所有地区</a>
                                </li>
                                <%--<li>--%>
                                    <%--<a class="btn-default" href="#">删除地区</a>--%>
                                <%--</li>--%>
                            </ul>
                        </li>

                        <li class="active">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">美食类别管理
                                <strong class="caret"></strong></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a class="btn-default" href="/tuanfood/admin/admin_addFoodType.jsp">添加类别</a>
                                </li>
                                <li>
                                    <a class="btn-default" href="showFoodType.action">查看美食当前类别</a>
                                </li>
                                <%--<li>--%>
                                    <%--<a class="btn-default" href="#">删除美食类别</a>--%>
                                <%--</li>--%>
                            </ul>
                        </li>

                        <li class="active">
                            <a class="btn-default" href="showAllProduct.action">查看系统内部所有信息</a>
                        </li>

                        <li class="active">
                            <a class="btn-default" href="showAllReviewWithoutCheck.action">审核团购信息</a>
                        </li>

                        <li>
                            <!-- 放登陆信息 -->
                            管理员:<s:property value="#session.username"/>
                            <button onclick="location.href='logout'" class="btn btn-info">登出</button>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
    </div>
</div>
</body>
</html>