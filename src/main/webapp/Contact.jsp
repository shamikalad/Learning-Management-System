<%@page import="org.apache.naming.java.javaURLContextFactory"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Date"%>
<%@page import="com.Entity.courses"%>
<%@page import="java.util.List"%>
<%@page import="com.JdbcConnection.Connection_Jdbc"%>
<%@page import="com.Model.Pro_Model"%>

<%@include file="UserHeader.jsp"%>


 <div class="site-section ftco-subscribe-1 site-blocks-cover pb-4" style="background-image: url('images/bg_1.jpg')">
        <div class="container">
          <div class="row align-items-end">
            <div class="col-lg-7">
              <h2 class="mb-0">Contact</h2>
              <p>Lorem ipsum dolor sit amet consectetur adipisicing.</p>
            </div>
          </div>
        </div>
      </div> 
    

    <div class="custom-breadcrumns border-bottom">
      <div class="container">
        <a href="UserIndex.jsp">Home</a>
        <span class="mx-3 icon-keyboard_arrow_right"></span>
        <span class="current">Contact</span>
      </div>
    </div>

 <form  action="enquiryinsert" method="post">
    <div class="site-section">
        <div class="container">
            <div class="row">
                <div class="col-md-6 form-group">
                    <label for="fname">Name</label>
                    <input type="text" id="name" name="name" class="form-control form-control-lg">
                </div>
                
                 <div class="col-md-6 form-group">
                    <label for="eaddress">Email</label>
                    <input type="text" id="email" name="email" class="form-control form-control-lg" >
                </div>
               
            </div>
            <div class="row">
               
                <div class="col-md-6 form-group">
                    <label for="tel">Mobile</label>
                    <input type="text" id="mob" name="mob" class="form-control form-control-lg" maxlength="10">
                </div>
                
                 <div class="col-md-6 form-grooup">
                  		<label>Course Name</label>
                 
	                    <select class="form-control form-control-lg" aria-label="Default select example" name="coursenm">
	                     <% 
	                      try{
	                    	  Pro_Model pm=new Pro_Model(Connection_Jdbc.getConn());
	                    	  List<courses> cl=pm.fetchcourse();
	                    	  for(courses c:cl)
	                    	  {
	                      
	                      
	                    	%> 
	                      <option value="<%= c.getCourse_name()%>"><%=c.getCourse_name() %></option>
	                     <% 
	                     }
	                     }
	                     catch(Exception e)
	                     {
	                    	 e.printStackTrace();
	                     }
	                     %>
	                    </select>
                  
                		</div>
                		 	
                		 	
                		 	<%
                    			SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy");
                    			String today=formatter.format(new java.util.Date());
                    		%>
                    		<input type="hidden" id="date" name="date" class="form-control form-control-lg" value=<%=today %>>
                			
            </div>
            
            
          				 <div class="row">
          				
                	</div>
                		
                 
               
            
            <div class="row">
                <div class="col-md-12 form-group">
                    <label for="message">Message</label>
                    <textarea name="" id="msg" name="msg" cols="30" rows="10" class="form-control"></textarea>
                </div>
            </div>

            <div class="row">
                <div class="col-12">
                    <input type="submit" value="Send Message" class="btn btn-primary btn-lg px-5">
                </div>
            </div>
        </div>
    </div>
   </form>

    <div class="section-bg style-1" style="background-image: url('images/hero_1.jpg');">
        <div class="container">
          <div class="row">
            <div class="col-lg-4 col-md-6 mb-5 mb-lg-0">
              <span class="icon flaticon-mortarboard"></span>
              <h3>Our Philosphy</h3>
              <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Reiciendis recusandae, iure repellat quis delectus ea? Dolore, amet reprehenderit.</p>
            </div>
            <div class="col-lg-4 col-md-6 mb-5 mb-lg-0">
              <span class="icon flaticon-school-material"></span>
              <h3>Academics Principle</h3>
              <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Reiciendis recusandae, iure repellat quis delectus ea?
                Dolore, amet reprehenderit.</p>
            </div>
            <div class="col-lg-4 col-md-6 mb-5 mb-lg-0">
              <span class="icon flaticon-library"></span>
              <h3>Key of Success</h3>
              <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Reiciendis recusandae, iure repellat quis delectus ea?
                Dolore, amet reprehenderit.</p>
            </div>
          </div>
        </div>
      </div>
   

<%@include file="UserFooter.jsp"%>