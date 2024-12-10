package com.tka;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Product obj = null;

		System.out.println("we are in UPDATE servlet");
		int pk = Integer.parseInt(request.getParameter("pid"));
		System.out.println(pk);

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava193demo", "root", "root");

			String query = "SELECT * FROM advjava193demo.product WHERE pId = ?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, pk);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int id = rs.getInt("pId");
				String nm = rs.getString("name");
				int pp = rs.getInt("price");
				int pq = rs.getInt("qty");
				String cat = rs.getString("category");
				obj = new Product(id, nm, pp, pq, cat);

			}
			// Step 3 Navigation 
			
			request.setAttribute("obj", obj);
			RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
				rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

		// Step 1 get data
		
				String pname = request.getParameter("pn");
				String pprice =request.getParameter("pp");
				String pk =request.getParameter("pid");
				
				String pquant = request.getParameter("pq");
				String pcat = request.getParameter("pc");
				
//				Product obj = new Product(pname,pprice,pquant,pcat);
				
				System.out.println(pname);
	}

}
