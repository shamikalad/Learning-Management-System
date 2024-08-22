<%@page import="com.Entity.student_registration"%>
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
                    <th>Student Name</th>
                    <th>Email</th>
                    <th>Mobile</th>
                    <th>Course</th>
                    <th>Date</th>
                    <th>Actions</th> <!-- New column for buttons -->
                  </tr>
                </thead>
                <tbody>
                <%
                	try{
                		Pro_Model pm=new Pro_Model(Connection_Jdbc.getConn());
						List<student_registration> sr=pm.fetchstudentdata();            		
                		
                		for(student_registration s:sr)
                		{
                		String coursenm=pm.fetchcoursenm(s.getCourse_id());
                %>
                  <tr>
                    <td><%=s.getStud_id() %></td>
                    <td><%=s.getName() %></td>
                    <td><%=s.getEmail() %></td>
                    <td><%=s.getMob() %></td>
                    <td><%=coursenm %></td>
                    <td><%=s.getDate() %></td>
                    <td>
                    
                    	 <div class="btn-group">
                      <!-- Register button -->
                      <button type="button" class="btn btn-primary btn-sm"><a href="StudentUpdate.jsp?stud_id=<%=s.getStud_id()%>">Update</a></button>
                      <!-- Delete button -->
                      <button type="button" class="btn btn-danger btn-sm"><a href="deletestudent?stud_id=<%=s.getStud_id()%>">Delete</a></button>
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
