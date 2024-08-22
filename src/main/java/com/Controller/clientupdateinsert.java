package com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.client;
import com.JdbcConnection.Connection_Jdbc;
import com.Model.Pro_Model;

/**
 * Servlet implementation class clientupdateinsert
 */
@WebServlet("/clientupdateinsert")
public class clientupdateinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public clientupdateinsert() {
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
		int clid=Integer.parseInt(id);

		String name=request.getParameter("name");
		System.out.println(name);
		
		String add=request.getParameter("address");
		System.out.println(add);
		
		String email=request.getParameter("email");
		System.out.println(email);
		
		String mob=request.getParameter("mobile");
		long mobile=Long.parseLong(mob);
		System.out.println(mobile);
		
		
		try {
			
			client cl=new client();
			cl.setId(clid);
			cl.setName(name);
			cl.setAddress(add);
			cl.setEmail(email);
			cl.setMob(mobile);
			
			Pro_Model p=new Pro_Model(Connection_Jdbc.getConn());
			boolean b=p.clientupdateinsert(cl);
			
			if(b==true)
			{
				response.sendRedirect("ClientDataTable.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();		
}

		
	}

}
