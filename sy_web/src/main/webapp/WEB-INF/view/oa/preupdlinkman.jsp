<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="../ws/pageControl/jstlImport.jsp" %>
<div class="pageContent">
	<form method="post" action="${pageContext.request.contextPath}/oa/saveLinkmanByUpd" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
		<input type="hidden" name="lmId" value="${linkman['lmId']}" />
		<input type="hidden" name="cId" value="${linkman['cId']}" />
			<p>
				<label>岗位名称：</label>
				<input name="lmName" class="required" type="text" size="30" value="${linkman['lmName'] }"/>
			</p>
			<p>
				<label>岗位月薪：</label>
				<input  type="text" size="30"  class="required" name="lmPhone3"value="${linkman['lmPhone3'] }" />
			</p>
			<p>
				<label>岗位地址：</label>
				
				<input name="lmMobile"  type="text" size="30" value="${linkman['lmMobile'] }" />
			</p>
			<p>
				<label>返费：</label>
				<input type="text" size="30" name="lmPhone1" value="${linkman['lmPhone1'] }" />
			</p>
			<p>
				<label>补贴：</label>
				<input type="text" size="30"  name="lmPhone2" value="${linkman['lmPhone2'] }" />
			</p>
			
			<p>
				<label>工作内容：</label>
				<input  type="text" size="30"   name="lmPhone4" value="${linkman['lmPhone4'] }" />
			</p>
			<p>
				<label>工作环境：</label>
				<input  type="text" size="30"  name="lmEmail" value="${linkman['lmEmail'] }" />
			</p>
			<p>
				<label>工作时间：</label>
				<input type="text" size="30" name="lmPost" value="${linkman['lmPost'] }" />
			</p>
			
			<p>
				<label>工作提示：</label>
				<input   type="text" size="30"  name="lmQq" value="${linkman['lmQq'] }" />
			</p>
			<div class="divider"></div>
					<dl class="nowrap">
					<dt>岗位备注：</dt>
					<dd><textarea name="lmPhone6" cols="60" rows="6">${linkman['lmPhone6'] }</textarea></dd>
				</dl>
			<%-- 
				<p>
					<label>微信：</label>
					<input type="text" size="30" name="lmWechat"/>
				</p>
				<p>
					<label>职务：</label>
					<input type="text" size="30" name="lmPost" />
				</p>
				<div class="divider"></div>
					<dl class="nowrap">
					<dt>联系人简介：</dt>
					<dd><textarea name="lmPhone6" cols="60" rows="6"></textarea></dd>
				</dl>
			--%>
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

