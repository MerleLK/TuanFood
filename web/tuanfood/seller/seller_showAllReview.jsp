<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/26
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<%@include file="seller_header.jsp" %>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="row clearfix">
                <div class="col-md-1 column">
                </div>
                <div class="col-md-10 column">
                    <h3>&nbsp;&nbsp;当前您的审核记录如下:</h3>
                    <table class="table table-striped table-hover">
                        <thead>
                        <tr><%-- 点击显示详细信息 todo --%>
                            <th>商品ID</th>
                            <th>商品名</th>
                            <th>图片</th>
                            <th>商品简介</th>
                            <th>审核结果</th>
                            <th>审核状态</th>
                        </tr>
                        </thead>
                        <tbody>
                        <s:iterator value="reviews" var="row" status="status">
                            <tr>
                                <th><s:property value="#row[0]"/></th>
                                <th><s:property value="#row[1]"/></th>
                                <th><img src="<s:property value="#row[2]"/>" width="50" height="50"></th>
                                <%--<th><s:property value="#row[2]"/></th>--%>
                                    <%--<th><a href="#">删除</a></th>--%>
                                <th><s:property value="#row[3]"/></th>
                                <th><s:property value="#row[4]"/></th>
                                <th>
                                    <s:if test="%{#row[5]==0}">未审核</s:if>
                                    <s:elseif test="%{#row[5]==1}">已审核通过</s:elseif>
                                    <s:else>审核未通过</s:else>
                                </th>
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
