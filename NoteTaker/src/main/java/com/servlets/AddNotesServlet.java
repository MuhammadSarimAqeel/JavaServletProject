package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.todo;
import com.helper.FactoryProvider;


public class AddNotesServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
			 response.setContentType("text/html");
		        PrintWriter out = response.getWriter();
		        
		        
			 String title= request.getParameter("title");
			 String content = request.getParameter("content");
			 
			 todo note = new todo(title, content, new Date());
			 // hibernate save function
			 
			Session s = FactoryProvider.getfactory().openSession();
			 Transaction tx = s.beginTransaction();
			s.save(note);
			 tx.commit();
			 out.println("<h1 style='text-align: center'>Note is added successfully</h1>");
			 out.println("<h1 style='text-align: center'><a href='All_Notes.jsp'>View all Notes</a></h1>");
			 s.close();
		 }catch(Exception e) {
			 
			 e.printStackTrace();
			 
		 }
		 
		 
		 
	}

}
