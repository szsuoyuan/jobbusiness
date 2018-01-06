<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="../ws/pageControl/jstlImport.jsp" %>
<div class="pageContent">
	<form method="post" action="${pageContext.request.contextPath}/oa/saveLinkman" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="56">
		<input type="hidden" name="lmId" value="${lmId }" />
			<dl class="nowrap">
					<dt>岗位名称：</dt>
					<dd><textarea name="lmName" class="required" cols="60" rows="1"></textarea></dd>
			</dl>
			<dl class="nowrap">
					<dt>岗位月薪：</dt>
					<dd><input name="lmPhone3" class="required" type="text" size="61"/></textarea></dd>
			</dl>
			<dl class="nowrap">
					<dt>工作内容：</dt>
					<dd><textarea name="lmPhone4" cols="60" rows="1"></textarea></dd>
			</dl>
			<dl class="nowrap">
					<dt>工作环境：</dt>
					<dd><textarea name="lmEmail" cols="60" rows="1"></textarea></dd>
			</dl>
			<dl class="nowrap">
					<dt>工作时间：</dt>
					<dd><textarea name="lmPost" cols="60" rows="1"></textarea></dd>
			</dl>
			<dl class="nowrap">
					<dt>工作提示：</dt>
					<dd><textarea name="lmQq" cols="60" rows="1"></textarea></dd>
			</dl>
			<div class="divider"></div>
			<dl class="nowrap">
					<dt>岗位备注：</dt>
					<dd><textarea name="lmPhone6" cols="60" rows="6"></textarea></dd>
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

