package com.tka;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			int pk =Integer.parseInt(request.getParameter("pid"));
			System.out.println(pk);
			
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava193demo","root", "root");
				
				String query = "DELETE FROM advjava193demo.product WHERE pId = ?";
				
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setInt(1,pk);
				
				
				int data = ps.executeUpdate();
				
				// Step 3 Navigation 
				if(data > 0) {
					String msg="Data Deleted Successfully";
//					request.setAttribute("data", msg);
//					RequestDispatcher rd = request.getRequestDispatcher("display-all");
//						rd.forward(request, response);
						
					
				}else {
					String msg="Something went wrong";
					request.setAttribute("data", msg);
//					RequestDispatcher rd = request.getRequestDispatcher("display-all");
//						rd.forward(request, response);
				}
				response.sendRedirect("display-all");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	
	}

}
