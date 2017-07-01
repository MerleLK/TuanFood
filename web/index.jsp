<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/24
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<%@include file="header.jsp" %>
<body>
<div class="container">
    <div class="row clearfix">
        <s:if test="hasActionMessages()">
            <div class="alert alert-dismissable alert-success">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                <h4>消息:</h4>
                <strong>Success--></strong><s:actionmessage/>
            </div>
        </s:if>
        <div class="col-md-12 column">
            <div class="jumbotron">
                <h1>
                    Welcome!
                </h1>
                <p>
                    欢迎来到美食团购网站......请您登录
                </p>
                <p>
                    <a class="btn btn-primary btn-large" href="#">Learn more</a>
                </p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
