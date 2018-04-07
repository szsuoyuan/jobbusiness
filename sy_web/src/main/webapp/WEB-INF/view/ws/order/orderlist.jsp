<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../pageControl/jstlImport.jsp" %>
<form id="pagerForm" method="post" action="${pageContext.request.contextPath}/ws/findAllWsOrdersByPage">
    <input type="hidden" name="pageNum" value="1"/>
	<input type="hidden" name="numPerPage" value="${orderList.pageSize }"/><!-- 每页显示多少条 -->
</form>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="ws/findAllWsOrdersByPage" method="post">
	<div class="searchBar">
		<table class="searchContent" style="float: left;">
			<tr>
				<td>
					报名订单编号：<input type="text" name="oNumber" value=""/>
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
			<li><a class="add" href="ws/preaddorder" target="navTab" title="添加报名信息" ><span>添加</span></a></li>
			<li><a class="delete" href="ws/{sid_user}/deleteOrder" target="ajaxTodo" title="确定要删除吗?" rel="page2"><span>删除</span></a></li>
			<li><a class="edit" href="ws/findOrderById/{sid_user}" target="navTab" title="修改报名信息" width="600" height="360"><span>修改</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="112">
		<thead>
			<tr>
				<th width="12%">报名订单编号</th>
				<th width="10%">报名姓名</th>
				<th width="10%">公司名称</th>
				<th width="6%">职位</th>
				<th width="15%">所属经纪人</th>
				<th width="12%">创建时间</th>
				<th width="12%">修改时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${orderList.list}" var="order">
				<tr target="sid_user" rel="${order.oId }">
					<td>${order['oNumber'] }</td>
					<td>${order['oHumanName'] }</td>
					<td>${order['oCompany'] }</td>
					<td>${order['oJob']==1?"全职":"兼职" }</td>
					<td>${order['oUsername'] }</td>
					<td><fmt:formatDate value="${order.createTime }" pattern="yyyy-MM-dd HH:mm"/></td>
					<td><fmt:formatDate value="${order.updateTime }" pattern="yyyy-MM-dd HH:mm"/></td>
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
        		$("select[name='numPerPage']").val('${orderList.pageSize}');
      		</script>
			<span>条，共${orderList.total}条</span>
		</div>
		 <div class="pagination" targetType="navTab" totalCount="${orderList.total}" numPerPage="${orderList.pageSize}"
			pageNumShown="${orderList.pageSize}" currentPage="${orderList.pageNum}"></div>
    </div>
</div>
