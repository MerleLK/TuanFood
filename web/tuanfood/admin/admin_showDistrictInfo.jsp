<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/2
  Time: 12:41
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
                <h2>欢迎来到修改地区信息页面.......</h2>
                <br>
                <div class="row clearfix">
                    <div class="col-md-2">

                    </div>
                    <div class="col-md-6">
                        <form action="editDistrict.action" id="editForm" role="form" method="post">
                            <div class="form-group">
                                <label for="districtId">当前地区ID</label>
                                <input type="text" class="form-control" id="districtId" name="districtId"
                                       value="<s:property value='district.districtId'/>" readonly/>
                            </div>
                            <div class="form-group">
                                <label for="districtName">请输入修改后地区名:</label>
                                <input type="text" class="form-control" id="districtName" name="districtName"
                                       value="<s:property value='district.districtName'/>" required/>
                            </div>
                            <div class="form-group">
                                <label for="cityName">当前所属城市:</label>
                                <input type="text" class="form-control" id="cityName" name="cityName"
                                       value="<s:property value='district.cityName'/>" readonly />
                            </div>
                            <div class="form-group">
                                <label for="city">请选择修改后所属城市:</label>
                                <br>
                                <select name="cityId" id="city">
                                    <s:iterator value="citys" id="column">
                                        <option value="<s:property value='key'/>"><s:property value="value"/></option>
                                    </s:iterator>
                                </select>
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
