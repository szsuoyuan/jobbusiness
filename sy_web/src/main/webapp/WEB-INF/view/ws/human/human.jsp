<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../pageControl/jstlImport.jsp" %>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="ws/showHuman" method="post">
	<div class="searchBar">
		<table class="searchContent" style="float: left;">
			<tr>
				<td>
					会员名称：<input type="text" name="humanName" value=""/>
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
			<li><a class="add" href="ws/preAddHuman" target="navTab" title="添加会员信息" ><span>添加</span></a></li>
			<li><a class="delete" href="ws/{sid_user}/deleteHuman" target="ajaxTodo" title="确定要删除吗?" rel="page2"><span>删除</span></a></li>
			<li><a class="edit" href="ws/humanDetails?id={sid_user}&result=xg" target="navTab" title="修改会员信息" width="600" height="360"><span>修改</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="112">
		<thead>
			<tr>
				<th width="12%">会员账号</th>
				<th width="10%">真实姓名</th>
				<th width="10%">昵称</th>
				<th width="6%">性别</th>
				<th width="10%">手机号码</th>
				<th width="15%">出生年月</th>
				<th width="12%">创建时间</th>
				<th width="12%">修改时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${humanList.list}" var="human">
				<tr target="sid_user" rel="${human.humanId }">
					<td>${human.humanAccount}</td>
					<td>${human.humanName }</td>
					<td>${human.humanQuestion }</td>
					<td>${human.humanSex==1?"男":"女" }</td>
					<td>${human.humanPhone }</td>
					<td>${human.humanAnswer }</td>
					<td><fmt:formatDate value="${human.createTime }" pattern="yyyy-MM-dd HH:mm"/></td>
					<td><fmt:formatDate value="${human.updateTime }" pattern="yyyy-MM-dd HH:mm"/></td>
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
			<span>条，共${humanList.total}条</span>
		</div>
		 <div class="pagination" targetType="navTab" totalCount="${humanList.total}" numPerPage="${humanList.pageSize}"
			pageNumShown="${humanList.pageSize}" currentPage="${humanList.pageNum}"></div>
    </div>
</div>
