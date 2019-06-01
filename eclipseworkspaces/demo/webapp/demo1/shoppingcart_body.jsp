<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>购物车操作</title>
    <link rel="stylesheet" href="css/shopping.css">
    <script src="js/shopping.js"></script>
</head>
<body>
    <div class="box">
        <div class="container" id="container">
            <!-- 购物车标题 -->
            <div class="shoppingCar"><h1>购物车</h1></div>
            <!-- 分割线 -->
            <div class="divider"></div>
            <!-- 头部开始 begin -->
            <div class="header">
                <label for="checkAll" class="ckAll">
                    <input type="checkbox" class="checkAll" id="checkAll">
                    全选
                </label>
                <ul>
                    <li>商品</li>
                    <li>单价(元)</li>
                    <li>数量</li>
                    <li>金额(元)</li>
                </ul>
            </div>
            <!-- 头部结束 end -->
            
            <!-- 产品开始 begin -->
            <div class="products" id="products">
                <div class="product">
                    <div class="description">
                        <input type="checkbox">
                        <a href="javascript:void(0)"><img src="images/1.jpg"></a>
                        <p>Diror 迪奥 花漾甜心小姐 女士淡香水<br>50毫升<br>不支持无理由退货</p>
                        <span class="price">498.25</span>
                    </div>
                    <div class="num">
                        <div class="nums">
                            <span class="reduce">-</span>
                            <input type="text" value="1">
                            <span class="add">+</span>
                        </div>
                        <span class="cost">498.25</span>
                    </div>
                </div>
                <div class="product">
                        <div class="description">
                            <input type="checkbox" >
                            <a href="javascript:void(0)"><img src="images/2.jpg"></a>
                            <p>Diror 迪奥 活力猛男 男士淡香水<br>60毫升<br>不支持无理由退货</p>
                            <span class="price">398.50</span>
                        </div>
                        <div class="num">
                            <div class="nums">
                                <span class="reduce">-</span>
                                <input type="text" value="1">
                                <span class="add">+</span>
                            </div>
                            <span class="cost">398.50</span>
                        </div>
                </div>
                <div class="product">
                        <div class="description">
                            <input type="checkbox" >
                            <a href="javascript:void(0)"><img src="images/3.jpg"></a>
                            <p>Diror 迪奥 活力猛男 男士淡香水<br>60毫升<br>不支持无理由退货</p>
                            <span class="price">199.99</span>
                        </div>
                        <div class="num">
                            <div class="nums">
                                <span class="reduce">-</span>
                                <input type="text" value="1">
                                <span class="add">+</span>
                            </div>
                            <span class="cost">199.99</span>
                        </div>
                </div>
                <div class="product">
                        <div class="description">
                            <input type="checkbox" >
                            <a href="javascript:void(0)"><img src="images/4.jpg"></a>
                            <p>CHANEL香奈儿 山茶花 男士淡香水<br>30毫升<br>不支持无理由退货</p>
                            <span class="price">999.00</span>
                        </div>
                        <div class="num">
                            <div class="nums">
                                <span class="reduce">-</span>
                                <input type="text" value="1">
                                <span class="add">+</span>
                            </div>
                            <span class="cost">999.00</span>
                        </div>
                </div>
            </div>
            <!-- 产品结束 end -->

            <!-- 结算行开始 begin -->
            <div class="footer">
                <label class="ckAll">
                    <input type="checkbox" class="checkAll" id="checkFull">
                    全选
                </label>
                <span class="del">删除</span>
                <div>
                    <h3>已选商品&nbsp;<i class="number">0</i>&nbsp;件</h3>
                    <h3>合计：<b class="priceTotal">0</b></h3>
                    <input type="button" class="account" value="立即结算">
                </div>
            </div>
            <!-- 结算行结束 end -->
        </div>
    </div>
</body>s
</html>