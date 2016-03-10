
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<jsp:include page="navBar.jsp" />​
<div class="row" id="test">

	<div class="row" id="tripViewer">
		<ul class="collapsible popout cyan" data-collapsible="accordion"
			id="BoxofTrips">
			<c:choose>
				<c:when test="${! empty user.trips}">
					<h3 id="userHeaderTrip">${user.username}'s Trips</h3>
					<c:forEach var="trip" items="${user.trips}">
						<li>
							<!-- <div class ="Trip Header"> -->


							<div class="collapsible-header" id="collapseHeader">
								<i class="material-icons">grade</i>${trip.trip_name}

							</div>
							<div class="tripDelete">
								<form action="deleteTrip.do" method="POST">
									<button class="btn-floating btn red" type="submit">
										<i class="material-icons right">delete</i>
									</button>
									<input type="hidden" name="trip_id" value="${trip.id}">

								</form>

							</div> <!-- </div> -->

							<div class="collapsible-body cyan darken-2"
								id="tripCardContainer">

								<c:forEach var="location" items="${trip.locations}">





									<div class="card-panel cyan lighten-4" id="tripCard">
										<div class="tablerow">
											<div class="tripName">${location.locationName}</div>
											<div class="deleteLoc">
												<form action="deletelocation.do" method="POST">
													<button class="btn-floating btn red" type="submit">
														<i class="material-icons right">delete</i>
													</button>
													<input type="hidden" name="trip_id" value="${trip.id}">
													<input type="hidden" name="location_id"
														value="${location.id}">
												</form>

											</div>

											<div class="editLoc">
												<form action="view.do" method="POST">
													<input type="hidden" name="trip_id" value="${trip.id}">
													<input type="hidden" name="location_id"
														value="${location.id}">
													<button
														class="btn-floating btn waves-effect waves-light blue"
														type="submit">
														<i class="material-icons">mode_edit</i>
													</button>
												</form>
											</div>
											<div class="deleteLoc">
<form action="email.do" method="POST">

												<a class=" dropdown-button btn btn-floating btn deep-orange"
													href='#' data-activates='dropdown1'> <i
													class="material-icons right">email</i></a>

												<!-- Dropdown Structure -->
												<ul id='dropdown1' class='dropdown-content'>

													<li>Add Email Address</li>
													<li><input type="text" name="emailId" id="emailId">
													<input type="hidden" name="journalLink" value="localhost:8080/TravelJournal/share.do?trip=${trip.id}">
												<%-- 	<input type="hidden" name="journalLink" value="aunpsebastian.com:8080/traveljournal/share.do?trip=${trip.id}"> --%>

													</li>

													<li>

														

															<input type="hidden" name="trip_id" value="${trip.id}">
															<button class="btn waves-effect waves-light deep-orange"
																type="submit">
																Send email <i class="material-icons right">send</i>
															</button>
														
													</li>

												</ul>

</form>

											</div>
											<div class="editLoc3">
												<form action="editlocation.do" method="POST">
													<input type="hidden" name="trip_id" value="${trip.id}">
													<input type="hidden" name="location_id"
														value="${location.id}">
													<button class="btn waves-effect waves-light deep-orange"
														type="submit">
														View <i class="material-icons right">send</i>
													</button>
												</form>
											</div>

										</div>
									</div>


								</c:forEach>

								<form action="addlocation.do" method="POST">

									<input type="hidden" name="trip_id" value="${trip.id}">
									<button class="btn waves-effect waves-light deep-orange"
										type="submit">
										Add a Location <i class="material-icons right">send</i>
									</button>
								</form>
							</div>
						</li>
					</c:forEach>

				</c:when>
				<c:otherwise>
					<h1>List is empty</h1>
				</c:otherwise>
			</c:choose>




		</ul>
	</div>
</div>
<div class="row" id="test">

	<div class="card cyan" id="addTrip">
		<div class="card-content white-text">
			<form action="addtrip.do" method="POST">

				<button class="btn waves-effect waves-light deep-orange"
					type="submit">
					Add a Trip <i class="material-icons right">send</i>
				</button>


			</form>
		</div>
	</div>
</div>
​ ​
<jsp:include page="background.jsp" />​
<script>
	$('.dropdown-button').dropdown({
		inDuration : 300,
		outDuration : 225,
		constrain_width : false, // Does not change width of dropdown to that of the activator
		hover : true, // Activate on hover
		gutter : 0, // Spacing from edge
		belowOrigin : false, // Displays dropdown below the button
		alignment : 'left' // Displays dropdown with edge aligned to the left of button
	});
</script>
</body>