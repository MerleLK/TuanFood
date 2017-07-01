<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/25
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<%@include file="seller_header.jsp"%>
<body>
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
                Welcome! 卖家:<s:property value="#session.username"/>
            </h2>
            <p>
            <h4>
                &nbsp;&nbsp;您可以做以下工作:
            </h4>
            <br>
            <h5>
                &nbsp;&nbsp;&nbsp;&nbsp;1.发布新商品
            </h5>
            <h5>
                &nbsp;&nbsp;&nbsp;&nbsp;2.查看当前已发布商品
            </h5>
            <h5>
                &nbsp;&nbsp;&nbsp;&nbsp;3.查看自己审核记录
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
