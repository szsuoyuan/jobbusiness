<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="../ws/pageControl/jstlImport.jsp" %>
<form id="pagerForm" method="post" action="${pageContext.request.contextPath}/sys/findAllRoles">
    <input type="hidden" name="pageNum" value="1"/>
	<input type="hidden" name="numPerPage" value="${rolelist.pageSize }"/><!-- 每页显示多少条 -->
</form>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="${pageContext.request.contextPath}/sys/findAllRoles" method="post">
	<div class="searchBar">
		<table class="searchContent" style="float: left;">
			<tr>
				<td>
					角色名称：<input type="text" name="wtRName" value=""/>
				</td>
			</tr>
		</table>
		<div class="subBar" style="float: right;">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
			</ul>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="${pageContext.request.contextPath}/sys/precreate" target="navTab" title="添加角色" ><span>添加</span></a></li>
			<li><a class="delete" href="${pageContext.request.contextPath}/sys/{sid_user}/delete" target="ajaxTodo" title="确认删除吗?" rel="page2"><span>删除</span></a></li>
			<li><a class="edit" href="${pageContext.request.contextPath}/sys/searchMenusByRId?rid={sid_user}" target="navTab" title="修改角色"><span>修改</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="112">
		<thead>
			<tr>
				<th width="10%">角色名称</th>
				<th width="20%">角色描述</th>
				<th width="8%">是否可用</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${rolelist.list}" var="role">
					<tr target="sid_user" rel="${role['wtRId']}">
						<td>${role["wtRName"] }</td>
						<td>${role["wtRDescription"] }</td>
						<td>${role["delState"]==1?"是":"否" }</td>
					</tr>
			</c:forEach>
			
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select class="combox"  name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})" showvalue="${numPerPage+1 }">
			<option value="10">10</option>
				<option value="15">15</option>
				<option value="20">20</option>
				<option value="30">30</option>
				<option value="40">40</option>
				<option value="50">50</option>
			</select>
			<script>
        		$("select[name='numPerPage']").val('${rolelist.pageSize}');
      		</script>
			<span>条，共${rolelist.total}条</span>
		</div>
		 <div class="pagination" targetType="navTab" totalCount="${rolelist.total}" numPerPage="${rolelist.pageSize}"
			pageNumShown="${rolelist.pageSize}" currentPage="${rolelist.pageNum}"></div>
    </div>
</div>
