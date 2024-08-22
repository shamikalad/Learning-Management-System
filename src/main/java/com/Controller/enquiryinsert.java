package com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.enquiry;
import com.JdbcConnection.Connection_Jdbc;
import com.Model.Pro_Model;

/**
 * Servlet implementation class enquiryinsert
 */
@WebServlet("/enquiryinsert")
public class enquiryinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public enquiryinsert() {
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
		
		String studnm=request.getParameter("name"); 
					
		String email=request.getParameter("email");
		
		String mob=request.getParameter("mob");
		long mobile=Long.parseLong(mob);
		
		String coursenm=request.getParameter("coursenm");
		
		String date=request.getParameter("date");
		System.out.println(date);
		
		String msg=request.getParameter("msg");
		System.out.println(msg);
		
		try {
				enquiry e=new enquiry();
				e.setStud_name(studnm);
				e.setEmail(email);
				e.setCourse_nm(coursenm);
				e.setMob(mobile);
				e.setMsg(msg);
				e.setDate(date);
			
				Pro_Model pm=new Pro_Model(Connection_Jdbc.getConn());
				boolean b=pm.enquiryinsert(e);
				
				if(b==true)
				{
					response.sendRedirect("Contact.jsp");
				}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
