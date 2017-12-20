<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../ws/pageControl/jstlImport.jsp" %>
<div class="pageContent">
	<form method="post" action="sys/addUserInfo" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone)">
		<div class="pageFormContent" layoutH="56">
		<input type="hidden" name="parentId" value="${userid }" />
			<div class="unit">
				<label>帐号名称：</label>
				<input type="text" name="username" size="28" minlength="4" maxlength="18" class="required" />
			</div>
			<br><br>
			<div class="divider"></div>
			<div class="unit">
				<label>帐号密码：</label>
				<input type="password" id="cp_newPassword" name="userpass" size="28" minlength="6" maxlength="12" class="required alphanumeric"/>
			    <span class="info">&nbsp;&nbsp;提示：长度为6—12位字符</span>
			</div>
			<br><br>
			<div class="divider"></div>
			<div class="unit">
				<label>确认密码：</label>
				<input type="password" name="rnewPassword" size="28" equalTo="#cp_newPassword" class="required alphanumeric"/>
			</div>
			<br><br>
			<div class="divider"></div>
			<div class="unit">
				<label>选择角色：</label>
				<select class="combox" name="wtRId">
						<option value="0">请选择</option>
					<c:forEach items="${rolelist }" var="r">
						<option value="${r.wtRId}">${r["wtRName"] }</option>
					</c:forEach>
				</select>
			</div>
			<br><br>
			<div class="divider"></div>
			<div class="unit">
				<label>账号描述：</label>
				<textarea name="userremark"  cols="28" rows="2"></textarea>
			</div>
			<div class="divider"></div>
			<br><br>
			<div class="unit">
				<label>是否启用：</label>
				<label><input type="radio" name="userstatus" value="1" checked="checked"/>启用</label>
				<label><input type="radio" name="userstatus" value="0"/>禁用</label>
			</div>
			<div class="divider"></div>
		</div>
		<c:import url="../ws/pageControl/submitButton.jsp" />
	</form>
</div>
