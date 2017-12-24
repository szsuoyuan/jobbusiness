<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../pageControl/jstlImport.jsp" %>
<div class="pageContent">
		<form method="post" action="ws/updateHuman"  class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<p class="contentTitle">修改会员信息</p>
		<c:if test="${not empty human }">
			<input type="hidden" value="${human.humanId}" name="humanId">
		</c:if>
	<div class="pageFormContent" layoutH="98">
			<p>
				<label>员工帐号：</label>
				<input name="humanAccount" class="required" readonly="readonly" type="text" size="30" value="${human['humanAccount'] }"/>
			</p>
			<%--
			<p>
				<label>员工密码：</label>
				
				<input name="human_password" type="text" size="30" />
			</p>--%>
			<p>
				<label>昵称：</label>
				<input type="text" size="30" name="humanQuestion" value="${human['humanQuestion'] }" />
			</p>
			<p>
				<label>性别：</label>
				<input type="radio" name="humanSex" value="1" <c:if test="${human['humanSex']==1 }">checked="checked"</c:if> />男
				<input type="radio" name="humanSex" value="2" <c:if test="${human['humanSex']==2 }">checked="checked"</c:if> />女
			</p>
			<p>
				<label>出生年月：</label>
				<input type="text" name="humanAnswer" value="${human['humanAnswer'] }"class="date" size="30" /><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>手机号码：</label>
				
				<input name="humanPhone" type="text" size="30" value="${human['humanPhone'] }"/>
			</p>
			<p>
				<label>真实姓名：</label>
				<input type="text" size="30" name="humanName" value="${human['humanName'] }"/>
			</p>
			<p>
				<label>家乡：</label>
				<input  type="text" size="30"  name="humanAddress" value="${human['humanAddress'] }"/>
			</p>
			<p>
				<label>求职状态：</label>
				<select name="humanStatus" class="required combox">
					<option value="1" <c:if test="${human['humanStatus']==1 }">selected</c:if> >正在求职</option>
					<option value="2" <c:if test="${human['humanStatus']==2 }">selected</c:if> >已经工作</option>
				</select>
			</p>
			<p>
				<label>学历：</label>
				<select name="humanEducation" class="required combox">
					<option value="1" <c:if test="${human['humanEducation']==1 }">selected</c:if> >大专</option>
					<option value="2" <c:if test="${human['humanEducation']==2 }">selected</c:if> >本科</option>
					<option value="3" <c:if test="${human['humanEducation']==3 }">selected</c:if> >博士</option>
					<option value="4" <c:if test="${human['humanEducation']==4 }">selected</c:if> >其它</option>
				</select>
			</p>
			<p>
				<label>现在居住地：</label>
				<input type="text" size="30" name="humanAddressCurr" value="${human['humanAddressCurr'] }" />
			</p>
			<p>
				<label>期望居住地：</label>
				<input type="text" size="30" name="humanAddressHope" value="${human['humanAddressHope'] }" />
			</p>
			<div class="divider"></div>
			<dl class="nowrap">
			<dt>个性签名：</dt>
			<dd><textarea name="humanRemark" cols="60" rows="6">${human['humanRemark'] } </textarea></dd>
		 </div>
		<c:import url="../pageControl/submitButton.jsp"></c:import>
	</form>
</div>
