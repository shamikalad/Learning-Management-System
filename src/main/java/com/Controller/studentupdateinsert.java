package com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.student_registration;
import com.JdbcConnection.Connection_Jdbc;
import com.Model.Pro_Model;

/**
 * Servlet implementation class studentupdateinsert
 */
@WebServlet("/studentupdateinsert")
public class studentupdateinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentupdateinsert() {
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
		
		
		String id=request.getParameter("studid");
		int stud_id=Integer.parseInt(id);
		
		String id2=request.getParameter("enqid");
		int enq_id=Integer.parseInt(id2);
		
		String nm=request.getParameter("name");
		
		String email=request.getParameter("email");
		
		String mob=request.getParameter("mobile");
		long mobile=Long.parseLong(mob);
		
		String coursenm=request.getParameter("coursenm");
		int course_id=Integer.parseInt(coursenm);
		
		
		
		String date=request.getParameter("date");
	
		
		try {
			student_registration sr=new student_registration();
			sr.setStud_id(stud_id);
			sr.setEnq_id(enq_id);
			sr.setName(nm);
			sr.setEmail(email);
			sr.setMob(mobile);
			sr.setCourse_id(course_id);
			sr.setDate(date);
			
			Pro_Model pm=new Pro_Model(Connection_Jdbc.getConn());
			boolean b=pm.studentupdateinsert(sr);
			
			if(b)
			{
				response.sendRedirect("StudentDataTable.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
}
	}

}
