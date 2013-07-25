<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>归属地管理</title>
</head>

<body>
	<c:if test="${not empty message}">
		<div id="message" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div>
	</c:if>
	<div class="row">
		<div class="span4 offset7">
			<form class="form-search" action="#">
				<label>名称：</label> <input type="text" name="search_LIKE_title" class="input-medium" value="${param.search_LIKE_title}"> 
				<button type="submit" class="btn" id="search_btn">Search</button>
		    </form>
	    </div>
	    <tags:sort/>
	</div>
	<c:if test="${not empty parentId}">
		<a href="${ctx}/attach?parentId=${theParentId}">返回上级管理【${parentName}】</a>
	</c:if>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>归属地</th><th>管理</th></tr></thead>
		<tbody>
		<c:forEach items="${attachs.content}" var="attach">
			<tr>
				<td><a href="${ctx}/attach/update/${attach.id}">${attach.name}</a></td>
				<td><a href="${ctx}/attach?parentId=${attach.id}">管理下级</a>
				&nbsp;&nbsp;&nbsp;<a href="${ctx}/attach/delete/${attach.id}">删除</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<tags:pagination page="${attachs}" paginationSize="5"/>

	<div><a class="btn" href="${ctx}/attach/create?parentId=${parentId}"">创建归属地</a></div>
</body>
</html>