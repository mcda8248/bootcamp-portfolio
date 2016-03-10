<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no" />
<title> Travel Journal</title> ​
<!-- CSS  -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="css/materialize.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<link href="css/style.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
</head>
​
<body>
<div class ="test">
</div>

 <div class="card cyan" id="loginCard2">
			<div class="card-content white-text">
				<form action="GetUserTravel.do" method="POST">
					<span class="card-title" id ="cardTitle">Login</span>
					
					 <input type="text" name="username" placeholder = "<c:choose>
		<c:when test="${! empty userNotFound}">
			${userNotFound}

		</c:when>
	</c:choose>"> 
					 <input type="password" name="password" >

					
						<button class="btn waves-effect waves-light deep-orange"
							type="submit">
							Submit <i class="material-icons right">send</i>
						</button>
				</form>
				
				<form action="CreateUserTravel.do" method="POST">
					<button class="btn waves-effect waves-light deep-orange"
						type="submit">
						Create new user <i class="material-icons right">send</i>
					</button>
				</form>
			</div>
		</div>

<jsp:include page="background.jsp" />​
	​
	
</body>
<footer> </footer>