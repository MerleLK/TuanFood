<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/24
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<%@include file="header.jsp" %>
<body>
<div class="container">
    <div class="row clearfix">
        <%-- 提示信息显示  filed error and action errror --%>
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
                <strong>Warning!</strong><s:actionerror/>
            </div>
        </s:if>
        <div class="col-md-12 column">
            <h2>欢迎来到注册页面.......</h2>
            <br>
            <div class="row clearfix">
                <div class="col-md-2">

                </div>
                <div class="col-md-6">
                    <form action="register.action" id="registerForm" role="form" method="post">
                        <div class="form-group">
                            <label for="username">用户名</label>
                            <input type="text" class="form-control" id="username" name="user.username" required/>
                        </div>
                        <div class="form-group">
                            <label for="password">密码</label>
                            <input type="password" class="form-control" id="password" name="user.password" required/>
                        </div>
                        <div class="form-group">
                            <label for="password_again">重复密码</label>
                            <input type="password" class="form-control" id="password_again"
                                   name="user.password_again" required/>
                        </div>
                        <%--<div class="form-group" hidden>--%>
                            <%--<label for="userAge">年龄</label>--%>
                            <%--<input type="text" class="form-control" id="userAge"--%>
                                   <%--name="user.userAge" />--%>
                        <%--</div>--%>
                        <div class="form-group">
                            <label for="userBirthday">生日</label>
                            <input type="date" class="form-control" id="userBirthday"
                                   name="user.userBirthday" required/>
                        </div>
                        <div class="form-group">
                            <label for="userAddress">请输入您的地址</label>
                            <input type="text" class="form-control" id="userAddress"
                                   name="user.userAddress" required/>
                        </div>
                        <div class="form-group">
                            <label for="userRoleId">请选择角色</label>
                            <br>
                            <%--<input type="text" class="form-control" id="userRoleId" name="user.userRoleId"/>--%>
                            <select class="form-control" id="userRoleId" name="user.userRoleId">
                                <option value=1 selected>店铺管理员</option>
                                <option value=2>用户</option>
                            </select>
                        </div>

                        <button type="submit" class="btn btn-default" id="submit" name="submit">注册</button>
                    </form>
                </div>
                <div class="col-md-4">

                </div>
            </div>
        </div>
    </div>
</div>
<script>
    var obj = document.getElementById('registerForm');
    var check_password = function () {
        var password = document.getElementById('password').value;
        var password_again = document.getElementById('password_again').value;

        if (password != password_again) {
            alert("您两次密码输入不一致,请重新输入!");
            document.getElementById('password').value = "";
            document.getElementById('password_again').value = "";
            return false;
        }
        else {
            if (timeCheck()){
                return true;
            }
            else {
                return false;
            }

        }
    };
    obj.onsubmit = function () {
        return check_password();
    };

    function timeCheck() {
        var now = new Date().getTime();
        var userBirthday = document.getElementById("userBirthday").value;
        var arr = userBirthday.split("-");
        var choseTime = new Date(arr[0], arr[1], arr[2]).getTime();

        if (choseTime < now){
            alert("请选择正确的出生年月，应比当前时间小");
            return false;
        }
        else {
            return true;
        }
    }
</script>
</body>
</html>
