<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
	<form:form method="post" class="row g-3" modelAttribute="todo">
		<div class="col-12">
			<form:label path="description" class="form-label">Description</form:label>
			<form:input type="text" class="form-control" path="description"
				required="required" placeholder="enter you to do..."
				id="description-field" value="Learn ..." />
			<form:errors path="description"
				class="was-validated invalid-feedback" />
		</div>
		<div class="col-12">
			<form:label path="targetDate" class="form-label">Due Date</form:label>
			<form:input type="date" class="form-control" path="targetDate"
				id="due-date-field" required="required" value="${todo.targetDate}" />
			<form:errors path="targetDate" class="was-validated invalid-feedback" />
		</div>
		<div class="col-12">
			<button type="submit" class="btn btn-success btn-sm">Submit</button>
		</div>
		<form:input type="hidden" path="id" />
		<form:input type="hidden" path="username" />
		<form:input type="hidden" path="done" />
	</form:form>
</div>
<%@ include file="common/footer.jspf" %>