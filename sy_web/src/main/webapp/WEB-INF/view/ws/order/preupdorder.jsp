<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../pageControl/jstlImport.jsp" %>
<div class="pageContent">
		<form method="post" action="ws/saveOrderByUpd"  class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<p class="contentTitle">修改报名信息</p>
		<div class="pageFormContent" layoutH="98">
		<input type="hidden"  name="oId" value="${order['oId'] }" />
			<p>
				<label>报名订单编号：</label>
				<input type="text"  name="oNumber"  required="required" readonly="readonly" size="30" value="${order['oNumber'] }"/>
			</p>
			<p>
				<label>报名人：</label>
				
				<input name="oHumanName" type="text" size="30" value="${order['oHumanName']  }"/>
			</p>
			<p>
				<label>公司名称：</label>
				<input type="text" size="30" name="oCompany" value="${order['oCompany']  }"/>
			</p>
			<p>
				<label>工作性质：</label>
				<input type="radio" name="oJob" value="1" <c:if test="${order['oJob']==1 }">checked="checked"</c:if>/>全职
				<input type="radio" name="oJob" value="2" <c:if test="${order['oJob']==2 }">checked="checked"</c:if> />兼职
			</p>
			<p>
				<label>月薪：</label>
				<input type="text" name="oJobSalary"  size="30" value="${order['oJobSalary']  }" />
			</p>
			<p>
				<label>日薪：</label>
				<input type="text" name="oJobSalaryDay"  size="30" value="${order['oJobSalaryDay']  }" />
			</p>
			<p>
				<label>经纪人：</label>
				
				<input id="inputOrg1" name="user.id" value="" type="hidden"/>
				<input id="inputOrg1" name="user.orgName" value="" type="hidden"/>
				<input type="text" readonly="readonly"  name="user.userName" value="${order['oUsername']  }"/>
				<a class="btnLook" href="sys/findAllEmployeesForLookUp" lookupGroup="user">查找带回</a>		
			</p>
			<div class="divider"></div>
			<dl class="nowrap">
			<dt>备注：</dt>
			<dd><textarea name="oRemark" cols="60" rows="6">${order['oRemark'] }</textarea></dd>
		 </div>
		<c:import url="../pageControl/submitButton.jsp"></c:import>
	</form>
</div>
