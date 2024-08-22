<%@page import="com.Entity.courses"%>
<%@page import="com.JdbcConnection.Connection_Jdbc"%>
<%@page import="java.sql.Connection"%>
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
                        <h5 class="card-title" align="center">Course</h5>
						<%
							String id=request.getParameter("course_id");
							int course_id=Integer.parseInt(id);
							Pro_Model pm=new Pro_Model(Connection_Jdbc.getConn());
							courses co=pm.courserecordfetch(course_id);
						%>

                        <!-- Vertical Form -->
                        <form class="row g-3" action="courseupdateinsert" method="post">
                             <input type="hidden" name="id" value="<%=co.getCourse_id()%>">                            
                            <div class="col-12">
                                <label for="name" class="form-label">Course Name</label>
                                <input type="text" class="form-control" id="coursenm" name="coursenm" required>
                            </div>
                            
                            <div class="col-12">
                                <label for="name" class="form-label">Duration</label>
                                <input type="text" class="form-control" id="duration" name="duration" required>
                            </div>
                            
                      		<div class="col-12">
                                <label for="name" class="form-label">Fees</label>
                                <input type="text" class="form-control" id="fees" name="fees" required>
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
