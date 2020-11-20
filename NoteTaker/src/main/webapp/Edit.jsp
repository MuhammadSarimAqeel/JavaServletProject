<!doctype html>
<%@page import="com.entities.todo"%>
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
    <title>Edit Page</title>
  </head>
  <body>
   <div class="container">
   <%@ include file="navbar.jsp" %>
   <h1>Edit Your Note</h1>
 
<%
int editid= Integer.parseInt(request.getParameter("edit_id").trim());
Session s = FactoryProvider.getfactory().openSession();

todo td = (todo)s.get(todo.class, editid);
%>


<!-- this is add notes form -->
<form action="UpdateServlet" method="post" id="addnotesform">
<input value="<%=td.getId() %>" name="noteid" type="hidden">
  <div class="form-group">
    <label for="title">Note Title</label>
    <input type="text" name="title" required value="<%= td.getTitle() %>" class="form-control" id="title" aria-describedby="emailHelp" placeholder="Enter note title here">

  </div>
  <div class="form-group">
    <label for="content">Note Content</label>
  <textarea id="content" name="content" required  placeholder="Enter Your content here" class= "form-control" style="height:300px;"><%= td.getContent() %></textarea>
  </div>
  <div class="container text-center">
  <button type="submit" class="btn btn-primary btn-lg">Save Your Note</button>
  </div>
</form>




  </div>


    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>