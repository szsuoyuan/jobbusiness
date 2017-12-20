<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../ws/pageControl/jstlImport.jsp" %>
<div class="pageContent">
	<form method="post" action="sys/updateSysUser" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone)">
		<div class="pageFormContent" layoutH="56">
		<input type="hidden" name="userid" value="${sysuser.id }" />
			<div class="unit">
				<label>帐号名称：</label>
				<input type="text" name="username" value="${sysuser.username }" readonly="readonly" size="28" minlength="4" maxlength="18" class="required" />
			</div>
			<br><br>
			<div class="divider"></div>
			<div class="unit">
				<label>选择角色：</label>
				<select class="combox" name="wtRId">
					<c:forEach items="${rolelist}" var="r">
						<option value="${r.wtRId}"	<c:if test="${sysuser.roleId == r.wtRId }">selected="selected" </c:if>	>${r["wtRName"] }</option>
					</c:forEach>
				</select>
			</div>
			<br><br>
			<div class="divider"></div>
			<div class="unit">
				<label>账号描述：</label>
				<textarea name="userremark"  cols="28" rows="2">${sysuser.userremark }</textarea>
			</div>
			<div class="divider"></div>
			<br><br>
			<div class="unit">
				<label>是否启用：</label>
				<label><input type="radio" name="userstatus" value="1" 
					<c:if test="${sysuser.userstatus==1 }">checked="checked" </c:if> />启用</label>
				<label><input type="radio" name="userstatus" value="0" 
					<c:if test="${sysuser.userstatus==0 }">checked="checked" </c:if> />禁止</label>
			</div>
			<div class="divider"></div>
		</div>
		<c:import url="../ws/pageControl/submitButton.jsp" />
	</form>
</div>
