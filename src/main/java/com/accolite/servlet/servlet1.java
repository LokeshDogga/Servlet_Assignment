package com.accolite.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class servlet1
 */
public class servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		String query = "select * from servlet_streams_exercises where id =	" + id;
		try {
			Connection conn = DB_Connection.get_Db_Connection();
			if(conn != null) {
				System.out.println("Connection Established Successfully");
			}
			Statement stmt=conn.createStatement();  
			response.setContentType("text/html");
			PrintWriter Out = response.getWriter();
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				Out.println("Success");
			}
			System.out.println(rs.getString("name"));
			HttpSession session = request.getSession();
			session.setAttribute("name", rs.getString("name"));
			session.setAttribute("email", rs.getString("email"));
			session.setAttribute("phone", rs.getString("phone"));
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/servlet2");
        response.sendRedirect("servlet2");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
