package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.postdao;
import com.dao.usersdao;
import com.entities.contacts;
import com.entities.post;
import com.entities.users;
import com.helper.ConnectionProvider;


@MultipartConfig
@WebServlet("/EditPostServlet")
public class EditPostServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
         PrintWriter out = response.getWriter();
       
       
         int postId= Integer.parseInt(request.getParameter("postId"));
         System.out.println(postId);
         String pType= request.getParameter("posttype");
         System.out.println(pType);
         String title=request.getParameter("title");
         System.out.println(title);
         String content =request.getParameter("content");
         System.out.println(content);
         String code= request.getParameter("code");
         System.out.println(code);
        
         
    
       

 post post = new post(postId, title, content, code, pType);
        
        
         postdao dao = new postdao(ConnectionProvider.getConnection());
        
        if( dao.UpdatePost(post))
       {
     	 
     	   out.println("done");
     	
        }
        else {
     	   out.println("error");

        }
         
			
         /*
		String check=request.getParameter("check");
		if(check==null) {
		out.println("You must agree terms and conditions");
		
		}
		else {
			
			
			String name=request.getParameter("user_name");
			System.out.println("Name is "+name);
			String email=request.getParameter("user_email");
			String password=request.getParameter("user_password");
			String mobile=request.getParameter("user_mobile");
			String gender=request.getParameter("user_gender");
			String about=request.getParameter("about");
			
			users newuser= new users(name,email,password,mobile, gender,about);
			
		
			
			usersdao dao =new usersdao(ConnectionProvider.getConnection());
			if(dao.saveuser(newuser)) {
				
				out.println("done");
			}
			else {
				
				out.println("Something Went Wrong On Server");
			}
			
		}
		*/
		
	}

}




















/*
package com.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.dao.postdao;
import com.dao.usersdao;
import com.entities.category;
import com.entities.messege;
import com.entities.post;
import com.entities.users;
import com.helper.ConnectionProvider;
import com.helper.Helper;

@WebServlet("/EditPostServlet")
@MultipartConfig
public class EditPostServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
     
        int postId= Integer.parseInt(request.getParameter("postId"));
       
      
        String title=request.getParameter("title");
        System.out.println(title);
        String content =request.getParameter("content");
        System.out.println(content);
        String code= request.getParameter("code");
        System.out.println(code);
       
        
   
      

post post = new post(postId,title, content, code);
       
       
        postdao dao = new postdao(ConnectionProvider.getConnection());
       
       if( dao.UpdatePost(post))
      {
    	 
    	   out.println("done");
    	
       }
       else {
    	   out.println("error");

       }

	}
}
*/
