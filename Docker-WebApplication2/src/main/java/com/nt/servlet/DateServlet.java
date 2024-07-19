package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/dateurl")
public class DateServlet extends HttpServlet {
	
   	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get printwritter
   		PrintWriter writer=res.getWriter();
   		//set response content type
   		res.setContentType("text/html");
   		//write b.logic
   		Date date=new Date();
   		//write the response
   		writer.println("<h1  style='color: red;text-align: center'>Date and Time ::"+date+"</h1>");
   		//add home link
   		writer.println("<br><a href='dateurl'>Home</a>");
   		//close the stream
   		writer.close();
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	       doGet(req, res);
	}

}
