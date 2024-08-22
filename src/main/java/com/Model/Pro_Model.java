package com.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import com.Entity.admin_registration;
import com.Entity.client;
import com.Entity.courses;
import com.Entity.enquiry;
import com.Entity.project;
import com.Entity.student_registration;

public class Pro_Model {
	
	Connection con;

	public Pro_Model( Connection con) {

	super();
	this.con=con;
	
	}

	
					//Admin Login//
	public String loginInsert(String nm, String pass) throws SQLException {
		admin_registration r;
		String s=null;
		String sql="select * from admin_registration where username=? and password=?";
		PreparedStatement ps1=con.prepareStatement(sql);
		ps1.setString(1, nm);
		ps1.setString(2, pass);
		
		
		
		ResultSet rs=ps1.executeQuery();
		while(rs.next()) {
			r=new admin_registration();
			r.setUsername(rs.getString("username"));
			r.setPassword(rs.getString("password"));
			
			
			System.out.println(r.getUsername());
			System.out.println(r.getPassword());
			System.out.println("nm"+nm);
			System.out.println("pass"+pass);
			
			if(nm.equals(r.getUsername())& pass.equals(r.getPassword())) {
				s=r.getUsername();
				
				
				return s;
				}
			}
	con.close();
		return null;
		
	}

			//Admin Registration//
	public boolean adminregisterinsert(admin_registration r) throws SQLException {
		
		boolean b=false;
		
		String sql="insert into admin_registration(name,address,gender,mobile,email,username,password)values(?,?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		System.out.println(ps);
		
		ps.setString(1, r.getName());
		ps.setString(2, r.getAddress());
		ps.setString(3, r.getGender());
		ps.setLong(4, r.getMob());
		ps.setString(5, r.getEmail());
		ps.setString(6, r.getUsername());
		ps.setString(7, r.getPassword());
		
		System.out.println(r.getName());
		int i=ps.executeUpdate();
		
		if(i==1)
		{
			b=true;
		}
		System.out.println("Inserted Successfully");
		
		return b;
	}
	
	
		//Courses Insert//
	public boolean coursesinsert(courses c) throws SQLException {
		boolean b=false;
		
		String sql="insert into courses(course_name,duration,fees)values(?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setString(1, c.getCourse_name());
		ps.setString(2, c.getDuration());
		ps.setLong(3, c.getFees());
		
		int i=ps.executeUpdate();
		
		if(i==1)
		{
			b=true;
		}
		System.out.println("Inserted Successfully");
		
		return b;
	}

		//client insert//
	public boolean clientinsert(client cl) throws SQLException {
		boolean b=false;
		String sql="insert into client(name,address,email,mob)values(?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setString(1, cl.getName());
		ps.setString(2, cl.getAddress());
		ps.setString(3, cl.getEmail());
		ps.setLong(4, cl.getMob());
		
		int i=ps.executeUpdate();
		if(i==1)
		{
			b=true;
		}
		System.out.println("Inserted Successfully");
		return b;
	}
	
		//fetch client name//
	public List<client> fetchclientnm() throws SQLException {
		
		List<client> l=new ArrayList<client>();
		
		client cl=null;
		
		String sql="select * from client";
		PreparedStatement ps=con.prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			cl=new client();
			cl.setId(rs.getInt(1));
			cl.setName(rs.getString(2));
			cl.setAddress(rs.getString(3));
			cl.setEmail(rs.getString(4));
			cl.setMob(rs.getLong(5));
			
			l.add(cl);
		}
		return l;
		
	}

		//project insert//
	public boolean projectinsert(project pj) throws SQLException {
		boolean b=false;
		
		
		String sql="insert into project(proj_name,technology,start_dt,end_dt,status,client_id)values(?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setString(1, pj.getName());
		ps.setString(2, pj.getTech());
		ps.setString(3, pj.getSt_date());
		ps.setString(4, pj.getEnd_date());
		ps.setString(5, pj.getStatus());
		ps.setInt(6, pj.getCl_id());
		
		int i=ps.executeUpdate();
		if(i==1)
		{
			b=true;
		}
		return b;
	}
	
	
	
		//fetch course names//
 public List<courses> fetchcourse() throws SQLException {
	 
	 List<courses> l=new ArrayList<courses>();
	 courses c=null;
	 
	 String sql="select * from courses";
	 PreparedStatement ps=con.prepareStatement(sql);
	 
	 ResultSet rs=ps.executeQuery();
	 
	 while(rs.next())
	 {
		 c=new courses();
		 c.setCourse_id(rs.getInt(1));
		 c.setCourse_name(rs.getString(2));
		 c.setDuration(rs.getString(3));
		 c.setFees(rs.getLong(4));
		 
		 l.add(c);
	 }
	 
	return l;
		}

 
 	//Add enuiry//
