 package data;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteJSP
{

    public static void main(String[] args) {
    	
    	String primaryColor = "indigo";
    	
    	StringBuilder header = new StringBuilder(); 
    	header.append("<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\"\n")
    	     .append("	pageEncoding=\"UTF-8\"%>")
    	     .append("<%@ taglib uri=\"http://java.sun.com/jsp/jstl/core\" prefix=\"c\"%>\n")
    	     .append("<%@ taglib uri=\"http://www.springframework.org/tags/form\" prefix=\"form\"%>\n")
    	     .append("")
    	     .append("<html lang=\"en\">\n")
    	     .append("<head>\n")
    	     .append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n")
    	     .append("<meta name=\"viewport\"\n")
    	     .append("	content=\"width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no\" />\n")
    	     .append("<title> Travel Journal</title> \n")
    	     .append("<!-- CSS  -->\n")
    	     .append("<link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\"\n")
    	     .append("	rel=\"stylesheet\">\n")
    	     .append("<link href=\"css/materialize.css\" type=\"text/css\" rel=\"stylesheet\"\n")
    	     .append("	media=\"screen,projection\" \n/>\n")
    	     .append("<link href=\"css/style.css\" type=\"text/css\" rel=\"stylesheet\"")
    	     .append("	media=\"screen,projection\" />\n")
    	     .append("</head>\n")
    	     .append("?");
    	    
    	     StringBuilder bodyStart = new StringBuilder(); 
    	     bodyStart.append("<body>\n")
    	 	.append("")
    	     .append("	<div class=\"row\" id=\"test\">\n")
    	     .append("")
    	     .append("		<div class=\"card indigo lighten-4\" id=\"loginCard\">")
    	     .append("			<div class=\"card-content white-text\">")
    
    	     .append("")
    	     .append("	</div>") 
    	     .append("	</div>");
    	     
    	     
    	     
    	     
    	     StringBuilder bodyEnd = new StringBuilder(); 
    	     
    	     bodyEnd.append("	<script src=\"https://code.jquery.com/jquery-2.1.1.min.js\"></script>")
    	     .append("	<script src=\"js/materialize.js\"></script>")
    	     .append("	<script src=\"js/jquery.lettering.js\"></script>")
    	     .append("<script> document.getElementById(\"p2\").style.background-color = \"#ffca28\";</script>\"\n")
    	     .append("</body>")
    	     .append("<footer> </footer>");
    		

    	
    	
        try {
            FileWriter fw = new FileWriter("test3.jsp");
            PrintWriter pw = new PrintWriter(fw);

            pw.println(header);
            pw.println(bodyStart);
            pw.println(bodyEnd);
            pw.close();
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
	

