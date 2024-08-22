<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.Entity.courses"%>
<%@page import="java.util.List"%>
<%@page import="com.Entity.enquiry"%>
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
                        <h5 class="card-title" align="center">Student Registration</h5>

                        <!-- Vertical Form -->
                        
                        <%
                        	 String id=request.getParameter("enq_id");
                        	
                        	int m=Integer.parseInt(id); 
                        	Pro_Model pm=new Pro_Model(Connection_Jdbc.getConn());
                        	enquiry eq=pm.fetchstudinfo(m);
                        %>
                        
                        <form class="row g-3" action="studentinsert" method="post">
                            
                            <input type="hidden" name="enqid" value=<%=eq.getId() %>>
                            <div class="col-12">
                                <label for="name" class="form-label">Name</label>
                                <input type="text" class="form-control" id="name" name="name" value="<%=eq.getStud_name()%>"required>
                            </div>
                            <div class="col-12">
                                <label for="address" class="form-label">Address</label>
                                <input type="text" class="form-control" id="address" name="address" required>
                            </div>
                            <div class="col-12">
                                <label for="email" class="form-label">Email</label>
                                <input type="email" class="form-control" id="email" name="email" value="<%=eq.getEmail()%>" required>
                            </div>
                            <div class="col-12">
                                <label for="mobile" class="form-label">Mobile</label>
                                <input type="text" class="form-control" id="mobile" name="mobile" value=<%=eq.getMob() %> required>
                            </div>
                            
                     
          				 
          				 
          				 <div class="col-12">
                  		<label>Course Name</label>
                 
                 		
	                    <select class="form-select" aria-label="Default select example" name="coursenm" id="floatingSelect">
	                      <% 
	                      try{
	                    	  Pro_Model pm2=new Pro_Model(Connection_Jdbc.getConn());
	                    	  List<courses> cl=pm2.fetchcourse();
	                    	  for(courses c:cl)
	                    	  {
	                      %>
	                      <option value="<%=c.getCourse_id()%>"><%=c.getCourse_name() %></option>
	                     <% 
	                    	  }
	                      }catch(Exception e)
	                      {
	                    	  e.printStackTrace();
	                      }
	                     %>
	                    </select>
                  
                  
                  
   <script src="https://code.jquery.com/jquery-2.2.4.js" integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI=" crossorigin="anonymous"></script>
<script>
// JQuery code for getting price which is alraedy 


$(document).ready(function(){
	$("#floatingSelect").change(function (){
		var id=$(this).val();
		//alert(id);
		
		$.get('courseidfetch',{"id":id},function(resp){
			var pp=resp;
			//alert(pp);
			document.getElementById("fees").value=pp;
		});
	});
});


</script>
                  
                		</div>
                            <div class="col-12">
                           <label class="form-label">Fees</label>
                           <input type="text" class="form-control" name="fees" id="fees">
                           </div>
                           
                        
                        	<div class="col-12">
                        	<%
                        		SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy");
                    			String today=formatter.format(new java.util.Date());
                        	%>
                    		<input type="hidden" id="date" name="date" class="form-control form-control-lg" value=<%=today %>>
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

<%@ include file="Footer.jsp" %>