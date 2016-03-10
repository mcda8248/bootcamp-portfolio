<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<jsp:include page="navBar.jsp" />​
	​
	<div class="row" id="test">

		<div class="card cyan" id="loginCardIndex">
			<div class="card-content white-text">

				<span class="card-title" id="cardTitle">Create new Trip</span>
				<form class="col s12" action="CreateTripDB.do" method="POST">
					<div class="row">
						<div class="input-field col s10">
							<input id="trip_name" name="trip_name" type="text"
							><label for="trip_name">Trip Name</label>
						</div>
					</div>
					
					<div class="row">
						<div class="input-field col s5">
						<p>Date started </p>
							<input id="date_started"  name="date_started" type="date" placeholder = "Date Started" class="datepicker"> 
							<label
								for="date_started"></label>
						</div>
					
				
						<div class="input-field col s5">
						<p>Date Ended</p>
							<input id="date_ended"  name="date_ended" type="date" class="datepicker"> 
						</div>
					</div>


					<button class="btn waves-effect waves-light deep-orange"
						type="submit">
						Submit <i class="material-icons right">send</i>
					</button>
				</form>


<div class="row">
						<div class="input-field col s12">
							<input id="email" type="hidden" class="validate"> 
						</div>
					</div>

				
			</div>
		</div>

	</div>

	​ ​
​ ​<jsp:include page="background.jsp" />​
</body>
<footer> </footer>