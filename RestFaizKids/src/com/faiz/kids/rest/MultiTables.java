package com.faiz.kids.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/faiz/kids")
public class MultiTables {
	
	private static String version ="1.0";
	
	@GET
	@Produces (MediaType.TEXT_HTML)
	public String getStatus(){
		//http://localhost:8080/RestFaizKids/api/faiz/kids
		return buildHTML("Kids Rest Web Services" , "BasicOperations");
	}
	
	@GET
	@Path("/version")
	@Produces (MediaType.TEXT_HTML)
	public String getVersion()	{
		
		//http://localhost:8080/RestFaizKids/api/faiz/kids/version
		return buildHTML("Version =" + version , "Version of the Restful Service");
	}
	
	@GET
	@Path("/Table")
	@Produces (MediaType.TEXT_HTML)
	public String getTable( @QueryParam("number") int number){
		
		////http://localhost:8080/RestFaizKids/api/faiz/kids/Table?number=2
		return buildHTMLTable("Table for " + number, "Multiplacation Table" , number);
	}
	
	private String buildHTMLTable(String message, String title, int num){
		
		StringBuffer sb = new StringBuffer();
		sb.append("<!DOCTYPE html>");
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>");
		sb.append(title);
		sb.append("</title>");
		sb.append("</head>");
		sb.append("<body>");
		
		sb.append("<h1>");
		sb.append(title);
		sb.append("</h1>");
		
		sb.append("<p>");
		sb.append(message);
		sb.append("</p>");
		
		sb.append("<table>");
		
		
		for(int i =1; i <11; i++){
			sb.append("<tr><td>");
			String line = num + "  *  " + i + "  =  " + i*num;
			sb.append(line);
			sb.append("</td></tr>");
		}
		sb.append("</table>");
		
		sb.append("</body>");
		sb.append("</html");
		
		return sb.toString();
	}
	
	
private String buildHTML(String message, String title){
		
		StringBuffer sb = new StringBuffer();
		sb.append("<!DOCTYPE html>");
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>");
		sb.append(title);
		sb.append("</title>");
		sb.append("</head>");
		sb.append("<body>");
		
		sb.append("<h1>");
		sb.append(title);
		sb.append("</h1>");
		
		sb.append("<p>");
		sb.append(message);
		sb.append("</p>");
		sb.append("</body>");
		sb.append("</html>");
		
		return sb.toString();
	}

}
