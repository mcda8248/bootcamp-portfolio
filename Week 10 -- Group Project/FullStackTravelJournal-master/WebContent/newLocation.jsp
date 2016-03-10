<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<jsp:include page="navBar.jsp" />​ ​
<div class="row" id="test3">


		<form class="col s12 cyan z-depth-2" action="CreateLocationDB.do" method="POST" id ="form">
		<div class="col s6 left"  id ="locationForm">
			<div class="card-content white-text">
				<h3>Create new Location</h3>
				
					<div class="row">
						<div class="input-field col s10">
							<input id="location_name" name="location_name" type="text"  value ="Sunwell"><label
								for="location_name" id ="label1">Location Name</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s5">
							<input id="city" name="city" type="text" value ="Greenwood Village"><label
								for="city" id ="label1">City</label>
						</div>

						<div class="input-field col s5">
							<input id="country" name="country" type="text" value ="USA"><label
								for="country" id ="label1">Country</label>
						</div>
					</div>

					<div class="row">
						<div class="input-field col s5">
							<p>Date started</p>
							<input id="date_started" name="date_started" type="date"
								placeholder="Date Started" class="datepicker"> <label
								for="date_started"></label>
						</div>

						<div class="input-field col s5">
							<p>Date Ended</p>
							<input id="date_ended" name="date_ended" type="date"
								class="datepicker">
						</div>
					</div>

					<input type="hidden" name="trip_id" value="${trip_id}">

					<button class="btn waves-effect waves-light deep-orange"
						type="submit">
						Submit <i class="material-icons right">send</i>
					</button>

				<div class="row">
					<div class="input-field col s12">
						<input id="email" type="hidden" class="validate">
					</div>
				</div>
			</div>
		</div>

<div class="col s3 right">
	
			<div class="card-content white-text">
				<h5>Add Images</h5>
			</div>
			<div class="row">
				<div class="input-field col s12 white-text">
				  <!-- Dropdown Trigger -->
  <a class='dropdown-button btn deep-orange' href='#' data-activates='dropdown1'>Add Image Link</a>

  <!-- Dropdown Structure -->
  <ul id='dropdown1' class='dropdown-content '>

	 <li> <input type="text" name="img_src1" id="img_src1" value ="http://images4.fanpop.com/image/photos/18700000/Dragons-16falloutboy-18700713-500-313.jpg">

	    <li> 
	    		<textarea rows="" cols="" name="img_txt1" id="img_txt1"> Caption for image
					</textarea>				
    <li> <input type="text" name="img_src2" id="img_src2" value ="">

	    <li> 
	    		<textarea rows="" cols="" name="img_txt2" id="img_txt2"> Caption for image
					</textarea>
	    
	   <li> <input type="text" name="img_src3" id="img_src3" value ="">

	    <li> 
	    		<textarea rows="" cols="" name="img_txt3" id="img_txt3"> Caption for image
					</textarea>  
	    <li> <input type="text" name="img_src4" id="img_src4" value ="">

	    <li> 
	    		<textarea rows="" cols="" name="img_txt4" id="img_txt4"> Caption for image
					</textarea>
	
				
    
  </ul>
				
				
				
					<!-- <label for="img_txt">Caption for Image</label> -->
				</div>
		</div>
		</div>
		
		<div class="col s3 right">
			<div class="card-content white-text">
				<h5>Add Video</h5>
			</div>
			<div class="row">
				<div class="input-field col s12 white-text">

					<input type="text" name="video_src" id="video_src" value ="https://www.youtube.com/watch?v=HEf_xrgmuRI">
					<label for="video_src" id ="label1">Video Link</label>
					
					<textarea rows="" cols="" name="video_txt" id="video_txt"> Caption for Video
					</textarea>
				</div>
			</div>
		</div>
		<div class="col s3 right">
			<div class="card-content white-text">
				<h5>Add Text</h5>
			</div>
			<div class="row">
				<div class="input-field col s12 white-text">

					<input type="text" name="text_header" id="text_header" value ="my test">
					<label for="text_header" id ="label1">Text Header</label>
					<textarea rows="" cols="" name="text_body" id="text_body" > Your Story
					</textarea>
				</div>
			</div>
		</div>
			<div class="col s3 right">
			<div class="card-content white-text">
				<h5>Add Audio</h5>
			</div>
			<div class="row">
				<div class="input-field col s12 white-text">

					<input type="text" name="audio_src" id="audio_src" value ="www.youtube.com">
					<label for="audio_src" id ="label1">Text Header</label>
					<textarea rows="" cols="" name="audio_text" id="audio_txt" > Audio Source
					</textarea>
				</div>
			</div>
		</div>
		</form>
</div>		
		
	





​ ​
​ ​<jsp:include page="background.jsp" />​

<script>
 $('.dropdown-button').dropdown({
      inDuration: 300,
      outDuration: 225,
      constrain_width: false, // Does not change width of dropdown to that of the activator
      hover: true, // Activate on hover
      gutter: 0, // Spacing from edge
      belowOrigin: false, // Displays dropdown below the button
      alignment: 'left' // Displays dropdown with edge aligned to the left of button
    }
  );


	
	</script>
<!-- 
<script>
	$('.datepicker').pickadate({
    selectMonths: true, // Creates a dropdown to control month
    selectYears: 15 // Creates a dropdown of 15 years to control year
  });
	</script> -->
	
<script>

function geocodePlaceId(geocoder, map, infowindow) {
	  var placeId = document.getElementById('place-id').value;
	  geocoder.geocode({'placeId': placeId}, function(results, status) {
	    if (status === google.maps.GeocoderStatus.OK) {
	      if (results[0]) {
	        map.setZoom(11);
	        map.setCenter(results[0].geometry.location);
	        var marker = new google.maps.Marker({
	          map: map,
	          position: results[0].geometry.location
	        });
	        infowindow.setContent(results[0].formatted_address);
	        infowindow.open(map, marker);
	      } else {
	        window.alert('No results found');
	      }
	    } else {
	      window.alert('Geocoder failed due to: ' + status);
	    }
	  });
	}


</script>	
</body>
<footer> </footer>