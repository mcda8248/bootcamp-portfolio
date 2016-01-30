<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Card List</title>
</head>
<body>
	<c:choose>
		<c:when test="${! empty card}">
			<table>
				<c:forEach var="card" items="${card}">
					<tr>
						<td><img src="${card.img}" /></td>
						<td>${card.cost}</td>
						<td>${card.name}</td>
						<td>${card.user}</td>
						<td>${card.type}</td>
						<td>${card.rarity}</td>
						<td>${card.atk}</td>
						<td>${card.hp}</td>
						<td>${card.dust}</td>
						<td><form action="addtodeck.do" method="GET">
								<input type="hidden" name="class" value=${clazz}> <input
									type="hidden" name="set" value=${set}> <input
									type="submit" name="add" value="${card.name}">
							</form></td>
					<tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<p>No state found</p>
		</c:otherwise>
	</c:choose>
	<h2>Your deck:</h2>

	<c:choose>
		<c:when test="${! empty deckcard}">
			<table>
				<c:forEach var="deckcard" items="${deckcard}">
					<tr>
						<td>${deckcard.cost}</td>
						<td>${deckcard.name}</td>
						<td><form
								action="deletefromdeck.do?class=${clazz}&set=${set}"
								method="GET">
								<input type="hidden" name="class" value=${clazz}> <input
									type="hidden" name="set" value=${set}> <input
									type="submit" name="delete" value="${deckcard.name}">
							</form></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<p>No deck found</p>
		</c:otherwise>
	</c:choose>
</html>