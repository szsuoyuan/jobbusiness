<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="../ws/pageControl/jstlImport.jsp" %>
<form id="pagerForm" method="post" action="${pageContext.request.contextPath}/oa/findAllLinkmansByPage/${cId }">
    <input type="hidden" name="pageNum" value="1"/>
	<input type="hidden" name="numPerPage" value="${linkmanlist.pageSize }"/><!-- 每页显示多少条 -->
</form>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="${pageContext.request.contextPath}/oa/findAllLinkmansByPage/${cId }" method="post">
	<div class="searchBar">
		<table class="searchContent" style="float: left;">
			<tr>
				<td>
					联系人姓名：<input type="text" name="lmName" value=""/>
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
			<li><a class="add" href="${pageContext.request.contextPath}/oa/precreatelinkman?lmid=${cId}" target="dialog" title="添加联系人" width="880" height="480" ><span>添加</span></a></li>
			<li><a class="delete" href="${pageContext.request.contextPath}/oa/{sid_user}/deleteLinkman" target="ajaxTodo" title="确认删除吗?" rel="page2"><span>删除</span></a></li>
			<li><a class="edit" href="${pageContext.request.contextPath}/oa/findLinkmanById/{sid_user}" target="dialog" title="修改联系人" width="880" height="480" ><span>修改</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="112">
		<thead>
			<tr>
				<th width="10%">联系人姓名</th>
				<th width="10%">所属客户</th>
				<th width="10%">联系人电话</th>
				<th width="10%">新郎电话</th>
				<th width="10%">新娘电话</th>
				<th width="8%">邮箱</th>
				<th width="10%">创建时间</th>
				<th width="10%">修改时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${linkmanlist.list}" var="lkm">
					<tr target="sid_user" rel="${lkm['lmId'] }">
						<td>${lkm['lmName'] }</td>
						<td>${customer['cName'] }</td>
						<td>${lkm['lmMobile'] }</td>
						<td>${lkm['lmPhone1'] }</td>
						<td>${lkm['lmPhone2'] }</td>
						<td>${lkm['lmEmail'] }</td>
						<td><fmt:formatDate value="${lkm['createTime']}" pattern="yyyy-MM-dd HH:mm"/></td>
						<td><fmt:formatDate value="${lkm['updateTime']}" pattern="yyyy-MM-dd HH:mm"/></td>
					</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select class="combox"  name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})" showvalue="${numPerPage}">
			<option value="10">10</option>
				<option value="15">15</option>
				<option value="20">20</option>
				<option value="30">30</option>
				<option value="40">40</option>
				<option value="50">50</option>
			</select>
			<script>
        		$("select[name='numPerPage']").val('${linkmanlist.pageSize}');
      		</script>
			<span>条，共${linkmanlist.total}条</span>
		</div>
		 <div class="pagination" targetType="navTab" totalCount="${linkmanlist.total}" numPerPage="${linkmanlist.pageSize}"
			pageNumShown="${linkmanlist.pageSize}" currentPage="${linkmanlist.pageNum}"></div>
    </div>
</div>
