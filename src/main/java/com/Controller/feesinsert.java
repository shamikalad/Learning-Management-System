package com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.fees;

/**
 * Servlet implementation class feesinsert
 */
@WebServlet("/feesinsert")
public class feesinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public feesinsert() {
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
		
		
		String name=request.getParameter("name");
		
		String coursenm=request.getParameter("coursenm");
		long courseid=Long.parseLong(coursenm);
		
		String method=request.getParameter("method");
		
		String totalfee=request.getParameter("totalfee");
		long totfee=Long.parseLong(totalfee);
		
		String amtrec=request.getParameter("amtrec");
		long amtreceievd=Long.parseLong(amtrec);
		
		String paidfee=request.getParameter("paidfee");
		long paidfees=Long.parseLong(paidfee);
		
		String remfee=request.getParameter("remfee");
		long remnfee=Long.parseLong(remfee);
		
		String date=request.getParameter("date");
		
		try {
			
			fees f=new fees();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
