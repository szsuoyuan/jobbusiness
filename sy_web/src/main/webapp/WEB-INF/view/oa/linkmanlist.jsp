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
					岗位名称：<input type="text" name="lmName" value=""/>
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
			<li><a class="add" href="${pageContext.request.contextPath}/oa/precreatelinkman?lmid=${cId}" target="dialog" title="添加岗位信息" width="880" height="480" ><span>添加</span></a></li>
			<li><a class="delete" href="${pageContext.request.contextPath}/oa/{sid_user}/deleteLinkman" target="ajaxTodo" title="确认删除吗?" rel="page2"><span>删除</span></a></li>
			<li><a class="edit" href="${pageContext.request.contextPath}/oa/findLinkmanById/{sid_user}" target="dialog" title="修改岗位信息" width="880" height="480" ><span>修改</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="112">
		<thead>
			<tr>
				<th width="10%">岗位名称</th>
				<th width="10%">岗位月薪</th>
				<th width="15%">工作内容</th>
				<th width="15%">工作时间</th>
				<th width="10%">创建时间</th>
				<th width="10%">修改时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${linkmanlist.list}" var="lkm">
					<tr target="sid_user" rel="${lkm['lmId'] }">
						<td>${lkm['lmName'] }</td>
						<td>${lkm['lmPhone3'] }</td>
						<td>
							<c:choose>
	    						<c:when test="${fn:length(lkm.lmPhone4) > 15}">
	     							<c:out value="${fn:substring(lkm.lmPhone4, 0, 15)}......" />
	   							</c:when>
	    						<c:otherwise>
	     							<c:out value="${lkm.lmPhone4}" />
	    						</c:otherwise>
   							</c:choose>
						</td>
						<td>${lkm['lmPost'] }</td>
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
