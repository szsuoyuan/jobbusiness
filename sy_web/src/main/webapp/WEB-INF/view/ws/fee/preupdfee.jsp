<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../pageControl/jstlImport.jsp" %>
<div class="pageContent">
		<form method="post" action="ws/saveFeeByUpd"  class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<p class="contentTitle">修改返费信息</p>
		<div class="pageFormContent" layoutH="98">
			<input type="hidden" name="fId" value="${fee.fId }" />
			<p>
				<label>姓名：</label>
				<input type="text"  name="fName"  required="required"  size="30" value="${fee.fName }"/>
			</p>
			<p>
				<label>金额：</label>
				<input type="text" size="30" name="fMoney" value="${fee.fMoney }" />
			</p>
			<p>
				<label>费用类型：</label>
				<input type="radio" name="fType" value="1" <c:if test="${fee.fType==1 }"> checked="checked" </c:if> />返费
				<input type="radio" name="fType" value="2" <c:if test="${fee.fType==2 }"> checked="checked" </c:if> />推荐费
			</p>
			<div class="divider"></div>
			<dl class="nowrap">
			<dt>备注：</dt>
			<dd><textarea name="fRemark" cols="60" rows="6">${fee.fRemark }</textarea></dd>
		 </div>
		<c:import url="../pageControl/submitButton.jsp"></c:import>
	</form>
</div>
