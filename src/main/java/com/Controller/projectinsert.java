package com.Controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.project;
import com.JdbcConnection.Connection_Jdbc;
import com.Model.Pro_Model;

/**
 * Servlet implementation class projectinsert
 */
@WebServlet("/projectinsert")
public class projectinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public projectinsert() {
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
		
		String pronm=request.getParameter("proname");
		
		String tech=request.getParameter("tech");
		
		String clid=request.getParameter("selectclnm");
		int clientid=Integer.parseInt(clid);
		
		String stdt=request.getParameter("startdt");
		
		
		String eddt=request.getParameter("enddt");
		
		
		String status=request.getParameter("status");
		
		
		try {
			
			project pj=new project();
			pj.setName(pronm);
			pj.setTech(tech);
			pj.setStatus(status);
			pj.setCl_id(clientid);
			pj.setSt_date(stdt);
			pj.setEnd_date(eddt);
			
			Pro_Model pm=new Pro_Model(Connection_Jdbc.getConn());
			boolean b=pm.projectinsert(pj);
			
			if(b==true)
			{
				response.sendRedirect("Project.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
