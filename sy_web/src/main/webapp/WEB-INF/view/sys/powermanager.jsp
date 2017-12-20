<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="../ws/pageControl/jstlImport.jsp" %>
<div class="pageContent">
<div id="resultBox"></div>
		<form method="post" action="sys/updatesave"  class="pageForm required-validate" onsubmit="return iframeCallback(this,navTabAjaxDone);">
		<input type="hidden" name="wtRId" value="${wtrole.wtRId}" />
		<div class="pageFormContent nowrap" layoutH="56">
			<dl>
					<dt style="width:80px">角色名称：</dt>
					<dd style="width:200px">
						<input type="text"  id="wtRName" name="wtRName" size="28"  value="${wtrole.wtRName }"/>
					</dd>
					<dd style="width:25px"></dd>
			</dl>          
			<br/><br/>
			<div class="divider"></div>
			<dl>
				<dt style="width:80px">角色描述：</dt>
				<dd style="width:200px">
					<input type="text" id="wtRDescription" name="wtRDescription" size="28"   value="${wtrole.wtRDescription }"/>
				</dd>
				<dd style="width:25px"></dd>
			</dl>
			<br/><br/>
			<div class="divider"></div>
			<dl>
				<dt style="width:80px;">角色权限：</dt>
				<dd style="width:200px">
				</dd>
				<dd style="width:25px"></dd>
			</dl>
			<br/><br/>
			
			<%--判断checked再次foreach一次 --%>
			<c:forEach items="${menuList}" var="m">
					<c:if test="${m.smFatherid==1 && m.smId>1 }">
							<div class="divider"></div>
							<dl class="aa">
								<dt style="width:80px"><label>
									<input type="checkbox"  class="selectAll"  name="sysmenu" value="${m.smId }"
										<c:forEach items="${rolemenuList}" var="h">
											<c:if test="${m.smId==h }">
												checked="checked"
											</c:if>
										</c:forEach> 
									 />${m.smName }：</label>
								</dt>
								<dd  style="width:600px">
									<c:forEach items="${menuList}" var="n">
										<c:if test="${n.smFatherid==m.smId }">
											<label><input type="checkbox" id="sysmenu" name="sysmenu"  value="${n.smId }" 
												<c:forEach items="${rolemenuList}" var="h">
													<c:if test="${n.smId==h }">
														checked="checked"
													</c:if>
												</c:forEach> 
											/>${n.smName }</label>
										</c:if>
									</c:forEach>
								</dd>
							</dl>
					</c:if>
			</c:forEach>
			<div class="divider"></div>	
		</div>
		<c:import url="../ws/pageControl/submitButton.jsp"></c:import>
	</form>
	
	<script type="text/javascript">
$(function() {  
    $(".selectAll").click(function() {  
         //$('input[name="sysmenu"]').attr("checked",this.checked);   
         //$(this).find("dd").find('input[name="sysmenu"]').attr("checked",this.checked); 
         $(this).parents(".aa").find('input[name="sysmenu"]').attr("checked",this.checked);
     });  
   	 var $subBox = $("input[name='sysmenu']");  
     $subBox.click(function(){
         var index=0;
        // $currBox=  $(this).parents(".aa").find('input[name="sysmenu"]');
         //$(".selectAll").attr("checked",$currBox.length == $("input[name='sysmenu']:checked").length ? true : false);  
        // $(this).parents(".aa").find(".selectAll").attr("checked",this.checked); 
		$(this).parents(".aa").find('input[name="sysmenu"]').each(function(){
			if($(this).attr('checked')){
				index ++;
			}
		});
		
		if(index>=1)
			{
				$(this).parents(".aa").find(".selectAll").attr("checked",true); 
			}else
			{
				$(this).parents(".aa").find(".selectAll").attr("checked",false); 
			}
     });  
 });  
 
</script>
</div>


