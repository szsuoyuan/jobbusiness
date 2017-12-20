<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../ws/pageControl/jstlImport.jsp" %>
<div class="pageContent">
	<form method="post" action="oa/saveRecord" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone)">
		<div class="pageFormContent" layoutH="56">
		<input type="hidden" name="cId" value="${cId }" />
			<div class="unit">
				<label>更进对象：</label>
				<input name="rCustomer"  type="text" size="30" readonly="readonly" value="${customer['cName'] }"/>
			</div>
			<br><br>
			<div class="divider"></div>
			<div class="unit">
				<label>更进方式：</label>
				<select name="rMode" class="required combox" size="30">
					<option value="1" selected>电话</option>
					<option value="2" >微信</option>
					<option value="3">面谈</option>
					<option value="4">QQ</option>
					<option value="5">短信</option>
					<option value="6">邮件</option>
					<option value="7">其他</option>
				</select>
			</div>
			<br><br>
			<div class="divider"></div>
			<div class="unit">
				<label>主要事宜：</label>
				<select name="rMainThing" class="required combox">
					<option value="1" selected>初期沟通</option>
					<option value="2" >问卷调查</option>
					<option value="3">需求分析</option>
					<option value="4">方案报价</option>
					<option value="5">谈判审核</option>
				</select>
			</div>
			<br><br>
			<div class="divider"></div>
			<div class="unit">
				<label>更进结果：</label>
				<select name="rResult" class="required combox">
					<option value="1" selected>继续更进</option>
					<option value="2" >成功签单</option>
					<option value="3" >客户流失</option>
				</select>
			</div>
			<br><br>
			<div class="divider"></div>
			<div class="unit">
				<label>备注：</label>
				<textarea name="rRemark"  cols="40" rows="6"></textarea>
			</div>
		</div>
		<c:import url="../ws/pageControl/submitButton.jsp" />
	</form>
</div>
