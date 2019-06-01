<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<!-- saved from url=(0096)http://cart.wbiao.cn/success?order_id=102338&payment_id=2&token=846a32919ddd22bffc6d85fa1781e2d6 -->
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>订单提交成功_喜悦手表网</title>
<meta name="keywords" content="">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8">
	<link rel="stylesheet" href="style/base.css" type="text/css">
	<link rel="stylesheet" href="style/global.css" type="text/css">
	<link rel="stylesheet" href="style/header.css" type="text/css">
	<link rel="stylesheet" href="style/cart.css" type="text/css">
	<link rel="stylesheet" href="style/footer.css" type="text/css">

	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="js/cart1.js"></script>
<link rel="stylesheet" href="css/2.css">
<!--[if lte IE 6]>
<link rel="stylesheet" href="http://qd.wbiao.cn/src2/css/common/3.0/ie6.css?t=201307300952">
<![endif]-->

<style type="text/css">

	.c999 f13 h40 mt10 li_left{
	display: inline-block;
	width:100%;
	}
	.c999 f13 h40 mt10 li_left{
	display: inline-block;
	width:100%;
	}
</style>
</head>

<body style="">
<div id="member_info2"></div>
<div id="header">
    <div class="top">
   
    </div> 
    <div class="w750 mt30 fr">
        <ul class="m_0_23 inline w464 fr li_left li">
            <li class="w14 h14 circle bp_0-36"></li>
            <li class="w136 h8 mt6 bt_2_f1f">&nbsp;</li>
            <li class="w14 h14 circle bp_0-36"></li>
            <li class="w136 h8 mt6 bt_2_f1f">&nbsp;</li>
            <li class="w14 h14 circle bp_0-36"></li>
            <li class="w136 h8 mt6 bt_2_f1f">&nbsp;</li>
            <li class="w14 h14 circle bp_0-19"></li>
        </ul>
        <ul class="w510 mt10 fr li_left li">
            <li class="w60 bold f14 cd00">选购商品</li>
            <li class="w90">&nbsp;</li>
            <li class="w60 bold f14 c666">提交订单</li>
            <li class="w90">&nbsp;</li>
            <li class="w60 bold f14 c666">支付订单</li>
            <li class="w90">&nbsp;</li>
            <li class="w60 bold f14 c666">等待签收</li>
        </ul>
    </div>
    <h1><br /><img src="css/images/LOGO.png" /></h1>
</div>


<script type="text/javascript">
$(function(){
    collection('a#collection');

    fcbox("#login_now", true); //登录弹窗
});

function collection(id){
    $(id).click(function(){
        var goods_id = $(this).attr('oprid');
        $.post(www_domain + "/user/collection", { is_ajax : 1, ids : goods_id, collection : 1 },
                function(result){
                    alert(result);
        }, "json");
    });
}

var refresh_gift_card_list = function(){};

function pop_login(){
    $("#login_now").trigger("click");
}

</script>
<div id="main">
    <div class="w930 m0a mt30">
        <div class="ml20">
           
        </div>
        <div class="bgf6f br10">
                                    <ul class="c999 f13 h40 mt10 li_left">
                <li class="w510 tl pl20">商品</li>
                <li class="w120 tc">售价</li>
                <li class="w120 tc">数量</li>
                <li class="w80 tr pr64">操作</li>
            </ul>

                            <ul class="bt_1_eae bb_1_fff" id="goods_line_548546"></ul>
                            
                            
<div class="mycart w990 mt10 bc">
		<h2><span>我的购物车</span></h2>
		<form action="JieSuanServlet" method="post">
		<table >
			
			<tbody>
				<c:forEach var="item" items="${sessionScope.cartInfo }">
					<tr>
						<td class="col1"><a href=""><img src="${item.good.imgPath }" alt="" height="100px" width="100px"/></a>  <strong><a href="LoadGoodsServlet?goodsId=${item.good.goodsId }">${item.good.goodsName }  ${item.good.bak }</a></strong></td>
						<td class="col2"> <p>规格：${item.good.spec }</p>  </td>
						<td class="col3">￥<span>${item.good.price }</span></td>
						<td class="col4"> 
							<a href="javascript:;" class="reduce_num"></a>
							<input type="number" name="amount"  value="${item.nums }" class="amount"/>
							<a href="javascript:;" class="add_num"></a>
						</td>
						<td class="col5">￥<span>${item.good.price*item.nums }</span></td>
						<td class="col6"><a href="DeleteCartServlet?goodsId=${item.good.goodsId }">删除</a></td>
					</tr>
				</c:forEach>
				
				
				
			</tbody>
			<tfoot> 
				<tr>
					<td colspan="6">购物金额总计： <strong>￥ <span id="total"></span></strong></td>
				</tr>
			</tfoot>
		</table>
		<div class="cart_btn w990 bc mt10">
			<a href="ListGoodsServlet" class="continue">继续购物</a>
			<div class="checkout">
			
			<input type="submit" value="去结 算" /></div>
			
			</div>
		</form>
	</div>
<div id="dsp" style="display:none;">
<script type="text/javascript">
var _mvq = _mvq || [];
_mvq.push(['$setAccount', 'm-25646-0']);
_mvq.push(['$setGeneral', 'cartview', '', '', '0']);
_mvq.push(['$logConversion']);
_mvq.push(['$addItem', '', '25523', '','']);
_mvq.push(['$logData']);
</script>
</div>
<link rel="stylesheet" href="css/fancybox.css" type="text/css">
<script type="text/javascript" src="Script/fancybox.js"></script>
<div id="kfs" style="display: none; ">
  <div class="context"> <a href="javascript:void(0);" onclick="javascript:NTKF.im_openInPageChat(&#39;kf_9988_1341905703263&#39;);_gaq.push([&#39;_trackEvent&#39;,&#39;kefuxiaochuang&#39;, &#39;tousu&#39;, location.href]);" class="show" title="打开" rel="nofollow">&nbsp;</a> </div>
</div>
<script type="text/javascript">
$(function(){
  KFHover('.context span');
});
function KFHover(ipt){
    $(ipt).hover(function(){
        var cls     = $(this).attr('class');
        var css  = cls.substr(cls.lastIndexOf("kf_btn"), 8) ;
        $(this).removeClass(css).addClass(css + 'Hover');
    },function(){
        var cls     = $(this).attr('class');
        var css  = cls.substr(cls.lastIndexOf("kf_btn"), 8);
        $(this).removeClass(css + 'Hover').addClass(css);
    });
}
</script>

<div id="footer">
  <div class="info">
    <p class="copyright">                喜悦名表 版权所有  Copyright 2014-2015 www.xxxxxxx.cn . LTD ALL RIGHT RESERVED.

    </p>
  </div>
</div>
</body>
</html>