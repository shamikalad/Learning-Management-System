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
 * Servlet implementation class deleteenquiry
 */
@WebServlet("/deleteenquiry")
public class deleteenquiry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteenquiry() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		enquiry en=new enquiry();
		String id=request.getParameter("id");
		int m=Integer.parseInt(id);
		System.out.println(m);
		
		try {
			Pro_Model pm=new Pro_Model(Connection_Jdbc.getConn());
			boolean b=pm.deleteenquiryrecord(m);
			if(b)
			{
				response.sendRedirect("EnquiryDataTable.jsp");
			}

		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
	}

}
