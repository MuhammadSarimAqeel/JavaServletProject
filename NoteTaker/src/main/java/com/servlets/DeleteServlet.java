package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.todo;
import com.helper.FactoryProvider;


public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public DeleteServlet() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int noteid = Integer.parseInt(request.getParameter("todo_id").trim());
			Session s = FactoryProvider.getfactory().openSession();
			Transaction tx = s.beginTransaction();
			todo td = (todo)s.get(todo.class, noteid);
			
			s.delete(td);
			tx.commit();
			s.close();
	
			response.sendRedirect("All_Notes.jsp");
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
	}

	
	

}
