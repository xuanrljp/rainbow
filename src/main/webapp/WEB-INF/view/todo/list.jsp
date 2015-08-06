<%@ include file="/WEB-INF/view/includes.jsp"%>
<%@ include file="/WEB-INF/view/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container-fluid">
	<div class="row-fluid">
		<c:url value="/todo/create" var="url"/>
	 	<a href="<c:out value='${url}'/>">Create</a>
	</div>
	<div class="row-fluid">
		<div class="span9">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>NO</th>
						<th>タイトル</th>
						<th>アクション</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="task" items="${tasks}">
					<tr>
						<td>${task.id}</td>
						<td>
							<c:url value="/todo/${task.id}/edit" var="url"/>
	 						<a href="<c:out value='${url}'/>">${task.title}</a>
						</td>
						<td>
							<c:url value="/todo/${task.id}/delete" var="delUrl"/>
							<a class="btn btn-danger" href="<c:out value='${delUrl}'/>" role="button">削除</a>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>		
		</div>
	</div>
</div>		
<!--/.fluid-container-->
<%@ include file="/WEB-INF/view/footer.jsp"%>