public boolean enquiryinsert(enquiry e) throws SQLException {
	boolean b=false;
	
	String sql="insert into enquiry(stud_name,email,mob,course_name,message,date)values(?,?,?,?,?,?)";
 	PreparedStatement ps=con.prepareStatement(sql);
 	
 	ps.setString(1, e.getStud_name());
 	ps.setString(2, e.getEmail());
 	ps.setLong(3, e.getMob());
 	ps.setString(4, e.getCourse_nm());
 	ps.setString(5, e.getMsg());
 	ps.setString(6, e.getDate());
 	
 	System.out.println(e.getMsg());
 	
 	int i=ps.executeUpdate();
	if(i==1)
	{
		b=true;
	}
	return b;
 
}


	//fetch Enquiry Data into Table//
public List<enquiry> fetchenquirydata() throws SQLException {
	
	List<enquiry> el=new ArrayList<enquiry>();
	enquiry e=null;
	
	String sql="select * from enquiry";
	PreparedStatement ps=con.prepareStatement(sql);
	ResultSet rs=ps.executeQuery();
	
	while(rs.next())
	{
		e=new enquiry();
		e.setId(rs.getInt(1));
		e.setStud_name(rs.getString(2));
		e.setEmail(rs.getString(3));
		e.setMob(rs.getLong(4));
		e.setCourse_nm(rs.getString(5));
		e.setMsg(rs.getString(6));
		e.setDate(rs.getString(7));
		
		el.add(e);
		
	}
	
	
	return el;
	
}

   
	//Delete Enquiry record from Data-Table//
public boolean deleteenquiryrecord(int m) throws SQLException {
	
	boolean b=false;
	
	String sql="delete from enquiry where enq_id=?";
	PreparedStatement ps=con.prepareStatement(sql);
	ps.setInt(1, m);
	System.out.println(ps);
	int i=ps.executeUpdate();
	if(i==1)
	{
		b=true;
	}
	
	
	return b;
}


//Fetch student data from enquiry table for registration//

public enquiry fetchstudinfo(int m) throws SQLException
{
	enquiry eq=null;
	String sql="select * from enquiry where enq_id=?";
	PreparedStatement ps=con.prepareStatement(sql);
	ps.setInt(1, m);
	ResultSet rs=ps.executeQuery();
	while(rs.next())
	{
		eq=new enquiry();
		eq.setId(rs.getInt(1));
		eq.setStud_name(rs.getString(2));
		eq.setEmail(rs.getString(3));
		eq.setMob(rs.getLong(4));
		eq.setCourse_nm(rs.getString(5));
		eq.setMsg(rs.getString(6));
		eq.setDate(rs.getString(7));
	}
	
	
	return eq;
	
}

		//Insert Student Data//
public boolean studentinsert(student_registration sr) throws SQLException {
	boolean b= false;
	
	String sql="insert into student_registration(enq_id,name,email,mob,course_id,date)values(?,?,?,?,?,?)";
	PreparedStatement ps=con.prepareStatement(sql);
	
	ps.setInt(1, sr.getEnq_id());
	ps.setString(2, sr.getName());
	ps.setString(3, sr.getEmail());
	ps.setLong(4, sr.getMob());
	ps.setInt(5, sr.getCourse_id());
	ps.setString(6, sr.getDate());
	
	int i=ps.executeUpdate();
	
	if(i==1)
	{
		b=true;
	}
	return b;
}


public courses feefetch(int courseid) throws SQLException {
	
	courses cs=null;
	String sql="select * from courses where course_id=?";
	PreparedStatement ps=con.prepareStatement(sql);
	
	ps.setInt(1, courseid);
	ResultSet rs=ps.executeQuery();
	while(rs.next())
	{
		cs=new courses();
		cs.setCourse_id(rs.getInt(1));
		cs.setCourse_name(rs.getString(2));
		cs.setDuration(rs.getString(3));
		cs.setFees(rs.getLong(4));
		System.out.println(cs.getCourse_name()+"\t"+cs.getFees());
	}
	
	return cs;
}


	//fetch client data//

public List<client> fetchclientdata() throws SQLException {
	
	List<client> cl=new ArrayList<client>();
	
	String sql="select * from client";
	PreparedStatement ps=con.prepareStatement(sql);
	ResultSet rs=ps.executeQuery();
	while(rs.next())
	{
		client c=new client();
		c.setId(rs.getInt(1));
		c.setName(rs.getString(2));
		c.setAddress(rs.getString(3));
		c.setEmail(rs.getString(4));
		c.setMob(rs.getLong(5));
		
		cl.add(c);
		
	}
	return cl; 
	
}

       //delete client//
