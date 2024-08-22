<%@page import="com.Entity.project"%>
<%@page import="com.Entity.client"%>
<%@page import="java.util.List"%>
<%@page import="com.JdbcConnection.Connection_Jdbc"%>
<%@page import="com.Model.Pro_Model"%>
<%@ include file="leftbar.jsp" %>

<main id="main" class="main">
    <%-- 
    <div class="pagetitle">
        <h1>Form Layouts</h1>
        <nav>
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                <li class="breadcrumb-item">Forms</li>
                <li class="breadcrumb-item active">Layouts</li>
            </ol>
        </nav>
    </div> --%>
    
    <%
    	
        String id = request.getParameter("proj_id");
        int proj_id = Integer.parseInt(id);
        out.print(id);
        Pro_Model pm2 = new Pro_Model(Connection_Jdbc.getConn());
        project prj = pm2.projectrecordfetch(proj_id);
    %>

    <section class="section">
        <div class="container d-flex justify-content-center min-vh-100">
            <div class="col-lg-6">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title" align="center">Project</h5>

                        <!-- Vertical Form -->
                        <form class="row g-3" action="projectupdateinsert" method="post">
                            <div class="col-12">
                                <input type="hidden" name="id" id="id" value="<%= prj.getId() %>">
                                <label for="proname" class="form-label">Project Name</label>
                                <input type="text" class="form-control" id="proname" name="proname" value="<%= prj.getName() %>" required>
                            </div>

                            <div class="col-12">
                                <label for="tech" class="form-label">Technology</label>
                                <input type="text" class="form-control" id="tech" name="tech" value="<%= prj.getTech() %>" required>
                            </div>
                            
                            <div class="col-12">
                                <label>Client Name</label>
                                <select class="form-select" aria-label="Default select example" name="selectclnm">
                                    <%
                                    try {
                                        Pro_Model pm = new Pro_Model(Connection_Jdbc.getConn());
                                        List<client> cl = pm.fetchclientnm();
                                        for (client c : cl) {
                                    %>
                                    <option value="<%= c.getId() %>" <%= prj.getCl_id() == c.getId() ? "selected" : "" %>><%= c.getName() %></option>
                                    <%
                                        }
                                    } catch (Exception e) {
                                       e.printStackTrace();
                                    }
                                    %>
                                </select>
                            </div>

                            <div class="col-12">
                                <label for="startdt" class="form-label">Start Date</label>
                                <input type="date" class="form-control" name="startdt" id="startdt" value="<%= prj.getSt_date() %>">
                            </div>
                            
                            <div class="col-12">
                                <label for="enddt" class="form-label">End Date</label>
                                <input type="date" class="form-control" name="enddt" id="enddt" value="<%= prj.getEnd_date() %>">
                            </div>
                            
                            <div class="col-12">
                                <label>Status</label>
                                <select class="form-select" aria-label="Default select example" name="status">
                                    <option value="On Going" <%= "On Going".equals(prj.getStatus()) ? "selected" : "" %>>On Going</option>
                                    <option value="On Process" <%= "On Process".equals(prj.getStatus()) ? "selected" : "" %>>On Process</option>
                                    <option value="Complete" <%= "Complete".equals(prj.getStatus()) ? "selected" : "" %>>Complete</option>
                                </select>
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