<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../ws/pageControl/jstlImport.jsp" %>
<div class="pageContent">
	<form method="post" action="${pageContext.request.contextPath}/oa/saveRecordByUpd" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone)">
		<div class="pageFormContent" layoutH="56">
		<input type="hidden" name="rId" value="${record['rId'] }" />
		<input type="hidden" name="cId" value="${record['cId']}" />
			<div class="unit">
				<label>更进对象：</label>
				<input name="rCustomer"  type="text" size="30" readonly="readonly" value="${record['rCustomer'] }"/>
			</div>
			<br><br>
			<div class="divider"></div>
			<div class="unit">
				<label>更进方式：</label>
				<select name="rMode" class="required combox" size="30">
					<option value="1" <c:if test="${record['rMode']==1 }">selected</c:if> >电话</option>
					<option value="2" <c:if test="${record['rMode']==2 }">selected</c:if>  >微信</option>
					<option value="3" <c:if test="${record['rMode']==3 }">selected</c:if>  >面谈</option>
					<option value="4" <c:if test="${record['rMode']==4 }">selected</c:if>  >QQ</option>
					<option value="5" <c:if test="${record['rMode']==5 }">selected</c:if>  >短信</option>
					<option value="6" <c:if test="${record['rMode']==6 }">selected</c:if>  >邮件</option>
					<option value="7" <c:if test="${record['rMode']==7 }">selected</c:if>  >其他</option>
				</select>
			</div>
			<br><br>
			<div class="divider"></div>
			<div class="unit">
				<label>主要事宜：</label>
				<select name="rMainThing" class="required combox">
					<option value="1" <c:if test="${record['rMainThing']==1 }">selected</c:if> >初期沟通</option>
					<option value="2" <c:if test="${record['rMainThing']==2 }">selected</c:if> >问卷调查</option>
					<option value="3" <c:if test="${record['rMainThing']==3 }">selected</c:if> >需求分析</option>
					<option value="4" <c:if test="${record['rMainThing']==4 }">selected</c:if> >方案报价</option>
					<option value="5" <c:if test="${record['rMainThing']==5 }">selected</c:if> >谈判审核</option>
				</select>
			</div>
			<br><br>
			<div class="divider"></div>
			<div class="unit">
				<label>更进结果：</label>
				<select name="rResult" class="required combox">
					<option value="1" <c:if test="${record['rResult']==1 }">selected</c:if> >继续更进</option>
					<option value="2" <c:if test="${record['rResult']==2 }">selected</c:if> >成功签单</option>
					<option value="3" <c:if test="${record['rResult']==3 }">selected</c:if> >客户流失</option>
				</select>
			</div>
			<br><br>
			<div class="divider"></div>
			<div class="unit">
				<label>备注：</label>
				<textarea name="rRemark"  cols="40" rows="6">${record['rRemark'] }</textarea>
			</div>
		</div>
		<c:import url="../ws/pageControl/submitButton.jsp" />
	</form>
</div>