public boolean deleteclientrecord(int m) throws SQLException {
	boolean b=false;
	
	String  sql="delete from client where client_id=?";
	PreparedStatement ps=con.prepareStatement(sql);
	ps.setInt(1, m);
	int i=ps.executeUpdate();
	if(i==1)
	{
		b=true;
	}
	
	
	
	return b;
}


		//fetch Client Record//
public client clientrecordfetch(int a) throws SQLException {
	
	client cl=null;
	String sql="select * from client where client_id=?";
	PreparedStatement ps=con.prepareStatement(sql);
	ps.setInt(1, a);
	ResultSet rs=ps.executeQuery();
	while(rs.next())
	{
		cl=new client();
		cl.setId(rs.getInt(1));
		cl.setName(rs.getString(2));
		cl.setAddress(rs.getString(3));
		cl.setEmail(rs.getString(4));
		cl.setMob(rs.getLong(5));
	}
	
	
	return cl;
	
}


public boolean clientupdateinsert(client cl) throws SQLException {
	boolean b=false;
	
	String sql="update client set name=?,address=?,email=?,mob=? where client_id=?";
	PreparedStatement ps=con.prepareStatement(sql);
	System.out.println(ps);
	ps.setString(1, cl.getName());
	ps.setString(2, cl.getAddress());
	ps.setString(3, cl.getEmail());
	ps.setLong(4, cl.getMob());
	ps.setInt(5, cl.getId());
	
	int i=ps.executeUpdate();
	System.out.println(i);
	if(i==1)
	{
		b=true;
	}
	System.out.println("Updated Successfully");
	return b;
}


		//fetch Course Data//
public List<courses> fetchcoursedata()throws SQLException{
	
	List<courses> cl=new ArrayList<courses>();
	String sql="select * from courses";
	PreparedStatement ps=con.prepareStatement(sql);
	ResultSet rs=ps.executeQuery();
	while(rs.next())
	{
		courses co=new courses();
		co.setCourse_id(rs.getInt(1));
		co.setCourse_name(rs.getString(2));
		co.setDuration(rs.getString(3));
		co.setFees(rs.getLong(4));
		
		cl.add(co);
	}
	return cl;
	
}

		// Delete Course Record//
public boolean deletecourserecord(int course_id) throws SQLException {
	boolean b=false;
	String sql="delete from courses where course_id=?";
	PreparedStatement ps=con.prepareStatement(sql);
	ps.setInt(1, course_id);
	System.out.println(ps);
	int i=ps.executeUpdate();
	if(i==1)
	{
		b=true;
	}
	
	return b;
}



public courses courserecordfetch(int course_id) throws SQLException {
	
	courses c= null;
	String sql="select * from courses where course_id=?";
	PreparedStatement ps=con.prepareStatement(sql);
	ps.setInt(1, course_id);
	ResultSet rs=ps.executeQuery();
	while(rs.next())
	{
		c=new courses();
		c.setCourse_id(rs.getInt(1));
		c.setCourse_name(rs.getString(2));
		c.setDuration(rs.getString(3));
		c.setFees(rs.getLong(4));
		
	}
	
	
	
	return c;
	
}


public boolean courseupdateinsert(courses c) throws SQLException {
	boolean b=false;
	String sql="update courses set course_name=?,duration=?,fees=? where  course_id=?";
	PreparedStatement ps=con.prepareStatement(sql);
	
	
	ps.setString(1, c.getCourse_name());
	ps.setString(2, c.getDuration());
	ps.setLong(3, c.getFees());
	ps.setInt(4, c.getCourse_id());
	
	int i=ps.executeUpdate();
	System.out.println(i);
	if(i==1)
	{	
		b=true;
	}
	
	System.out.println("Record Updated Successfully");
	return b;
}

public List<project> fetchprojectdata()throws SQLException{
	project pro=null;
	List<project> prj=new ArrayList<project>();
	String sql="select * from project";
	PreparedStatement ps=con.prepareStatement(sql);
	ResultSet rs=ps.executeQuery();
	while(rs.next())
	{
		pro=new project();
		pro.setId(rs.getInt(1));
		pro.setName(rs.getString(2));
		pro.setTech(rs.getString(3));
		pro.setSt_date(rs.getString(4));
		pro.setEnd_date(rs.getString(5));
		pro.setStatus(rs.getString(6));
		
		prj.add(pro);
	}
	
	
	
	return prj;
	
}


public boolean deleteprojectrecord(int proj_id) throws SQLException {
	boolean b=false;
	String sql="delete from project where proj_id=?";
	PreparedStatement ps=con.prepareStatement(sql);
	ps.setInt(1, proj_id);
	int i=ps.executeUpdate();
	if(i==1)
	{
		b=true;
	}
	return b;
}


