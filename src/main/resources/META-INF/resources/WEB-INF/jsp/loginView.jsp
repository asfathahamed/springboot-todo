<html>
	<head>
		<title>My first JSP page</title>
	</head>
	<body>
		<h1>Login</h1>
		<pre>${errorMessage}</pre>
		<form method="post">
			<input type="text" name="name" placeholder="Username" value="Asfath" />
			<input type="password" name="password" placeholder="Password" value="Dummy" />
			<button type="submit">Submit</button>
		</form>
	</body>
</html>