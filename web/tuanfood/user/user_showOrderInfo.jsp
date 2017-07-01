<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/29
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<%@include file="user_header.jsp"%>
<body>
<s:if test="hasActionMessages()">
    <div class="alert alert-dismissable alert-success">
        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
        <h4>消息:</h4>
        <strong>Success--></strong><s:actionmessage/>
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
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="row clearfix">
                <div class="col-md-1 column">
                </div>
                <div class="col-md-10 column">
                    <h3>&nbsp;&nbsp;当前您的的团购记录如下:</h3>
                    <table class="table table-striped table-hover">
                        <thead>
                        <tr><%-- 点击显示详细信息 todo --%>
                            <th>商品名</th>
                            <th>图片</th>
                            <th>价格</th>
                            <th>商品简介</th>
                        </tr>
                        </thead>
                        <tbody>
                        <s:iterator value="products" id="product" >
                            <tr>
                                <th><s:property value="#product.productName"/></th>
                                <th><img src="<s:property value="#product.productPic"/>" width="50" height="50"></th>
                                <th><s:property value="#product.productPrice"/></th>
                                <th><s:property value="#product.productSummary"/></th>
                            </tr>
                        </s:iterator>
                        </tbody>
                    </table>
                </div>
                <div class="col-md-1 column">
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
