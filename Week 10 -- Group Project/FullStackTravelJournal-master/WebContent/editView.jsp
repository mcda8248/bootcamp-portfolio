<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="css/materialize.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<link href="css/style.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<title>Main View</title>
</head>
<jsp:include page="navBar.jsp" />​
<body id=view>
	
	<div class="container">
	<div class ="container2">

		<c:forEach var="image" items="${location.images}">

			<div class="col s3 halgin" id="smallbox">
				<div class="card" id="imgCard">
					<div class="card-image img class">
						<ul id="pics">

							<li>
								<figure id ="figureID">
									<img src="${image.img_src}" />
									<figcaption>
										<p>${image.img_text}</p>
									</figcaption>
								</figure>
							</li>

						</ul>
					</div>
				</div>
			</div>

		</c:forEach>

		<div class="videos">
			<c:forEach var="video" items="${location.videos}">
				<iframe width="854" height="900"
					src="https://www.youtube.com/embed/${video.video_src}"
					frameborder="0" allowfullscreen id="video"></iframe>
			</c:forEach>

			<c:forEach var="text" items="${location.texts}">

				<div class="textBox" id="textbox">
					<div class="card">
						<P>${text.bigtext}</P>
					</div>
				</div>

			</c:forEach>
		</div>
		<div class="audio">
			<c:forEach var="audio" items="${location.audios}">
				<audio controls id="aud">
					<source src="${audio.audio_src}">
				</audio>
			</c:forEach>
		</div>
		<div class="NavButton" id="button4">
			<div class="prev">
				<form action="previousLocation.do" method="POST">
					<input type="hidden" name="location_id" value="${location.id}">
					<button class="btn waves-effect waves-light deep-orange halign"
						type="submit">
						Prev Location<i class="material-icons left">fast_rewind</i>
					</button>
				</form>
			</div>
			<div class="next" id="button4">
				<form action="nextLocation.do" method="POST">
					<input type="hidden" name="location_id" value="${location.id}">
					<button class="btn waves-effect waves-light deep-orange  halign"
						type="submit">
						Next Location<i class="material-icons right">fast_forward</i>
					</button>
				</form>
			</div>

		</div>
	</div>
	</div>
</body>
 <script>
 $('img').each(function(){
	    var $height = $(this).height();
	    var $width = $(this).width();
	    var $parent = $(this).parent();
	    $height -= $parent.height();
	    $width -= $parent.width();
	    
	    if($height < $width){
	        $(this).height($(this).parent().height());
	        var $width = $(this).width();
	        $width -= $parent.width();
	        $(this).css('margin-left',-1*( $width/2));
	    }
	    else{
	        $(this).width($(this).parent().width());
	        var $height = $(this).height();
	        $height -= $parent.height();
	        $(this).css('margin-top',-1*( $height/2));
	    }
	    
	});




</script> 

</html>