<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/25
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<%@include file="admin_header.jsp" %>
<body>
<div class="row clearfix">
    <s:if test="hasActionErrors()">
        <div class="alert alert-dismissable alert-warning">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
            <h4>警告！</h4>
            <strong>Warning!</strong>
            检查你的错误 <s:actionerror/>
        </div>
    </s:if>
    <div class="col-md-12 column">
        <div class="col-md-2">
        </div>
        <div class="col-md-8">
            <h3>&nbsp;&nbsp;当前系统内所有的地区如下:</h3>
            <table class="table">
                <thead>
                <tr>
                    <th>地区ID</th>
                    <th>地区名</th>
                    <th>所属城市名</th>
                    <th>动作</th>
                </tr>
                </thead>
                <tbody>
                <s:iterator value="districts" var="row" status="status">
                    <tr>
                        <th><s:property value="#row[0]"/></th>
                        <th><s:property value="#row[1]"/></th>
                        <th><s:property value="#row[2]"/></th>
                        <th><a href="#">删除</a></th>
                    </tr>
                </s:iterator>
                </tbody>
            </table>
        </div>
        <div class="col-md-2">

        </div>
    </div>
</div>
</body>
</html>
