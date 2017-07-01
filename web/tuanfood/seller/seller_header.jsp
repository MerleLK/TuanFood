<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/25
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>店铺管理员页面</title>
    <link href="/static/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <!--引入jquery脚本-->
    <script src="/static/bootstrap/js/jquery-3.2.1.js" type="text/javascript"></script>
    <!--引入bootstrap脚本-->
    <script src="/static/bootstrap/js/bootstrap.js" type="text/javascript"></script>

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
                            <a href="/tuanfood/seller/seller_index.jsp">卖家首页</a>
                        </li>
                    </ul>
                    <%-- 右边题头--%>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="login">
                        </li>

                        <li class="active">
                            <a class="btn-default" href="getAllDistrictType.action">发布新商品</a>
                        </li>

                        <li class="active">
                            <a class="btn-default" href="getAllPublishProduct.action">查看所有已上架的商品</a>
                        </li>

                        <li class="active">
                            <a class="btn-default" href="getAllReview.action">查看审核的记录</a>
                        </li>
                        <li class="active">
                            <a class="btn-default" href="showSellerInfo.action">查看我的信息</a>
                        </li>

                        <li>
                            <!-- 放登陆信息 -->
                            卖家:<s:property value="#session.username"/>
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