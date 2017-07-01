<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/24
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<%@include file="header.jsp" %>
<body>
<s:debug/>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <%--提示信息显示  filed error and action errror --%>
            <s:if test="hasFieldErrors()">
                <div class="alert alert-dismissable alert-warning">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                    <h4>警告！</h4>
                    <strong>Warning!</strong>
                    检查你的错误 <s:fielderror/>
                </div>
            </s:if>
            <s:if test="hasActionErrors()">
                <div class="alert alert-dismissable alert-warning">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                    <h4>警告！</h4>
                    <strong>Warning!</strong>
                    检查你的错误 <s:actionerror/>
                </div>
            </s:if>

            <div class="col-md-12 column">
                <h2>欢迎来到登录页面.......</h2>
                <br>
                <div class="row clearfix">
                    <div class="col-md-2">

                    </div>
                    <div class="col-md-6">
                        <form action="login.action" id="loginForm" role="form" method="post">
                            <div class="form-group">
                                <label for="username">请输入用户名:</label>
                                <input type="text" class="form-control" id="username" name="username"/>
                            </div>
                            <div class="form-group">
                                <label for="password">请输入密码:</label>
                                <input type="password" class="form-control" id="password" name="password"/>
                            </div>
                            <button type="submit" class="btn btn-default" name="submit">登录</button>
                        </form>
                    </div>
                    <div class="col-md-4">

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>