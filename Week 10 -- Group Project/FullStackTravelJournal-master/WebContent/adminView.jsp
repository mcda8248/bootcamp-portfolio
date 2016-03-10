
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<jsp:include page="adminBar.jsp" />​
<div class="row" id="test">

	<div class="row" id="tripViewer">
		<ul class="collapsible popout red" data-collapsible="accordion"
			id="BoxofTrips">


			<c:forEach var="user" items="${allusers}">
				<li>
					<div class="collapsible-header">
						<i class="material-icons"> edit</i>Edit user ${user.username}
					</div>
					<div class="collapsible-body indigo lighten-2">

						<div class="card-panel teal">
							<div class="tablerow">
								<div class="tripName">Account of ${user.username}</div>
							</div>
							<div class="editLoc">
								<form action="editAccount.do" method="POST">
									<input type="hidden" name="username" value="${user.username}">
									<button class="btn-floating btn waves-effect waves-light blue"
										type="submit">
										<i class="material-icons">mode_edit</i>
									</button>



								</form>
							</div>

							<div class="deleteLoc">
								<form action="deleteAccount.do" method="POST">
									<button class="btn-floating btn red" type="submit">
										<i class="material-icons right">delete</i>
									</button>
									<input type="hidden" name="username" value="${user.username}">
								</form>

							</div>

						</div>
					<%-- <li>
						<c:forEach var="trip" items="${user.trips}">
							
								<!-- <div class ="Trip Header"> -->


								<div class="collapsible-header" id="collapseHeader">
									<i class="material-icons">grade</i>${trip.trip_name}

								</div>
						</c:forEach>
				</li> --%>
	</div>
	</li>
	</c:forEach>
	</ul>

</div>
</div>
<div class="row" id="test"></div>
​ ​ ​ ​<jsp:include page="background.jsp" />​
</body>