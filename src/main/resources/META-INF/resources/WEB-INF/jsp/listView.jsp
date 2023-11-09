<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
	<table class="table table-sm">
		<thead>
			<tr>
				<th>ID</th>
				<th>Description</th>
				<th>Due</th>
				<th>Status</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
		<thead>
			<c:forEach items="${list}" var="todo">
				<tr>
					<td>${todo.id}</td>
					<td>${todo.description}</td>
					<td>${todo.targetDate}</td>
					<td>${todo.done}</td>
					<td><a href="delete-todo?id=${todo.id}"
						class="btn btn-sm btn-warning"><i class="bi bi-trash3-fill"></i></a>
						<a href="edit-todo?id=${todo.id}" class="btn btn-sm btn-success"><i
							class="bi bi-pencil-square"></i></a></td>
				</tr>
			</c:forEach>
		</thead>
		</tbody>
	</table>
</div>
<%@ include file="common/footer.jspf" %>