<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/25
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<%@include file="admin_header.jsp" %>
<body>
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
                <h2>欢迎来到增加地区页面.......</h2>
                <br>
                <div class="row clearfix">
                    <div class="col-md-2">
                    </div>
                    <div class="col-md-6">
                        <form action="addDistrict.action" id="Form" role="form" method="post">
                            <div class="form-group">
                                <label for="city">请选择所属城市:</label>
                                <br>
                                <%--<input type="text" class="form-control" id="city" name="city"/>--%>
                                <select name="city" id="city">
                                    <s:iterator value="citys" id="column">
                                        <option value="<s:property value='key'/>"><s:property value="value"/></option>
                                    </s:iterator>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="districtName">请输入地区名:</label>
                                <input type="text" class="form-control" id="districtName" name="districtName"/>
                            </div>
                            <button type="submit" class="btn btn-default" name="submit">增加</button>
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
