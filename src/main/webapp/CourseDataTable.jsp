<%@page import="com.Entity.courses"%>
<%@page import="com.Entity.enquiry"%>
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
                    <th>Course Name</th>
                    <th>Duration</th>
                    <th>Fees</th>
                    <th>Actions</th> <!-- New column for buttons -->
                  </tr>
                </thead>
                <tbody>
                <%
                	try{
                		Pro_Model pm=new Pro_Model(Connection_Jdbc.getConn());
                		List<courses> c=pm.fetchcoursedata();
                		
                		
                		for(courses co:c)
                		{
                	
                %>
                  <tr>
                    <td><%=co.getCourse_id() %></td>
                    <td><%=co.getCourse_name() %></td>
                    <td><%=co.getDuration() %></td>
                    <td><%=co.getFees() %></td>
                    
                    <td>
                    
                    	 <div class="btn-group">
                      <!-- Register button -->
                      <button type="button" class="btn btn-primary btn-sm"><a href="CourseUpdate.jsp?course_id=<%=co.getCourse_id()%>">Update</button>
                      <!-- Delete button -->
                      <button type="button" class="btn btn-danger btn-sm"><a href="deletecourse?course_id=<%=co.getCourse_id()%>">Delete</button>
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
