package com.tka;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class DisplayAllProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava193demo","root", "root");
			
			String query = "SELECT * FROM advjava193demo.product";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			List<Product> plist = new ArrayList<Product>();
			
			  while(rs.next()) {
				  
				  int id = rs.getInt("pid");
				  String nm = rs.getString("name");
				  int pp = rs.getInt("price");
				  int pq = rs.getInt("qty");
				  String cat = rs.getString("category");
				 Product obj = new Product(id,nm,pp, pq,cat);
				 plist.add(obj);
				  
			  }
			  
			  
			  
			  
			// Step 3 Navigation 
			
				request.setAttribute("data", plist);
				RequestDispatcher rd = request.getRequestDispatcher("display.jsp");
					rd.forward(request, response);
					
//					response.sendRedirect("display-all");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
