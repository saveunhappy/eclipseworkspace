     <s:iterator value="goods">     
           
         		  <tr>
						<td class="col1"><a href=""><img src='<s:property value="imgPath"/>' alt="" height="100px" width="100px"/></a>  <strong><a href="LoadGoodsServlet?goodsId=${item.good.goodsId }">${item.good.goodsName }  ${item.good.bak }</a></strong></td>
						<td class="col2"> <p>规格：个</p>  </td>
						<td class="col3">￥<span><s:property value="price"/></span></td>
						<td class="col4"> 
							<a href="javascript:;" class="reduce_num"></a>
							<input type="number" name="amount"  value="<s:property value='number'/>" class="amount"/>
							<a href="javascript:;" class="add_num"></a>
						</td>
						<td class="col5">￥<span><s:property value="price*number"/></span></td>
						<td class="col6"><a href="DeleteCartServlet?goodsId=${item.good.goodsId }">删除</a></td>
					</tr>
           
           
           
				</s:iterator>