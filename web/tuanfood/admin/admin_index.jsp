<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/25
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="admin_header.jsp" %>
<body>
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
<s:if test="hasActionMessages()">
    <div class="alert alert-dismissable alert-success">
        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
        <h4>消息:</h4>
        <strong>Success--></strong><s:actionmessage/>
    </div>
</s:if>
<div class="col-md-12 column">
    <div class="col-md-1">

    </div>
    <div class="col-md-9">
        <div class="jumbotron">
            <h2>
                Welcome! 管理员:<s:property value="#session.username"/>
            </h2>
            <p>
            <h4>
                &nbsp;&nbsp;您可以做以下工作:
            </h4>
            <br>
            <h5>
                &nbsp;&nbsp;&nbsp;&nbsp;1.系统内城市管理
            </h5>
            <h5>
                &nbsp;&nbsp;&nbsp;&nbsp;2.系统内地区管理
            </h5>
            <h5>
                &nbsp;&nbsp;&nbsp;&nbsp;3.系统内美食类别管理
            </h5>
            <h5>
                &nbsp;&nbsp;&nbsp;&nbsp;4.审核团购信息
            </h5>

            <p>
                <a class="btn btn-primary btn-large" href="#">Learn more</a>
            </p>
        </div>
    </div>
    <div class="col-md-2">

    </div>

</div>
</body>
</html>
