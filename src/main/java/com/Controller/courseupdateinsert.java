package com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.courses;
import com.JdbcConnection.Connection_Jdbc;
import com.Model.Pro_Model;

/**
 * Servlet implementation class courseupdateinsert
 */
@WebServlet("/courseupdateinsert")
public class courseupdateinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public courseupdateinsert() {
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
		int course_id=Integer.parseInt(id);
		System.out.println(course_id);
		
		String nm=request.getParameter("coursenm");
		System.out.println(nm);
		
		String duration=request.getParameter("duration");
		System.out.println(duration);
		
		String fees=request.getParameter("fees");
		int fee=Integer.parseInt(fees);
		System.out.println(fee);
		
		try {
			courses c=new courses();
			c.setCourse_id(course_id);
			c.setCourse_name(nm);
			c.setDuration(duration);
			c.setFees(fee);
			
			Pro_Model pm=new Pro_Model(Connection_Jdbc.getConn());
			boolean b=pm.courseupdateinsert(c);
			if(b)
			{
				System.out.println(b);
				response.sendRedirect("CourseDataTable.jsp");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
