<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../ws/pageControl/jstlImport.jsp" %>
<div class="pageContent">
<div id="resultBox"></div>
		<form method="post" action="sys/createsave"  class="pageForm required-validate" onsubmit="return iframeCallback(this,navTabAjaxDone);">
		
		<div class="pageFormContent nowrap" layoutH="56">
		    <dl>
					<dt style="width:80px">角色名称：</dt>
					<dd style="width:200px">
						<input type="text"  id="wtRName" name="wtRName" size="28"  value=""/>
					</dd>
					<dd style="width:25px"></dd>
		    </dl>          
			<br/><br/>
			<div class="divider"></div>
			<dl>
				<dt style="width:80px">角色描述：</dt>
				<dd style="width:200px">
					<input type="text" id="wtRDescription" name="wtRDescription" size="28"   value=""/>
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
			
			<c:forEach items="${menuList}" var="m">
				<c:if test="${m.smFatherid==1 && m.smId>1 }">
						<div class="divider"></div>
						<dl class="aa">
							<dt style="width:80px"><label>
								<input type="checkbox"  class="selectAll"  name="sysmenu" value="${m.smId }"  />${m.smName }：</label>
							</dt>
							<dd  style="width:600px">
								<c:forEach items="${menuList}" var="n">
									<c:if test="${n.smFatherid==m.smId }">
										<label><input type="checkbox" id="sysmenu" name="sysmenu"  value="${n.smId }" />${n.smName }</label>
									</c:if>
								</c:forEach>
							</dd>
						</dl>
				</c:if>
			</c:forEach>
				
			<div class="divider"></div>
			<!--  
			<c:forEach items="${menuList}" var="m">
				<div>
					<c:if test="${m.smFatherid==1 && m.smId>1 }">
						<ul class="tree treeFolder treeCheck expand" oncheck="kkk">
							<li><a tname="name" tvalue="${m.smId }">${m.smName }</a>
								<c:forEach items="${menuList}" var="n">
									<ul>
									<c:if test="${n.smFatherid==m.smId }">
										<li><a tname="name" tvalue="${n.smId }">${n.smName }</a></li>
									</c:if>
									</ul>
								</c:forEach>
							</li>
						</ul>
					</c:if>
				</div>
			</c:forEach>
			-->
			
		</div>
		<c:import url="../ws/pageControl/submitButton.jsp"></c:import>
	</form>
	
	<script type="text/javascript">
function kkk(){
	var json = arguments[0], result="";
//	alert(json.checked);

	$(json.items).each(function(i){
		result += "<p>name:"+this.name + " value:"+this.value+" text: "+this.text+"</p>";
	});
	$("#resultBox").html(result);


}


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


