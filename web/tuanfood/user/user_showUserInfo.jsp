<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/29
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<%@include file="user_header.jsp" %>
<body>
<s:debug/>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-2 column">
        </div>
        <div class="col-md-6 column">
            <h3>&nbsp;&nbsp;您的信息如下:</h3>
            <form role="form">
                <div class="form-group">
                    <label for="username">用户名</label>
                    <input type="text" class="form-control" name="user.username"
                           id="username" value='<s:property value="user.username"/>'/>
                </div>
                <div class="form-group">
                    <label for="userAge">年龄</label>
                    <input type="text" class="form-control" name="user.userAge"
                           id="userAge" value='<s:property value="user.userAge"/>'/>
                </div>
                <div class="form-group">
                    <label for="userBirthday">生日</label>
                    <input type="text" class="form-control" name="user.userBirthday"
                           id="userBirthday" value='<s:property value="user.userBirthday"/>'/>
                </div>
                <div class="form-group">
                    <label for="userMoney">金额</label>
                    <input type="text" class="form-control" name="user.userMoney"
                           id="userMoney"  value='<s:property value="user.userMoney"/>'/>
                </div>
                <div class="form-group">
                    <label for="userAddress">地址</label>
                    <input type="text" class="form-control" name="user.userAddress"
                           id="userAddress" value='<s:property value="user.userAddress"/>'/>
                </div>
            </form>
        </div>
        <div class="col-md-4 column">
        </div>
    </div>
</div>
</body>
</html>
