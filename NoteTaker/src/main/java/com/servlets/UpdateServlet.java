package com.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.todo;
import com.helper.FactoryProvider;


public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		int id = Integer.parseInt(request.getParameter("noteid").trim());
		 String title= request.getParameter("title");
		 String content = request.getParameter("content");
		 Session s = FactoryProvider.getfactory().openSession();
		 Transaction tx = s.beginTransaction();
		todo td = (todo)s.get(todo.class, id);
		td.setTitle(title);
		td.setContent(content);
		td.setDate(new Date());
		
		tx.commit();
		response.sendRedirect("All_Notes.jsp");
		s.close();
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	
	
	
	}

}
