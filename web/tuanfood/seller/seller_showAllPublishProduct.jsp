<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/26
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<%@include file="seller_header.jsp"%>
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
        <div class="col-md-1">
        </div>
        <div class="col-md-10">
            <h3>&nbsp;&nbsp;当前您发布成功上架的商品如下:</h3>
            <table class="table">
                <thead>
                <tr><%-- 点击显示详细信息 todo --%>
                    <th>商品ID</th>
                    <th>商品名</th>
                    <th>图片</th>
                    <th>商品价格</th>
                    <th>商品库存</th>
                    <th>商品售量</th>
                    <th>商品简介</th>
                </tr>
                </thead>
                <tbody>
                <s:iterator value="products" var="row" status="status">
                    <tr>
                        <th><s:property value="#row[0]"/></th>
                        <th><s:property value="#row[1]"/></th>
                        <th><img src="<s:property value="#row[2]"/>" width="50" height="50"></th>
                        <%--<th><s:property value="#row[2]"/></th>--%>
                        <th><s:property value="#row[3]"/></th>
                        <th><s:property value="#row[7]"/></th>
                        <th><s:property value="#row[8]"/></th>
                        <th><s:property value="#row[10]"/></th>
                        <%--<th><s:property value="#row[5]"/></th>--%>
                        <%--<th><a href="#">删除</a></th>--%>
                    </tr>
                </s:iterator>
                </tbody>
            </table>
        </div>
        <div class="col-md-1">

        </div>
    </div>
</div>
</body>
</html>
