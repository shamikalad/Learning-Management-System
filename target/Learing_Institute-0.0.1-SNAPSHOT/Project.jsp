<%@page import="com.Entity.client"%>
<%@page import="java.util.List"%>
<%@page import="com.JdbcConnection.Connection_Jdbc"%>
<%@page import="com.Model.Pro_Model"%>
<%@ include file="leftbar.jsp" %>

<main id="main" class="main">

   <!--  <div class="pagetitle">
        <h1>Form Layouts</h1>
        <nav>
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                <li class="breadcrumb-item">Forms</li>
                <li class="breadcrumb-item active">Layouts</li>
            </ol>
        </nav>
    </div> --><!-- End Page Title -->

    <section class="section">
        <div class="container d-flex justify-content-center  min-vh-100">
            <div class="col-lg-6">
                <div class="card" >
                    <div class="card-body">
                        <h5 class="card-title" align="center">Project</h5>

                        <!-- Vertical Form -->
                        <form class="row g-3" action="projectinsert" method="post">
                            <div class="col-12">
                                <label for="name" class="form-label">Project Name</label>
                                <input type="text" class="form-control" id="proname" name="proname" required>
                            </div>
                            
                           
                            
                            <div class="col-12">
                                <label for="name" class="form-label">Technology</label>
                                <input type="text" class="form-control" id="tech" name="tech" required>
                            </div>
                                                
                             <div class="col-12">
                  		<label>Client Name</label>
                 
	                    <select class="form-select" aria-label="Default select example" name="selectclnm">
	                    <%
	                    try{
	                    	Pro_Model pm=new Pro_Model(Connection_Jdbc.getConn());
	                    	List<client> cl=pm.fetchclientnm();
	                   
	                    	for(client c:cl)
	                    	{
	                    
	                    %>
	                      <!-- <option selected>Open this select menu</option> -->
	                      <option value="<%=c.getId() %>"><%=c.getName() %></option>
	                      <%
	                      }
	                      }
	                      catch(Exception e)
	                      {
	                     
	                      }
	                    %>
	                    </select>
                  
                		</div>                     
                                                  
                            <div class="col-12">
	                  			<label for="inputDate" class="form-label">Start Date</label>
	                			<input type="date" class="form-control" name="startdt" id="startdt">
	                   		</div>
          				 
          				  <div class="col-12">
	                  			<label for="inputDate" class="form-label">End Date</label>
	                			<input type="date" class="form-control" name="enddt" id="enddt">
	                   		</div>
	                   		
	                   		 <div class="col-12">
                  		<label>Status</label>
                 
	                    <select class="form-select" aria-label="Default select example" name="status">
	                      <option selected>Open this select menu</option>
	                      <option value="On Going">On Going</option>
	                      <option value="On Process">On Process</option>
	                      <option value="Complete">Complete</option>
	                    </select>
                  
                		</div>
          		
                            <div class="text-center">
                                <button type="submit" class="btn btn-primary">Submit</button>
                                <button type="reset" class="btn btn-secondary">Reset</button>
                            </div>
                        </form><!-- Vertical Form -->

                    </div>
                </div>
            </div>
        </div>
    </section>

</main>

<%@ include file="Footer.jsp" %><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
