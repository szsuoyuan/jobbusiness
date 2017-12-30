<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="../ws/pageControl/jstlImport.jsp" %>
<form id="pagerForm" method="post" action="${pageContext.request.contextPath}/oa/findAllRecordsByPage">
    <input type="hidden" name="pageNum" value="1"/>
	<input type="hidden" name="numPerPage" value="${recordlist.pageSize }"/><!-- 每页显示多少条 -->
</form>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="${pageContext.request.contextPath}/oa/findAllRecordsByPage" method="post">
	<div class="searchBar">
		<table class="searchContent" style="float: left;">
			<%-- 
				<tr>
					<td>
						更进方式：<input type="text" name="rMode" value=""/>
					</td>
				</tr>
			--%>
		</table>
		<div class="subBar" style="float: right;">
			<%--
				<ul>
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
				</ul>
			 --%>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
		</ul>
	</div>
	<table class="table" width="100%" layoutH="112">
		<thead>
			<tr>
				<th width="10%">所属公司</th>
				<th width="12%">职位日薪</th>
				<th width="20%">职位简介</th>
				<th width="10%">创建时间</th>
				<th width="10%">修改时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${recordlist.list}" var="r">
					<tr target="sid_user" rel="${r['rId'] }">
						<td>${r['rCustomer'] }</td>
						<td>${r['rResult'] }</td>
						<td>
						<c:choose>
    						<c:when test="${fn:length(r.rRemark) > 15}">
     							<c:out value="${fn:substring(r.rRemark, 0, 15)}......" />
   							</c:when>
    						<c:otherwise>
     							<c:out value="${r.rRemark}" />
    						</c:otherwise>
   						</c:choose>
						</td>
						<td><fmt:formatDate value="${r['createTime']}" pattern="yyyy-MM-dd HH:mm"/></td>
						<td><fmt:formatDate value="${r['updateTime']}" pattern="yyyy-MM-dd HH:mm"/></td>
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
			<span>条，共${recordlist.total}条</span>
		</div>
		 <div class="pagination" targetType="navTab" totalCount="${recordlist.total}" numPerPage="${recordlist.pageSize}"
			pageNumShown="${recordlist.pageSize}" currentPage="${recordlist.pageNum}"></div>
    </div>
</div>
