<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/2
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<%@include file="admin_header.jsp"%>
<body>
<s:debug/>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <%--提示信息显示  filed error and action errror --%>
            <s:if test="hasActionMessages()">
                <div class="alert alert-dismissable alert-warning">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                    <h4>警告！</h4>
                    <strong>Warning!</strong>
                    检查你的错误 <s:actionmessage/>
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
                <h2>欢迎来到修改城市信息页面.......</h2>
                <br>
                <div class="row clearfix">
                    <div class="col-md-2">

                    </div>
                    <div class="col-md-6">
                        <form action="editCity.action" id="editForm" role="form" method="post">
                            <div class="form-group">
                                <label for="cityId">当前城市ID</label>
                                <input type="text" class="form-control" id="cityId" name="cityId"
                                       value="<s:property value='city.cityId'/>" readonly/>
                            </div>
                            <div class="form-group">
                                <label for="cityName">请输入修改后城市名:</label>
                                <input type="text" class="form-control" id="cityName" name="cityName"
                                       value="<s:property value='city.cityName'/>" required/>
                            </div>
                            <button type="submit" class="btn btn-default" name="submit">提交修改</button>
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
