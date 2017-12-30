<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../pageControl/jstlImport.jsp" %>
<div class="pageContent">
		<form method="post" action="ws/saveOrder"  class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<p class="contentTitle">添加报名信息</p>
		<div class="pageFormContent" layoutH="98">
			<p>
				<label>报名订单编号：</label>
				<input type="text"  name="oNumber"  required="required" readonly="readonly" size="30" value="${oNumber }"/>
			</p>
			<p>
				<label>报名人：</label>
				
				<input name="oHumanName" type="text" size="30" />
			</p>
			<p>
				<label>公司名称：</label>
				<input type="text" size="30" name="oCompany" />
			</p>
			<p>
				<label>工作性质：</label>
				<input type="radio" name="oJob" value="1" />全职
				<input type="radio" name="oJob" value="2" />兼职
			</p>
			<p>
				<label>月薪：</label>
				<input type="text" name="oJobSalary"  size="30" />
			</p>
			<p>
				<label>日薪：</label>
				<input type="text" name="oJobSalaryDay"  size="30" />
			</p>
			<p>
				<label>经纪人：</label>
				
				<input id="inputOrg1" name="user.id" value="" type="hidden"/>
				<input id="inputOrg1" name="user.orgName" value="" type="hidden"/>
				<input type="text" readonly="readonly"  name="user.userName" />
				<a class="btnLook" href="sys/findAllEmployeesForLookUp" lookupGroup="user">查找带回</a>		
			</p>
			<div class="divider"></div>
			<dl class="nowrap">
			<dt>备注：</dt>
			<dd><textarea name="oRemark" cols="60" rows="6"></textarea></dd>
		 </div>
		<c:import url="../pageControl/submitButton.jsp"></c:import>
	</form>
</div>
