<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../pageControl/jstlImport.jsp" %>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="ws/findAllRecords" method="post">
	<div class="searchBar">
		<table class="searchContent" style="float: left;">
			<tr>
				<td>
					员工姓名：<input type="text" name="emName" value=""/>
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
			<li><a class="add" href="ws/preAddHuman" target="dialog" title="添加商家信息" width="720" height="450"><span>添加</span></a></li>
			<li><a class="delete" href="ws/deleteHuman?id={sid_user}" target="ajaxTodo" title="确定要删除吗?" rel="page2"><span>删除</span></a></li>
			<li><a class="edit" href="ws/humanDetails?id={sid_user}&result=xg" target="dialog" title="修改商家信息" width="600" height="360"><span>修改</span></a></li>
		<%--<li><a class="edit" href="ws/humanDetails?id={sid_user}&result=ck" target="dialog" width="600" height="360"><span>查看</span></a></li>--%>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="112">
		<thead>
			<tr>
				<th width="10%">员工姓名</th>
				<th width="10%">员工编号</th>
				<th width="10%">打卡时间</th>
				<th width="10%">是否为有效打卡</th>
				<th width="10%">上班/下班</th>
				<th width="10%">操作人</th>
				<th width="8%">打卡来源</th>
				<th width="12%">定位地址</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${recordList.list }" var="record">
				<tr target="sid_user" rel="">
					<td>${record['emName'] }</td>
					<td>${record['emNumber'] }</td>
					<td><fmt:formatDate value="${record['rTime'] }" pattern="yyyy-MM-dd HH:mm"/></td>
					<td>${record['rValid'] ==1?"有效":"无效"}</td>
					<td>${record['rOnDuty'] ==1?"上班":"下班"}</td>
					<td>${record['rName'] }</td>
					<td>手机打卡</td>
					<td>${record['rAddress'] }</td>
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
			<span>条，共${recordList.total}条</span>
		</div>
		 <div class="pagination" targetType="navTab" totalCount="${recordList.total}" numPerPage="${recordList.pageSize}"
			pageNumShown="${recordList.pageSize}" currentPage="${recordList.pageNum}"></div>
    </div>
</div>
