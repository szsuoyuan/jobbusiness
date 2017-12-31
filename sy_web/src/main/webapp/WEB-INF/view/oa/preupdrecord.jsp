<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../ws/pageControl/jstlImport.jsp" %>
<div class="pageContent">
	<form method="post" action="${pageContext.request.contextPath}/oa/saveRecordByUpd" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone)">
		<div class="pageFormContent" layoutH="56">
		<input type="hidden" name="rId" value="${record['rId'] }" />
		<input type="hidden" name="cId" value="${record['cId'] }" />
			<div class="unit">
				<label>所属公司：</label>
				<input name="rCustomer"  type="text" size="30" readonly="readonly" value="${record['rCustomer'] }"/>
			</div>
			<br><br>
			<div class="divider"></div>
			<div class="unit">
				<label>职位日薪：</label>
				<input name="rResult"  type="text" size="30" value="${record['rResult'] }" /><span class="info">元/日</span>
			</div>
			<br><br>
			<div class="divider"></div>
			<div class="unit">
				<label>职位简介：</label>
				<textarea name="rRemark"  cols="40" rows="6">${record['rRemark'] }</textarea>
			</div>
		</div>
		<c:import url="../ws/pageControl/submitButton.jsp" />
	</form>
</div>
