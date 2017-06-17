package com.firstapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

@WebServlet("/RegisterURL")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JDBCConnection connection=new JDBCConnection();
		try {
			Connection con=(Connection) connection.getConnection();
			String FirstName = request.getParameter("firstName");
			String LastName = request.getParameter("lastName");
			String UserName = request.getParameter("userName");
			String Password = request.getParameter("password");
			String ConfirmPassword = request.getParameter("confirmPassword");
			
			if(Password.equals(ConfirmPassword)){
			String query="insert into register(FirstName,LastName, UserName, Password) values (?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, FirstName);
			ps.setString(2, LastName);
			ps.setString(3, UserName);
			ps.setString(4, Password);
		
			ps.executeUpdate();
			}
			else{
				response.sendRedirect("Register.html");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
		
		

	}

	}