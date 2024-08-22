<%@page import="com.Entity.client"%>
<%@page import="com.Entity.project"%>
<%@page import="java.util.List"%>
<%@page import="com.JdbcConnection.Connection_Jdbc"%>
<%@page import="com.Model.Pro_Model"%>
<%@include file="leftbar.jsp"%>

<main id="main" class="main">

  <section class="section">
      <div class="row">
        <div class="col-lg-12">

          <div class="card">
            <div class="card-body">
              <h5 class="card-title">Course Datatable</h5>

              <!-- Table with stripped rows -->
              <table class="table datatable">
                <thead>
                  <tr>
                    <th><b>Id</b></th>
                    <th>Project Name</th>
                    <!--  <th>Client Name</th> -->
                    <th>Technology</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                    <th>Status</th>
                    <th>Actions</th> <!-- New column for buttons -->
                  </tr>
                </thead>
                <tbody>
                <%
                	try{
                		Pro_Model pm=new Pro_Model(Connection_Jdbc.getConn());
                		List<project> prj=pm.fetchprojectdata();
                		
                		for(project pro:prj)
                		{
                	
                %>
                  <tr>
                    <td><%=pro.getId() %></td>
                    <td><%=pro.getName() %></td>
                    <td><%=pro.getTech() %></td>
                    <td><%=pro.getSt_date() %></td>
                    <td><%=pro.getEnd_date() %></td>
                    <td><%=pro.getStatus() %></td>
                    <td><%=pro.getCl_id() %></td>
                    <td>
                    
                    	 <div class="btn-group">
                      <!-- Register button -->
                      <button type="button" class="btn btn-primary btn-sm"><a href="ProjectUpdate.jsp?proj_id=<%=pro.getId()%>">Update</a></button>
                      <!-- Delete button -->
                      <button type="button" class="btn btn-danger btn-sm"><a href="deleteproject?proj_id=<%=pro.getId()%>">Delete</a></button>
                    	</div>
                    </td>
                  </tr>
                 <%
                		}
                	}
                catch(Exception e)
                {
                	e.printStackTrace();
                }
                 %>
                </tbody>
              </table>
              <!-- End Table with stripped rows -->

            </div>
          </div>

        </div>
      </div>
    </section>

  </main><!-- End #main -->

<%@include file="Footer.jsp"%>
