<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/25
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<%@include file="admin_header.jsp" %>
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
                <h2>欢迎来到新增美食类别页面.......</h2>
                <br>
                <div class="row clearfix">
                    <div class="col-md-2">

                    </div>
                    <div class="col-md-6">
                        <form action="addFoodType.action" id="form" role="form" method="post">
                            <div class="form-group">
                                <label for="foodType">请输入美食类别:</label>
                                <input type="text" class="form-control" id="foodType" name="foodType"/>
                            </div>
                            <button type="submit" class="btn btn-default" name="submit">提交</button>
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
