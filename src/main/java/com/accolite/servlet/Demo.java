package com.accolite.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Demo
 */
public class Demo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Demo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Connection conn = DB_Connection.get_Db_Connection();
			if(conn != null) {
				System.out.println("Connection Established Successfully");
			}
			Statement stmt=conn.createStatement();  
			response.setContentType("text/html");
			PrintWriter Out = response.getWriter();

			int id = (Integer.parseInt(request.getParameter("roll")));
			String Name = request.getParameter("name");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String query = "insert into servlet_streams_exercises VALUES (" +id+ ", '" + Name + 
					"', '" + email + "', '" + phone +"')";
			int rs=stmt.executeUpdate(query);
			if(rs == 1) {
				System.out.println("Success");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
