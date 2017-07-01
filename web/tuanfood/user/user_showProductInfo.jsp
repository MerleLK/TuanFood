<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/29
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<%@include file="user_header.jsp"%>
<body>
<s:debug/>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="row clearfix">
                <div class="col-md-2 column">
                </div>
                <div class="col-md-4 column">
                    <label><s:property value="product.productName"/></label>
                    <br>
                    <label><s:property value="product.productSummary"/></label>
                    <br>
                    <img src="<s:property value='product.productPic'/>" style="width: 140px;height: 140px"/>
                </div>
                <div class="col-md-6 column">
                    <dl>
                        <dt>
                            优惠价格:
                        </dt>
                        <dd>
                            <s:property value="product.productPrice"/>
                        </dd>
                        <dt>
                            已售
                        </dt>
                        <dd>
                            <s:property value="product.productSellAmount"/>份
                        </dd>
                        <dt>
                            有效期:
                        </dt>
                        <dd>
                            <s:property value="product.productDeadline"/>
                        </dd>
                    </dl>
                    <button onclick="window.location.href='buyProduct.action?' +
                            'username=<s:property value="#session.username"/>&productId=<s:property value="product.productId"/>'"
                            class="btn btn-default" type="button">立即购买
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
