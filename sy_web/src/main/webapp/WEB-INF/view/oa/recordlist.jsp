<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="../ws/pageControl/jstlImport.jsp" %>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="${pageContext.request.contextPath}/oa/findAllRecordsByPage" method="post">
	<div class="searchBar">
		<table class="searchContent" style="float: left;">
			<tr>
				<td>
					更进方式：<input type="text" name="rMode" value=""/>
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
			<li><a class="add" href="${pageContext.request.contextPath}/oa/precreaterecord?cid=${cId}" target="dialog" title="添加更进记录" width="650" height="400" ><span>添加</span></a></li>
			<li><a class="delete" href="${pageContext.request.contextPath}/oa/{sid_user}/deleteRecord" target="ajaxTodo" title="确认删除吗?" rel="page2"><span>删除</span></a></li>
			<li><a class="edit" href="${pageContext.request.contextPath}/oa/findRecordById/{sid_user}" target="dialog" title="修改跟进记录" width="650" height="400" ><span>修改</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="112">
		<thead>
			<tr>
				<th width="10%">跟进对象</th>
				<th width="10%">跟进方式</th>
				<th width="10%">主要事宜</th>
				<th width="8%">跟进结果</th>
				<th width="10%">创建时间</th>
				<th width="10%">修改时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${recordlist.list}" var="r">
					<tr target="sid_user" rel="${r['rId'] }">
						<td>${r['rCustomer'] }</td>
						<td>
						<c:choose>
							<c:when test="${r['rMode']==1 }">
							电话
							</c:when>
							<c:when test="${r['rMode']==2 }">
							微信
							</c:when>
							<c:when test="${r['rMode']==3 }">
							面谈
							</c:when>
							<c:when test="${r['rMode']==4 }">
							QQ
							</c:when>
							<c:when test="${r['rMode']==5 }">
							短信
							</c:when>
							<c:when test="${r['rMode']==6 }">
							邮件
							</c:when>
							<c:when test="${r['rMode']==7}">
							其他
							</c:when>
						</c:choose>
						</td>
						<td>
						<c:choose>
							<c:when test="${r['rMainThing']==1 }">
							初期沟通
							</c:when>
							<c:when test="${r['rMainThing']==2 }">
							问卷调查
							</c:when>
							<c:when test="${r['rMainThing']==3 }">
							需求分析
							</c:when>
							<c:when test="${r['rMainThing']==4 }">
							方案报价
							</c:when>
							<c:when test="${r['rMainThing']==5 }">
							谈判审核
							</c:when>
						</c:choose>
						</td>
						<td>
						<c:choose>
							<c:when test="${r['rResult']==1 }">
							继续更进
							</c:when>
							<c:when test="${r['rResult']==2 }">
							成功签单
							</c:when>
							<c:when test="${r['rResult']==3 }">
							客户流失
							</c:when>
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
