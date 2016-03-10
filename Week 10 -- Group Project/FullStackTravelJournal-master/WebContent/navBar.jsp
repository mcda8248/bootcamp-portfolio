<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no" />
<title>Travel Journal</title> ​
<!-- CSS  -->
<link href='https://fonts.googleapis.com/css?family=Kameron' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Merriweather' rel='stylesheet' type='text/css'>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="css/materialize.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<link href="css/style.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
</head>
​
<body>

<nav>
    <div class="nav-wrapper blue-grey darken-4" id = "nav1">
      <a href="#" class="brand-logo right">${user.username} 's Travel Journal</a>
      <ul id="nav-mobile" class="left hide-on-med-and-down">
      
        <li><a href="loadDashboard.do">Dashboard</a></li>
       <!--  <li><a href="editlocation.do">View </a></li> -->
        <li><a href="logout.do">Logout</a></li>
      </ul>
    </div>
  </nav>
        