public project projectrecordfetch(int proj_id)throws SQLException{
	
	project prj=null;
	String sql="select * from project where proj_id=?";
	PreparedStatement ps=con.prepareStatement(sql);
	ps.setInt(1, proj_id);
	ResultSet rs=ps.executeQuery();
	while(rs.next())
	{
		prj=new project();
		prj.setId(rs.getInt(1));
		prj.setName(rs.getString(2));
		prj.setTech(rs.getString(3));
		prj.setSt_date(rs.getString(4));
		prj.setEnd_date(rs.getString(5));
		prj.setStatus(rs.getString(6));
		prj.setCl_id(rs.getInt(7));
		
	}
	
	
	return prj;
	
}


public boolean projectupdateinsert(project prj) throws SQLException {
	boolean b=false;
	String sql="update project set proj_name=?,technology=?,start_dt=?,end_dt=?,status=?,client_id=? where proj_id=?";
	PreparedStatement ps=con.prepareStatement(sql);
	ps.setString(1, prj.getName());
	ps.setString(2, prj.getTech());
	ps.setString(3, prj.getSt_date());
	ps.setString(4, prj.getEnd_date());
	ps.setString(5, prj.getStatus());
	ps.setInt(6, prj.getCl_id());
	ps.setInt(7, prj.getId());
	
	int i=ps.executeUpdate();
	System.out.println(i);
	if(i==1)
	{
		b=true;
	}
	
	return b;
}

	// Fetch Student Data//
public List<student_registration> fetchstudentdata() throws SQLException{
	student_registration sr=null;
	List<student_registration> s=new ArrayList<student_registration>();
	String sql="select * from student_registration";
	PreparedStatement ps=con.prepareStatement(sql);
	System.out.println(ps);
	ResultSet rs=ps.executeQuery();
	while(rs.next())
	{
		sr=new student_registration();
		sr.setStud_id(rs.getInt(1));
		sr.setEnq_id(rs.getInt(2));
		sr.setName(rs.getString(3));
		sr.setEmail(rs.getString(4));
		sr.setMob(rs.getLong(5));
		sr.setCourse_id(rs.getInt(6));
		sr.setDate(rs.getString(7));
		
		
		s.add(sr);
		System.out.println(sr.getName());
	}
	
	return s;
	
}


public boolean deletestudentrecord(int stud_id) throws SQLException {
	boolean b=false;
	String sql="delete from student_registration where stud_id=?";
	PreparedStatement ps=con.prepareStatement(sql);
	ps.setInt(1, stud_id);
	int i=ps.executeUpdate();
	if(i==1)
	{
		b=true;
	}
	
	
	return b;
}


public student_registration studentrecordfetch(int stud_id)throws SQLException{
	
	student_registration sr=null;
	String sql="select * from student_registration where stud_id=?";
	PreparedStatement ps=con.prepareStatement(sql);
	System.out.println(ps);
	ps.setInt(1, stud_id);
	ResultSet rs=ps.executeQuery();
	while(rs.next())
	{
		sr=new student_registration();
		sr.setStud_id(rs.getInt(1));
		sr.setEnq_id(rs.getInt(2));
		sr.setName(rs.getString(3));
		sr.setEmail(rs.getString(4));
		sr.setMob(rs.getLong(5));
		sr.setCourse_id(rs.getInt(6));
		sr.setDate(rs.getString(7));
		
	}
	return sr;
	
	
}


public boolean studentupdateinsert(student_registration sr) throws SQLException {
	boolean b=false;
	String sql="update student_registration set enq_id=?,name=?,email=?,mob=?,course_id=?,date=? where stud_id=?";
	PreparedStatement ps=con.prepareStatement(sql);
	ps.setInt(1, sr.getStud_id());
	ps.setString(2, sr.getName());
	ps.setString(3, sr.getEmail());
	ps.setLong(4, sr.getMob());
	ps.setInt(5, sr.getCourse_id());
	ps.setString(6, sr.getDate());
	ps.setInt(7, sr.getStud_id());
	
	int i=ps.executeUpdate();
	if(i==1)
	{
		b=true;
	}
	
	
	return b;
}


//fetch course name in student data table//

public String fetchcoursenm(int course_id)throws SQLException{
	String coursenm=null;
	String sql="select course_name from courses where course_id=?";
	PreparedStatement ps=con.prepareStatement(sql);
	ps.setInt(1,course_id);
	ResultSet rs=ps.executeQuery();
	if(rs.next())
	{
		coursenm=rs.getString("course_name");
	}
			
	
	
	
	return coursenm;
	
}

	}
	
	


