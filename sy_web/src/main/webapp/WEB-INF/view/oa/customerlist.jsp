<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="../ws/pageControl/jstlImport.jsp" %>
<form id="pagerForm" method="post" action="${pageContext.request.contextPath}/oa/findAllCustomersByPage">
    <input type="hidden" name="pageNum" value="1"/>
	<input type="hidden" name="numPerPage" value="${customlist.pageSize }"/><!-- 每页显示多少条 -->
</form>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="${pageContext.request.contextPath}/oa/findAllCustomersByPage" method="post">
	<div class="searchBar">
		<table class="searchContent" style="float: left;">
			<tr>
				<td>
					公司名称：<input type="text" name="cName" value=""/>
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
			<li><a class="add" href="${pageContext.request.contextPath}/oa/precreatecustomer?param=cus" target="navTab" title="添加公司信息" width="820" height="400" ><span>添加</span></a></li>
			<li><a class="delete" href="${pageContext.request.contextPath}/oa/{sid_user}/deleteCustomer" target="ajaxTodo" title="确认删除吗?" rel="page2"><span>删除</span></a></li>
			<li><a class="edit" href="${pageContext.request.contextPath}/oa/findCustomerById/{sid_user}" target="navTab" title="修改公司信息"><span>修改</span></a></li>
			<li class="line">line</li>
			<li><a class="edit" href="${pageContext.request.contextPath}/oa/findAllLinkmansByPage/{sid_user}" target="navTab"	rel="020" title="查看岗位信息" ><span>岗位信息</span></a></li>
			<li><a class="edit" href="${pageContext.request.contextPath}/oa/findAllRecordsByPage/{sid_user}" target="navTab"	rel="040" title="查看临时工记录" ><span>临时工信息</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="112">
		<thead>
			<tr>
				<th width="12%">公司名称</th>
				<th width="12%">招工信息</th>
				<th width="10%">手机号码</th>
				<th width="8%">联系人</th>
				<th width="12%">公司地址</th>
				<th width="10%">创建时间</th>
				<th width="10%">修改时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${customlist.list}" var="cus">
					<tr target="sid_user" rel="${cus['cId'] }">
						<td><a class="sortfont" target="navTab" title="查看岗位信息" href="${pageContext.request.contextPath}/oa/findAllLinkmansByPage/${cus['cId'] }">${cus['cName'] }</a></td>
						<td>${cus['cLuckyDay'] }</td>
						<td>${cus['cMobile'] }</td>
						<td>${cus['cLinkman'] }</td>
						<td>${cus['cArea'] }</td>
						<td><fmt:formatDate value="${cus['createTime']}" pattern="yyyy-MM-dd HH:mm"/></td>
						<td><fmt:formatDate value="${cus['updateTime']}" pattern="yyyy-MM-dd HH:mm"/></td>
					</tr>
			</c:forEach>
			
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select class="combox"  name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
			<option value="10">10</option>
				<option value="15">15</option>
				<option value="20">20</option>
				<option value="30">30</option>
				<option value="40">40</option>
				<option value="50">50</option>
			</select>
			<script>
        		$("select[name='numPerPage']").val('${customlist.pageSize}');
      		</script>
			<span>条，共${customlist.total}条</span>
		</div>
		 <div class="pagination" targetType="navTab" totalCount="${customlist.total}" numPerPage="${customlist.pageSize}"
			pageNumShown="${customlist.pageSize}" currentPage="${customlist.pageNum}"></div>
    </div>
</div>
