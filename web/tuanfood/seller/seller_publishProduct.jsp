<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/26
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<%@include file="seller_header.jsp" %>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="col-md-4">
            </div>
            <div class="col-md-6">
                <s:form action="upload" enctype="multipart/form-data" id="form">
                    <div class="form-group">
                        <label for="productName">请输入商品名:</label>
                        <input type="text" class="form-control" id="productName" name="review.productName" required/>
                    </div>
                    <div class="form-group">
                        <label for="productPrice">请输入优惠后的价格:</label>
                        <input type="text" class="form-control" id="productPrice" name="review.productPrice" required/>
                    </div>
                    <div class="form-group">
                        <label for="productPriceOrigin">请输入原价:</label>
                        <input type="text" class="form-control" id="productPriceOrigin" name="review.productPriceOrigin"
                               required/>
                    </div>
                    <div class="form-group">
                        <label for="district">请选择所属地区:</label>
                        <br>
                        <select name="review.productArea" id="district">
                            <s:iterator value="districts" id="column">
                                <option value="<s:property value='key'/>"><s:property value="value"/></option>
                            </s:iterator>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="foodType">请选择所属类型:</label>
                        <br>
                        <select name="review.productType" id="foodType">
                            <s:iterator value="types" id="column">
                                <option value="<s:property value='key'/>"><s:property value="value"/></option>
                            </s:iterator>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="productInventory">请输入库存数量:</label>
                        <input type="text" class="form-control" id="productInventory" name="review.productInventory"
                               required/>
                    </div>
                    <div class="form-group">
                        <label for="productDeadLine">请输入优惠截止时间:</label>
                        <input type="date" class="form-control" id="productDeadLine" name="review.productDeadLine"
                               required/>
                    </div>
                    <div class="form-group">
                        <label for="productSummary">请输入简介:</label>
                        <input type="text" class="form-control" id="productSummary" name="review.productSummary"
                               required/>
                    </div>
                    <div class="form-group">
                        <label for="productDetail">请输入具体介绍:</label>
                        <input type="text" class="form-control" id="productDetail" name="review.productDetail"
                               required/>
                    </div>
                    <%--<button type="submit" class="btn btn-default">提交审核</button>--%>
                    <div class="form-group">
                        <label for="upload">选择文件</label>
                        <s:file name="upload" id="upload"/>
                        <p class="help-block">
                            请选择.jpg或者.png格式文件!
                        </p>
                    </div>
                    <s:submit id="submit" name="submit" value="提交审核" />
                </s:form>
            </div>
            <div class="col-md-2">
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    var obj = document.getElementById('form');
    var checkPriceInput = function () {
        var productPrice = document.getElementById("productPrice").value;
        var productPriceOrigin = document.getElementById("productPriceOrigin").value;

        if (!isNaN(productPrice) && !isNaN(productPriceOrigin)) {
            if (parseFloat(productPrice) < parseFloat(productPriceOrigin)) {
                if (timeCheck()){
                    if(ventoryCheck()){
                        return true;
                    }else
                        return false;
                }
                else {
                    return false;
                }
            }
            else {
                alert("您输入的价格格式有误!原价应该高于优惠价");
                return false;
            }
        }
        else {
            alert("价格为数字!");
            return false;
        }
    };
    obj.onsubmit = function () {
        return checkPriceInput();
    };

    function timeCheck() {
        var now = new Date().getTime();
        var productDeadLine = document.getElementById("productDeadLine").value;
        var arr = productDeadLine.split("-");
        var choseTime = new Date(arr[0], arr[1], arr[2]).getTime();

        if (choseTime > now){
            alert("请选择正确优惠时间，应比当前时间大");
            return false;
        }
        else {
            return true;
        }
    }
    function ventoryCheck() {
        var productInventory = document.getElementById("productInventory").value;
        if (!isNaN(productInventory)){
            if (parseInt(productInventory) == productInventory && parseInt(productInventory)>0){
                return true;
            }
            else {
                alert("库存量应为大于0的整数!");
                return false;
            }
        }
        else {
            alert("库存量应为数字");
            return false;
        }
    }
</script>
</body>
</html>
