<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="../ws/pageControl/jstlImport.jsp" %>
<div class="pageContent">
	<form method="post" action="${pageContext.request.contextPath}/oa/saveCustomerByUpd" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<p class="contentTitle">修改客户</p>
		<div class="pageFormContent" layoutH="98">
		<input type="hidden" name="cId" value="${customer['cId'] }"/>
		<fieldset>
				<legend>基本信息</legend>
			<p>
				<label>公司名称：</label>
				<input name="cName" class="required" type="text" size="30" value="${customer['cName'] }"/>
			</p>
			<p>
				<label>招工信息：</label>
				<input name="cLuckyDay"  alt="例：加班多 18-40周岁 工资高" type="text" size="30" value="${customer['cLuckyDay'] }"/>
			</p>
			<p>
				<label>公司地址：</label>
				
				<input name="cArea" type="text" size="30" value="${customer['cArea'] }"/>
			</p>
			<p>
				<label>联系人：</label>
				<input type="text" size="30" name="cLinkman" value="${customer['cLinkman'] }"/>
			</p>
			<p>
				<label>手机号码：</label>
				<input  type="text" size="30" name="cMobile" value="${customer['cMobile'] }" />
			</p>
			<p>
				<label>邮箱：</label>
				<input type="text" size="30" name="cMail" value="${customer['cMail'] }" />
			</p>
			</fieldset>
			<fieldset>
				<legend>住宿信息</legend>
			<p>
				<label>位置：</label>
				<input type="text" size="30" name="cWeibo" value="${customer['cWeibo'] }" />
			</p>
			<p>
				<label>环境：</label>
				<input type="text" size="30" name="cAddress" value="${customer['cAddress'] }" />
			</p>
			<p>
				<label>费用：</label>
				<input type="text" size="30" name="cSite" value="${customer['cSite'] }" />
			</p>
			<p>
				<label>厂车：</label>
				<input type="text" size="30" name="cHotel" value="${customer['cHotel'] }" />
			</p>
			<p>
				<label>提示：</label>
				<input type="text" size="30" name="cWechat" value="${customer['cWechat'] }" />
			</p>
			</fieldset>
			<fieldset style="margin-top: 10px;" id="cptp">
				<legend>住宿图片(<font color="#09c">建议上传500像素*500像素的图片,大小500kb以内</font>)</legend>
				<div class="image-container">
					<!-- 显示图片 -->
				</div>
			</fieldset>
			<fieldset>
				<legend>伙食信息</legend>
			<p>
				<label>费用：</label>
				<input type="text" size="30" name="cQq" value="${customer['cQq'] }" />
			</p>
			<p>
				<label>提示：</label>
				<input type="text" size="30" name="cTrde" value="${customer['cTrde'] }" />
			</p>
			</fieldset>
			<fieldset style="margin-top: 10px;" id="cptp">
				<legend>伙食图片(<font color="#09c">建议上传500像素*500像素的图片,大小500kb以内</font>)</legend>
				<div class="image-container-food">
					<!-- 显示图片 -->
				</div>
			</fieldset>
			<fieldset>
				<legend>薪资信息</legend>
				<dl class="nowrap">
					<dt>发薪方式：</dt>
					<dd><textarea name="cJob" cols="60" rows="1">${customer['cJob'] }</textarea></dd>
				</dl>
				<dl class="nowrap">
					<dt>工资计算：</dt>
					<dd><textarea name="cScale" cols="60" rows="1">${customer['cScale'] }</textarea></dd>
				</dl>
			</fieldset>
			<div class="divider"></div>
			<fieldset>
				<legend>公司简介</legend>
				<dl class="nowrap">
					<dt>公司简介：</dt>
					<dd><textarea name="cRemark" cols="60" rows="3">${customer['cRemark'] }</textarea></dd>
				</dl>
			</fieldset>
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

