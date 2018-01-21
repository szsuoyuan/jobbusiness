<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../pageControl/jstlImport.jsp" %>
<form id="pagerForm" method="post" action="${pageContext.request.contextPath}/ws/findAllReturnFeeByPage">
    <input type="hidden" name="pageNum" value="1"/>
	<input type="hidden" name="numPerPage" value="${feelist.pageSize }"/><!-- 每页显示多少条 -->
</form>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="ws/findAllReturnFeeByPage" method="post">
	<div class="searchBar">
		<table class="searchContent" style="float: left;">
			<tr>
				<td>
					姓名：<input type="text" name="fName" value=""/>
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
			<li><a class="add" href="ws/preaddfee" target="navTab" title="添加返费信息" ><span>添加</span></a></li>
			<li><a class="delete" href="ws/{sid_user}/deleteFee" target="ajaxTodo" title="确定要删除吗?" rel="page2"><span>删除</span></a></li>
			<li><a class="edit" href="ws/findFeeById/{sid_user}" target="navTab" title="修改返费信息" width="600" height="360"><span>修改</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="112">
		<thead>
			<tr>
				<th width="10%">姓名</th>
				<th width="10%">金额</th>
				<th width="10%">费用类型</th>
				<th width="12%">创建时间</th>
				<th width="12%">修改时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${feelist.list}" var="fee">
				<tr target="sid_user" rel="${fee.fId }">
					<td>${fee['fName'] }</td>
					<td>${fee['fMoney'] }</td>
					<td>${fee['fType']==1?"返费":"推荐费" }</td>
					<td><fmt:formatDate value="${fee.createTime }" pattern="yyyy-MM-dd HH:mm"/></td>
					<td><fmt:formatDate value="${fee.updateTime }" pattern="yyyy-MM-dd HH:mm"/></td>
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
        		$("select[name='numPerPage']").val('${feelist.pageSize}');
      		</script>
			<span>条，共${feelist.total}条</span>
		</div>
		 <div class="pagination" targetType="navTab" totalCount="${feelist.total}" numPerPage="${feelist.pageSize}"
			pageNumShown="${feelist.pageSize}" currentPage="${feelist.pageNum}"></div>
    </div>
</div>
