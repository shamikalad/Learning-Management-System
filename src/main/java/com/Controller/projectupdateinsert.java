package com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.project;
import com.JdbcConnection.Connection_Jdbc;
import com.Model.Pro_Model;

/**
 * Servlet implementation class projectupdateinsert
 */
@WebServlet("/projectupdateinsert")
public class projectupdateinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public projectupdateinsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String id=request.getParameter("id");
		int proj_id=Integer.parseInt(id);
		
		String name=request.getParameter("proname");
		
		String tech=request.getParameter("tech");
		
		String st_dt=request.getParameter("startdt");
		
		String end_dt=request.getParameter("enddt");
		
		String clid=request.getParameter("selectclnm");
		int cl_id=Integer.parseInt(clid);
		
		String status=request.getParameter("status");
		
		try {
			project prj=new project();
			prj.setId(proj_id);
			prj.setName(name);
			prj.setTech(tech);
			prj.setSt_date(st_dt);
			prj.setEnd_date(end_dt);
			prj.setStatus(status);
			prj.setCl_id(cl_id);
			Pro_Model pm=new Pro_Model(Connection_Jdbc.getConn());
			boolean b=pm.projectupdateinsert(prj);
			if(b)
			{
				
				response.sendRedirect("ProjectDataTable.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
