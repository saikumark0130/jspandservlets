package com.firstapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(description = "Login servlet", urlPatterns = { "/LoginURL" })

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	JDBCConnection connection=new JDBCConnection();

   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String UserName = request.getParameter("UserName");
	String Password = request.getParameter("password");
	try {
		System.out.println(UserName+Password);
		
		Connection conn=(Connection) connection.getConnection();
		String query = "SELECT firstname, lastname FROM register WHERE username=? AND password=?";
		
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, UserName);
		ps.setString(2, Password);
		
		ResultSet rs=ps.executeQuery(query);
		
		PrintWriter out=response.getWriter();
		out.print("Hello.... "+rs.getString("firstname")+" "+rs.getString("lastname"));
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	          
	}

}
