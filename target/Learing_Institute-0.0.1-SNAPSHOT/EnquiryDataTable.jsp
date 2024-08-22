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
              <h5 class="card-title">Enquiry Datatable</h5>

              <!-- Table with stripped rows -->
              <table class="table datatable">
                <thead>
                  <tr>
                    <th><b>Id</b></th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Mobile</th>
                    <th>Course Name</th>
                    <th>Date</th>
                    <th>Actions</th> <!-- New column for buttons -->
                  </tr>
                </thead>
                <tbody>
                <%
                	try{
                		Pro_Model pm=new Pro_Model(Connection_Jdbc.getConn());
                		List<enquiry> el=pm.fetchenquirydata();
                		
                		for(enquiry e:el)
                		{
                	
                %>
                  <tr>
                    <td><%=e.getId() %></td>
                    <td><%=e.getStud_name() %></td>
                    <td><%=e.getEmail() %></td>
                    <td><%=e.getMob() %></td>
                    <td><%=e.getCourse_nm() %></td>
                   
                    <td><%=e.getDate() %></td>
                    <td>
                    
                    	 <div class="btn-group">
                      <!-- Register button -->
                      <button type="button" class="btn btn-primary btn-sm"><a href="StudentRegistration.jsp?enq_id=<%=e.getId()%>">Register</button>
                      <!-- Delete button -->
                      <button type="button" class="btn btn-danger btn-sm"><a href="deleteenquiry?id=<%=e.getId()%>">Delete</button>
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
