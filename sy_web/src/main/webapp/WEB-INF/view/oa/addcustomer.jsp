<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="../ws/pageControl/jstlImport.jsp" %>
<div class="pageContent">
	<form method="post" action="${pageContext.request.contextPath}/${action}" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<p class="contentTitle">添加客户</p>
		<div class="pageFormContent" layoutH="98">
			<p>
				<label>创建人：</label>
				<input name="sysUserName"  type="text" size="30" readonly="readonly" value="${userName}"/>
			</p>
			<p>
				<label>客户名称：</label>
				<input name="cName" class="required" type="text" size="30"/>
			</p>
			<p>
				<label>吉日：</label>
				<input name="cLuckyDay"  alt="例:2018年1月1日" type="text" size="30"/>
			</p>
			<p>
				<label>酒店：</label>
				<input name="cHotel"  type="text" size="30"/>
			</p>
			<p>
				<label>所属区域：</label>
				
				<input name="cArea" type="text" size="30" />
			</p>
			<p>
				<label>主联系人：</label>
				<input type="text" size="30" name="cLinkman" />
			</p>
			<p>
				<label>电话号码：</label>
				<input type="text" size="30" alt="请输入数字" name="cPhone" />
			</p>
			
			<p>
				<label>手机号码：</label>
				<input  type="text" size="30" alt="请输入数字" class="required" name="cMobile"/>
			</p>
			<p>
				<label>客户来源：</label>
				<select name="cResource" class="required combox">
					<option value="1" selected>酒店介绍</option>
					<option value="2" >影楼介绍</option>
					<option value="3">上门客户</option>
					<option value="4">客户介绍</option>
					<option value="5">同行介绍</option>
					<option value="6">媒体资源</option>
					<option value="7">其他</option>
				</select>
			</p>
			<p>
				<label>客户标签：</label>
				<select name="cScale" class="required combox">
					<option value="1" selected>普通</option>
					<option value="2" >重要</option>
					<option value="3">核心</option>
				</select>
			</p>
			<div class="divider"></div>
			<p>
				<label>QQ：</label>
				<input  class="digits" type="text" size="30"  name="cQq"/>
			</p>
			<p>
				<label>微信：</label>
				<input type="text" size="30" name="cWechat"/>
			</p>
			<p>
				<label>邮箱：</label>
				<input type="text" size="30" name="cMail"/>
			</p>
			<p>
				<label>微博：</label>
				<input type="text" size="30" name="cWeibo"/>
			</p>
			<p>
				<label>地址：</label>
				<input type="text" size="30" name="cAddress"/>
			</p>
			<p>
				<label>所属行业：</label>
				<select name="cTrde" class="required combox">
					<option value="">请选择</option>
					<option value="1" selected>婚庆</option>
					<option value="2" >摄像</option>
					<option value="3">灯光</option>
					<option value="4">其它</option>
				</select>
			</p>
			<p>
				<label>网址：</label>
				<input type="text" size="30" name="cSite" />
			</p>
			<p>
				<label>客户状态：</label>
				<select name="cStatus" class="required combox">
					<option value="1" selected>潜在</option>
					<option value="2" >意向</option>
					<option value="3" >洽谈</option>
					<option value="4" >成交</option>
					<option value="5" >流失</option>
				</select>
			</p>
				<div class="divider"></div>
			<dl class="nowrap">
			<dt>客户简介：</dt>
			<dd><textarea name="cRemark" cols="60" rows="6"></textarea></dd>
		</dl>
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

