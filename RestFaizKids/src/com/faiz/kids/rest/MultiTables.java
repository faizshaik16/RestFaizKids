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
		//http://192.168.1.103:8080/RestFaizKids/api/faiz/kids/Table?number=25
		return buildHTMLTable("Table for " + number, "Multiplacation Table" , number);
	}
	
	
	@GET
	@Path("/add")
	@Produces (MediaType.TEXT_HTML)
	public String addTwoNumber( @QueryParam("param1") int param1, 
			@QueryParam("param2") int param2){
		
		////http://localhost:8080/RestFaizKids/api/faiz/kids/add?param1=25&param2=25
		//http://192.168.1.103:8080/RestFaizKids/api/faiz/kids/add?param1=25&param2=25
		return buildHTMLAdd("add two number " + param1 + " + " + param2, "add two" , param1, param2);
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
		
		
		for(int i =1; i <101; i++){
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
	
	
private String buildHTMLAdd(String message, String title, int num, int num2){
		
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
		
		
		
			sb.append("<tr><td>");
			String line = num + "  +  " + num2 + "  =  " + (num+num2);
			sb.append(line);
			sb.append("</td></tr>");

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
