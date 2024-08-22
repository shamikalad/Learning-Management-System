<%@page import="com.Entity.client"%>
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
              <h5 class="card-title">Client Datatable</h5>

              <!-- Table with stripped rows -->
              <table class="table datatable">
                <thead>
                  <tr>
                    <th><b>Id</b></th>
                    <th>Name</th>
                     <th>Address</th>
                    <th>Email</th>
                    <th>Mobile</th>
                    <th>Actions</th> <!-- New column for buttons -->
                  </tr>
                </thead>
                <tbody>
                <%
                	try
                	{
                		Pro_Model pm=new Pro_Model(Connection_Jdbc.getConn());
                		List<client>cl=pm.fetchclientdata();
                		for(client c:cl)
                		{
                		
                %>
               		<tr>
                    <td><%=c.getId() %></td>
                    <td><%=c.getName() %></td>
                    <td><%=c.getAddress() %></td>
                    <td><%=c.getEmail() %></td>
                    <td><%=c.getMob() %></td>
                    <td>
                    
                    	 <div class="btn-group">
                      <!-- Register button -->
                      <button type="button" class="btn btn-primary btn-sm"><a href="ClientUpdate.jsp?client_id=<%=c.getId()%>">Update</button>
                      <!-- Delete button -->
                      <button type="button" class="btn btn-danger btn-sm"><a href="deleteclient?client_id=<%=c.getId()%>">Delete</button>
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