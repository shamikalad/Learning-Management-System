<%@page import="com.Entity.client"%>
<%@page import="com.JdbcConnection.Connection_Jdbc"%>
<%@page import="com.Model.Pro_Model"%>
<%@ include file="leftbar.jsp" %>

<main id="main" class="main">

  

    <section class="section">
        <div class="container d-flex justify-content-center  min-vh-100">
            <div class="col-lg-6">
                <div class="card" >
                    <div class="card-body">
                        <h5 class="card-title" align="center">Client Registration</h5>
						<%
							String id=request.getParameter("client_id");
							int a=Integer.parseInt(id);
							Pro_Model pm=new Pro_Model(Connection_Jdbc.getConn());
							client c=pm.clientrecordfetch(a);
						%>


                        <!-- Vertical Form -->
                        <form class="row g-3" action="clientupdateinsert" method="post">
                        <input type="hidden" name="id" value="<%=c.getId() %>">
                            <div class="col-12">
                                <label for="name" class="form-label">Name</label>
                                <input type="text" class="form-control" id="name" name="name" value="<%=c.getName() %>" required>
                            </div>
                            <div class="col-12">
                                <label for="address" class="form-label">Address</label>
                                <input type="text" class="form-control" id="address" name="address" value="<%=c.getAddress() %>" required>
                            </div>
                            <div class="col-12">
                                <label for="email" class="form-label">Email</label>
                                <input type="email" class="form-control" id="email" name="email" value="<%=c.getEmail() %>"  required>
                            </div>
                            <div class="col-12">
                                <label for="mobile" class="form-label">Mobile</label>
                                <input type="text" class="form-control" id="mobile" name="mobile" maxlength="10" value="<%=c.getMob()%>" required>
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
