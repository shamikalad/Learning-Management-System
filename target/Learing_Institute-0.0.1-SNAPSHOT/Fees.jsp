<%@page import="com.Entity.courses"%>
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
                        <h5 class="card-title" align="center">Fees</h5>

                        <!-- Vertical Form -->
                        <form class="row g-3">
                            <div class="col-12">
                                <label for="name" class="form-label">Name</label>
                                <input type="text" class="form-control" id="name" name="name" required>
                            </div>
                            
                           <div class="col-12">
                  		<label>Course Name</label>
                 
                 		
	                    <select class="form-select" aria-label="Default select example" name="coursenm" id="floatingSelect">
	                      <% 
	                      try{
	                    	  Pro_Model pm=new Pro_Model(Connection_Jdbc.getConn());
	                    	  List<courses>cl=pm.fetchcourse();
	                    	  
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
        </div>
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
			document.getElementById("totalfee").value=pp;
		});
	});
});


</script>
                            <div class="col-12">
                             <label for="name" class="form-label">Payment Method</label>
                             <select class="form-select" aria-label="Default select example" name="selectpaymethod" id="selectpaymethod">
                             	<option value="Cash">Cash</option>
                             	<option value="Cheque">Cheque</option>
                             </select>	
                            </div>
                            
                            
                           
                            
                            
                            <div class="col-12">
                                <label for="name" class="form-label">Course Fees</label>
                                <input type="text" class="form-control" id="totalfee" name="totalfee" required>
                            </div>
                            
                            <div class="col-12">
                                <label for="name" class="form-label">Amount Received</label>
                                <input type="text" class="form-control" id="amtrec" name="amtrec" required>
                            </div>
                            
                            
                            <div class="col-12">
                                <label for="name" class="form-label">Total Paid Amount</label>
                                <input type="text" class="form-control" id="paidfee" name="paidfee" onkeyup="total()">
                            </div>
                            
                            <script type="text/javascript">
  function total()
  {
	  var x=document.getElementById("totalfee").value;
      var y=document.getElementById("paidfee").value;
      var total=x-y;
      
   
     document.getElementById("remfee").value=total;
      
  }
  
  
  </script> 
                            <div class="col-12">
                                <label for="name" class="form-label">Balance Due</label>
                                <input type="text" class="form-control" id="remfee" name="remfee" required>
                            </div>
                            
                            
                            
                                                   
                         	 <div class="col-12">
	                  			<label for="inputDate" class="form-label">Date</label>
	                			<input type="date" class="form-control" name="date">
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
