<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="../ws/pageControl/jstlImport.jsp" %>
<div class="pageContent">
	<form method="post" action="${pageContext.request.contextPath}/sys/saveEmployeeByUpd" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<p class="contentTitle">修改经纪人</p>
		<div class="pageFormContent" layoutH="98">
			<input type="hidden" name="eId" value="${emp['eId'] }"/>
			<p>
				<label>经纪人姓名：</label>
				<input name="eName" class="required" type="text" size="30" value="${emp['eName'] }"/>
			</p>
			<p>
				<label>经纪人编号：</label>
				
				<input name="eNumber" type="text" size="30"   value="${emp['eNumber'] }"/>
			</p>
			<p>
				<label>英文名：</label>
				<input type="text" size="30" name="eEnName" value="${emp['eEnName'] }"/>
			</p>
			<p>
				<label>手机号码：</label>
				<input  class="digits" type="text" size="30" alt="请输入数字" name="eMobile"	value="${emp['eMobile'] }"/>
			</p>
			<p>
				<label>电话号码：</label>
				<input type="text" size="30" name="ePhone" value="${emp['ePhone'] }"/>
			</p>
			
			<p>
				<label>性别：</label>
				<%-- 
				<select name="eSex" class="required combox">
					<option value="1" selected>男</option>
					<option value="2" >女</option>
				</select>
				--%>
				<input type="radio" name="eSex" value="1" 
					<c:if test="${emp['eSex']==1 }">checked="checked"</c:if>
				/>男
				<input type="radio" name="eSex"	value="2" 
					<c:if test="${emp['eSex']==2 }">checked="checked"</c:if>
				/>女
			</p>
			<p>
				<label>生日：</label>
				
				<input type="text" name="eBirthday" class="date" size="30" value="${emp['eBirthday'] }"/><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>邮箱：</label>
				<input type="text" size="30" name="eMail" value="${emp['eMail'] }"/>
			</p>
			<p>
				<label>地址：</label>
				<input type="text" size="30" name="eAddress" value="${emp['eAddress'] }"/>
			</p>
			<p>
				<label>学历：</label>
				<select name="eEducation" class="required combox">
					<option value="">请选择</option>
					<option value="1" <c:if test="${emp['eEducation']==1 }">selected</c:if> >大专</option>
					<option value="2" <c:if test="${emp['eEducation']==2 }">selected</c:if> >本科</option>
					<option value="3" <c:if test="${emp['eEducation']==3 }">selected</c:if> >博士</option>
					<option value="4" <c:if test="${emp['eEducation']==4 }">selected</c:if> >其它</option>
				</select>
			</p>
			<p>
				<label>毕业学校：</label>
				<input type="text" size="30" name="eCollege" value="${emp['eCollege'] }"/>
			</p>
			<p>
				<label>选择账号：</label>
				<input id="inputOrg1" name="user.id" value="${emp['sysUserId']}" type="hidden" />
				<input id="inputOrg1" name="user.orgName" value="" type="hidden"/>
				<input type="text" readonly="readonly"  name="user.userName" value="${emp['sysUserId'] }"/>
				<a class="btnLook" href="sys/lookUpUserList" lookupGroup="user">查找带回</a>		
			</p>
			<p>
				<label>经纪人状态：</label>
				<select name="eState" class="required combox">
					<option value="1" <c:if test="${emp['eState']==1 }">selected</c:if>	>正常</option>
					<option value="2" <c:if test="${emp['eState']==2 }">selected</c:if>	>离职</option>
				</select>
			</p>
		</div>
		<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>
</body>

