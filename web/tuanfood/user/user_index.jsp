<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/25
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<%@include file="user_header.jsp" %>
<body>
<s:debug/>
<div class="container">
    <%-- 一层的导航栏 --%>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="row clearfix">
                <%-- 当前城市： 以及城市选择 --%>
                <div class="col-md-4 column">
                    <a href="#" class="btn btn-default" role="button"><s:property value="#session.newCityName"/></a>
                    <div class="btn-group">
                        <button type="button" class="btn btn-primary"
                                data-toggle="dropdown">
                            选择城市 <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" role="menu">
                            <s:iterator value="citys" id="city" status="status">
                                <li><a href='customerEntry.action?cityId=<s:property value="#city[0]"/>'>
                                    <s:property value="#city[1]"/></a></li>
                            </s:iterator>
                        </ul>
                    </div>
                </div>
                <%-- 输入价格区间进行查找 --%>
                <div class="col-md-4 column">
                    <form class="form-inline" action="getProductByPriceRange.action" role="form" id="priceForm">
                        <input type="hidden" name="cityId" id="cityId"
                               value='<s:property value="#session.newCityId"/>'/>
                        <div class="form-group">
                            <label class="sr-only" for="lowPrice">低价</label>
                            <input type="text" class="form-control" id="lowPrice" name="lowPrice"
                                   placeholder="请输入最低价格" style="width: 150px" required>
                        </div>
                        <div class="form-group">
                            <label class="sr-only" for="highPrice">高价</label>
                            <input type="text" class="form-control" id="highPrice" name="highPrice"
                                   placeholder="请输入最高价格" style="width: 150px" required>
                        </div>
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
                <%-- 两个按钮 价格升序, 价格降序 --%>
                <div class="col-md-4 column">
                    <a href='customerEntry.action?cityId=<s:property value="#session.newCityId"/>'
                       class="btn btn-default "
                       role="button">价格升序</a>
                    <a href='softByPriceDesc.action?cityId=<s:property value="#session.newCityId"/>'
                       class="btn btn-default " role="button">价格降序</a>
                </div>
            </div>
        </div>
    </div>
    <%-- 二层  相关信息 --%>
    <%--<script type="text/javascript">--%>
    <%--function findByType(){--%>
    <%----%>
    <%--} --%>
    <%--</script>--%>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="row clearfix">
                <!-- 第一个放置当前系统内所有的城市 -->
                <div class="col-md-2 column">
                    <div class="btn-group btn-group-vertical">
                        <button class="btn btn-default" type="button" disabled>全部分类</button>
                        <s:iterator value="foodTypes" id="row" status="status">

                            <button onclick="window.location.href='getProductByFoodTypeAndCity.action?' +
                                    'cityId=<s:property value="#session.newCityId"/>&foodTypeId=<s:property
                                    value="#row[0]"/>'"
                                    class="btn btn-default" type="button"><s:property value="#row[1]"/>
                            </button>
                        </s:iterator>
                    </div>
                </div>
                <%-- 此处放置 所有的图片和简介  团购信息 --%>
                <div class="col-md-10 column">
                    <s:iterator value="products" id="product">
                        <%--<img alt="50x50" src="/productPics/0.jpg"/>--%>
                        <div class="col-md-2 column">
                                <%-- 点击图片跳转到该商品的详细界面 --%>
                            <a href="getProductInfo.action?productId=<s:property value='#product.productId'/>">
                                <img src="<s:property value='#product.productPic'/>"
                                     style="width: 100px;height: 100px"/>
                            </a>
                            <dl>
                                <dt>简介:<s:property value='#product.productSummary'/></dt>
                                <dd>详细介绍:<s:property value='#product.productDetails'/></dd>
                                <dt>当前价格:¥<s:property value='#product.productPrice'/></dt>
                                <dd>原价:¥<s:property value='#product.productPriceOrigin'/></dd>
                                <dt>已售:</dt>
                                <dd><s:property value='#product.productSellAmount'/>份</dd>
                            </dl>
                        </div>
                    </s:iterator>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    var obj = document.getElementById('priceForm');
    var checkPriceInput = function () {
        var lowPrice = document.getElementById("lowPrice").value;
        var highPrice = document.getElementById("highPrice").value;
        if (!isNaN(lowPrice) && !isNaN(highPrice)) {
            if (lowPrice < highPrice) {
                return true;
            }
            else {
                alert("您输入的价格格式有误!低价应低于高价");
                return false;
            }
        }
        else {
            alert("请输入正确价格!");
            return false;
        }
    };
    obj.onsubmit = function () {
        return checkPriceInput();
    }
</script>
</body>
</html>