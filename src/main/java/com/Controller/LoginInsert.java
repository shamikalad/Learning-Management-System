package com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.JdbcConnection.Connection_Jdbc;
import com.Model.Pro_Model;

/**
 * Servlet implementation class LoginInsert
 */
@WebServlet("/LoginInsert")
public class LoginInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginInsert() {
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
		
		
		String nm=request.getParameter("username");
		
		
		String pass=request.getParameter("password");
		System.out.println(nm);
		System.out.println(pass);
		
		
		
		
		
		
		try {
		
		Pro_Model p=new Pro_Model(Connection_Jdbc.getConn());
		String b= p.loginInsert(nm, pass);
		System.out.println(b);
		if(b!=null) {
			
			HttpSession ht=request.getSession();
			ht.setAttribute("User", nm);
			
			
			System.out.println("Success");
			
			response.sendRedirect("dashboard.jsp");
			
		}
		else
		{
			System.out.println("Unsuccess");
			response.sendRedirect("AdminLogin.jsp");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	

	}

