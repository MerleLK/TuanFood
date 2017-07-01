<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/26
  Time: 10:29
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
            <div class="col-md-2">
            </div>
            <div class="col-md-8">
                <form class="form-horizontal" action="addProduct.action" role="form" id="form">
                    <input type="hidden" name="reviewId" value="<s:property value="reviewId"/>"/>

                    <div class="form-group">
                        <label for="productName" class="col-sm-2 control-label">审核商品名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="productName" name="productName"
                                   value="<s:property value="review.productName"/>" readonly/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="result" class="col-sm-2 control-label">审核结果</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="result" name="result"
                                   value="<s:property value="review.result"/>" required/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="reviewStatus" class="col-sm-2 control-label">审核状态</label>
                        <div class="col-sm-10">
                            <%--<input type="text" class="form-control" id="reviewStatus" />--%>
                            <select class="form-control" name="reviewStatus" id="reviewStatus">
                                <option value="1">通过</option>
                                <option value="2">不通过</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="productSummary" class="col-sm-2 control-label">商品简介</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="productSummary" name="productSummary"
                                   value="<s:property value="review.productSummary"/>" readonly/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">提交审核结果</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-md-2">

            </div>

        </div>
    </div>
</div>

</body>
</html>
