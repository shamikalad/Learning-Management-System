package com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.courses;
import com.Entity.student_registration;
import com.JdbcConnection.Connection_Jdbc;
import com.Model.Pro_Model;

/**
 * Servlet implementation class studentinsert
 */
@WebServlet("/studentinsert")
public class studentinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentinsert() {
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
		
	
		String eqid=request.getParameter("enqid");
		int enqid=Integer.parseInt(eqid);
		
		String nm=request.getParameter("name");
		
		String add=request.getParameter("address");
		
		String mob=request.getParameter("mobile");
		long mobile=Long.parseLong(mob);
		
		String crsid=request.getParameter("coursenm");
		int courseid=Integer.parseInt(crsid);
		
		String email=request.getParameter("email");
		
		String fee=request.getParameter("fees");
		long fees=Long.parseLong(fee);
		
		String date=request.getParameter("date");
		
		
		
		try {
			student_registration sr=new student_registration();
			sr.setEnq_id(enqid);
			sr.setName(nm);
			sr.setEmail(email);
			sr.setMob(mobile);
			sr.setCourse_id(courseid);
			sr.setDate(date);
			Pro_Model pm=new Pro_Model(Connection_Jdbc.getConn());
			courses course=pm.feefetch(courseid);
			response.getWriter().write(Long.toString(course.getFees()));
			
			boolean b=pm.studentinsert(sr);
			
			if(b==true)
			{
				response.sendRedirect("EnquiryDataTable.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
