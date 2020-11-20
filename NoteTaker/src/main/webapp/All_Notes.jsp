<!doctype html>
<%@page import="com.entities.todo"%>
<%@page import="com.entities.todo"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="css/style.css" rel="stylesheet">
    <title>Show Notes Page</title>
  </head>
  <body>
   <div class="container">
   <%@ include file="navbar.jsp" %>
  
<h1 >All Notes:</h1>
<div class="rows">
<div class="col-12"></div>
<%
Session s = FactoryProvider.getfactory().openSession();

 Query q = s.createQuery("from todo");
List<todo> list= q.list();
for(todo td : list){
%>	

<div class="card mt-3" >
<div class="container text-center">
  <img class="card-img-top ml-4 mt-4" src="img/notes.png" alt="Card image cap" style="max-width:80px;">
  </div>
  <div class="card-body text-center px-4">
    <h5 class="card-title"><%= td.getTitle() %></h5>
    <p class="card-text"><%= td.getContent() %></p>
    <div class="container text-center">
    <a href="DeleteServlet?todo_id=<%= td.getId() %>" class="btn btn-danger">Delete</a>
    <a href="Edit.jsp?edit_id=<%= td.getId() %>" class="btn btn-primary">update</a>
    </div>
  </div>
</div>



<% 
}

s.close();
%>
</div>


 </div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>