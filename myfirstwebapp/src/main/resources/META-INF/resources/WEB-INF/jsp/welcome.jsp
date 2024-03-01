<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
	<div>Welcome to in28minutes</div>
	<div>
		Your name: ${name } <br>
		<a href="http://localhost:8080/list-todos">Manage</a> your todos
	</div>
</div>
<%@ include file="common/footer.jspf" %>