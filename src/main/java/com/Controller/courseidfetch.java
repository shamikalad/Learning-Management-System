package com.Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.courses;
import com.JdbcConnection.Connection_Jdbc;
import com.Model.Pro_Model;

/**
 * Servlet implementation class courseidfetch
 */
@WebServlet("/courseidfetch")
public class courseidfetch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public courseidfetch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String crsid=req.getParameter("id");
		int courseid=Integer.parseInt(crsid);
		System.out.println(courseid);
		
		try {
			Pro_Model pm=new Pro_Model(Connection_Jdbc.getConn());
			
			courses cs=pm.feefetch(courseid);
			resp.getWriter().print(cs.getFees());
		} catch (Exception e) {
			e.printStackTrace();	
			}
		
		
	}

}