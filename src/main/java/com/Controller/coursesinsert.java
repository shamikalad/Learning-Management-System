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
 * Servlet implementation class coursesinsert
 */
@WebServlet("/coursesinsert")
public class coursesinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public coursesinsert() {
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
		
		String course_name=request.getParameter("coursenm");
		System.out.println(course_name);
		
		String duration=request.getParameter("duration");
		System.out.println(duration);
		
		String fee=request.getParameter("fees");
		long fees=Long.parseLong(fee);
		System.out.println(fee);
		
		try {
			
			courses c=new courses();
			c.setCourse_name(course_name);
			c.setDuration(duration);
			c.setFees(fees);
				
			
			Pro_Model p=new Pro_Model(Connection_Jdbc.getConn());
			boolean b=p.coursesinsert(c);
			
			if(b==true) 
			{
					response.sendRedirect("Courses.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
