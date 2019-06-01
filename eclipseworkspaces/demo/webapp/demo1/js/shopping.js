
	window.onload = function () {
    var J = {
        getClass: function (className) {

        return document.querySelectorAll(className);
        },
        getId: function (id) {

        return document.getElementById(id);
        }
    }
    var checkboxs = J.getClass(".product input[type=checkbox]");
    var checkAll = J.getId('checkAll');
    var checkFull = J.getId('checkFull');
	function Allcheck(e, obj, otherObj, checkBoxnum) {
    var e = e || window.event;
    var target = e.target || e.srcElement;
    for (var i = 0; i < checkBoxnum.length; i++) {
        if (target == obj) 
        {
           checkBoxnum[i].checked = obj.checked;  
        }
    }
    otherObj.checked = obj.checked;  
}
    checkAll.onclick = function (e) {
        Allcheck(e, checkAll, checkFull, checkboxs);
        getTotal();
    }
    checkFull.onclick = function (e){
        Allcheck(e, checkFull, checkAll, checkboxs);
        getTotal();
    }
	function getTotal(){
		var selected=0;
		var price=0;
		var productObj=J.getClass('.products .product');
		checkboxs=J.getClass(".product input[type=checkbox]");
	    num=J.getClass(".product input[type=text]");
	    cost=J.getClass(".product .cost");
	    for(var i=0;i<productObj.length;i++){
	    	if(checkboxs[i].checked){
	    		selected+=parseInt(num[i].value);
	    		price+=parseFloat(cost[i].innerHTML);
	    	}
	    } 
	    var number=J.getClass('.footer .number');
	    number[0].innerHTML=selected;
	    var priceTotal=J.getClass('.footer .priceTotal');
	    priceTotal[0].innerHTML=price.toFixed(2);
	    return productObj;
	}
	function changeNum(obj,items,num,select,subTotal,subValue){
		for(var j=0;j<items.length;j++){
			(function(j){
				obj[j].onclick = function(){
					var count=parseInt(num[j].value);
					if(obj==add){
						num[j].value=count+1;
					}
					if(obj==reduce){
						num[j].value=count-1;
						if(num[j].value<1){
							num[j].value=1;
						}
					}
					if(select[j].checked){
						subTotal[j].innerHTML=(parseInt(subValue[j].innerHTML*100)*num[j].value/100).toFixed(2);
						getTotal();
					}
					subTotal[j].innerHTML=(parseInt(subValue[j].innerHTML*100)*num[j].value/100).toFixed(2);
				}
			})(j);
		}
	}
	var add=J.getClass(".products .add");
	var productobj=J.getClass('.products .product');
	var val=J.getClass(".product input[type=text]");
	var checkboxs=J.getClass(".products input[type=checkbox]");
	var cost=J.getClass(".product .cost");
	var price=J.getClass(".products .price");
	var reduce=J.getClass('.products .reduce');
	changeNum(add,productobj,val,checkboxs,cost,price);
	changeNum(reduce,productobj,val,checkboxs,cost,price);
	for(var i=0;i<checkboxs.length;i++){
		  (function(i){
			checkboxs[i].onclick=function(){
				if(this.checked){
					getTotal();
				}else{
					getTotal();
				}
				var ischecked=true;
		for(var i=0;i<checkboxs.length;i++){
			if(!checkboxs[i].checked){
				ischecked=false;
				break;
			}
		}
		checkAll.checked=ischecked;
		checkFull.checked=ischecked;
		getTotal();
			}
		})(i);
	}
	J.getClass(".footer .del")[0].onclick=function(){
		var mainPro = J.getId("products");
		var number = J.getClass(".footer .number");
		if(number[0].innerHTML==0){
			alert("请选择要删除的产品！");
		}
		else{
			var conf = confirm("确定要删除选中的产品吗？");
			if(conf==true){
				for(var j=0;j<checkboxs.length;j++){
					checkboxs=J.getClass(".products input[type=checkbox]");
					if(checkboxs[j].checked){
						mainPro.removeChild(getTotal()[j]);
						j--;
						getTotal();
					}
				}
				
			}
			getTotal();
			if(number[0].innerHTML==0){
				checkAll.checked = false;
				checkFull.checked=false;
				
			}
		}
	
	
	}
	
	
}