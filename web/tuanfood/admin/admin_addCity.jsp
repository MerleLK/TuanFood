<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/25
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<%@include file="admin_header.jsp" %>
<body>
<div class="container">
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
            <h2>请选择添加的城市信息:</h2>
            <div class="col-md-4">
            </div>
            <div class="col-md-6">
                <form action="addCity.action" id="loginForm" role="form" method="post">
                    <div class="control-group">
                        <label class="control-label" for="province">请选择省份:</label>
                        <div class="controls">
                            <select id="province">
                                <option value="载入中">载入中</option>
                            </select>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="city" >请选择城市:</label>
                        <div class="controls">
                            <select id="city" name="city.cityName">
                                <option value="载入中">载入中</option>
                            </select>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-default" name="submit">提交</button>
                </form>
            </div>
            <div class="col-md-2">
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" id="main">
    $(function () {

        $('#province, #city').citylist({
            data: data,
            id: 'id',
            children: 'cities',
            name: 'name',
            metaTag: 'name'
        });


    });
</script>
<script>
    // 本页面高亮代码
    $(function () {
        $('.prettyprint').html($('#main').text());
        window.prettyPrint && prettyPrint();
    })
</script>

</html>
