<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="stylesheet.css">
<title>Search Results</title>
</head>
<body>
	<header>
	<div class="home">
		<a href="index.html">iFind</a>
	</div>
	<ul>
		<li><a href="query.html">Search!</a></li>
		<li><a href="update.html">Update!</a></li>
	</ul>
	</header>
	<p>Number of rows updated: ${numUpdates }</p>
</body>
</html>