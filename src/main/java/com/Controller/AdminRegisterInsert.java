package com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.admin_registration;
import com.JdbcConnection.Connection_Jdbc;
import com.Model.Pro_Model;
import com.mysql.cj.jdbc.JdbcConnection;

/**
 * Servlet implementation class AdminRegisterInsert
 */
@WebServlet("/AdminRegisterInsert")
public class AdminRegisterInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRegisterInsert() {
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
		
		String nm=request.getParameter("name");
		System.out.println(nm);
		
		String add=request.getParameter("address");
		System.out.println(add);
		
		String email=request.getParameter("email");
		System.out.println(email);
		
		String mob=request.getParameter("mobile");
		Long mobile=Long.parseLong(mob);
		System.out.println(mobile);
		
		String gen=request.getParameter("gen");
		System.out.println(gen);
		
		String usernm=request.getParameter("username");
		System.out.println(usernm);
		
		String pass=request.getParameter("password");
		System.out.println(pass);
		
		
		
		try {
		
			
			admin_registration r=new admin_registration();
			
			r.setName(nm);
			r.setAddress(add);
			r.setEmail(email);
			r.setMob(mobile);
			r.setGender(gen);
			r.setUsername(usernm);
			r.setPassword(pass);
			
			Pro_Model p=new Pro_Model(Connection_Jdbc.getConn());
			boolean b=p.adminregisterinsert(r);
			
			if(b==true)
			{
				System.out.println(r.getName());
				response.sendRedirect("dashboard.jsp");
			}
			
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
