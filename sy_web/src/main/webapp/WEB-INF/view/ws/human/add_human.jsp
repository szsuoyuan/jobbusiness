<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../pageControl/jstlImport.jsp" %>
<div class="pageContent">
		<form method="post" action="ws/addHuman"  class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<p class="contentTitle">添加会员信息</p>
		<div class="pageFormContent" layoutH="98">
			<p>
				<label>会员账号：</label>
				<input name="humanAccount" class="required" type="text" size="30"/>
			</p>
			<p>
				<label>会员密码：</label>
				
				<input name="humanPassword" type="text" size="30" />
			</p>
			<p>
				<label>昵称：</label>
				<input type="text" size="30" name="humanQuestion" />
			</p>
			<p>
				<label>性别：</label>
				<input type="radio" name="humanSex" value="1" />男
				<input type="radio" name="humanSex" value="2" />女
			</p>
			<p>
				<label>出生年月：</label>
				<input type="text" name="humanAnswer" class="date" size="30" /><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>手机号码：</label>
				
				<input name="humanPhone" type="text" size="30" />
			</p>
			<p>
				<label>真实姓名：</label>
				<input type="text" size="30" name="humanName" />
			</p>
			<p>
				<label>家乡：</label>
				<input  type="text" size="30"  name="humanAddress"/>
			</p>
			<p>
				<label>求职状态：</label>
				<select name="humanStatus" class="required combox">
					<option value="">请选择</option>
					<option value="1" selected>正在求职</option>
					<option value="2" >已经工作</option>
				</select>
			</p>
			<p>
				<label>学历：</label>
				<select name="humanEducation" class="required combox">
					<option value="">请选择</option>
					<option value="1" selected>大专</option>
					<option value="2" >本科</option>
					<option value="3">博士</option>
					<option value="4">其它</option>
				</select>
			</p>
			<p>
				<label>现在居住地：</label>
				<input type="text" size="30" name="humanAddressCurr" />
			</p>
			<p>
				<label>期望居住地：</label>
				<input type="text" size="30" name="humanAddressHope"/>
			</p>
			<div class="divider"></div>
			<dl class="nowrap">
			<dt>个性签名：</dt>
			<dd><textarea name="humanRemark" cols="60" rows="6"></textarea></dd>
		 </div>
		<c:import url="../pageControl/submitButton.jsp"></c:import>
	</form>
</div>
