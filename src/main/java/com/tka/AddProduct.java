package com.tka;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// Step 1 get data
		
		String pname = request.getParameter("pn");
		int pprice =Integer.parseInt(request.getParameter("pp"));
		
		int pquant = Integer.parseInt(request.getParameter("pq"));
		String pcat = request.getParameter("pc");
		
		
		
		// Step 2 Process data
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava193demo","root", "root");
			
			String query = "INSERT INTO  advjava193demo.product(name,price,qty,category)VALUES(?,?,?,?) ";
			
			PreparedStatement ps = conn.prepareStatement(query);
			Product obj = new Product(pname,pprice,pquant,pcat);
			
			ps.setString(1, obj.getName());
			ps.setInt(2, obj.getPrice());
			ps.setInt(3, obj.getQuantity());
			ps.setString(4, obj.getCategory());
			
			int data = ps.executeUpdate();
			
			// Step 3 Navigation 
			if(data > 0) {
				String msg="Data inserted Successfully";
				request.setAttribute("data", msg);
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
					
//					response.sendRedirect("display-all");
			}else {
				String msg="Something went wrong";
				request.setAttribute("data", msg);
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	
	}

}
