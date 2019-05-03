package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/CounterDB")
public class CounterWithDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;
	int vCnt;
	int max;
	String counterStr;
	
    public int getvCnt() {
		return vCnt;
	}

	public void setvCnt(int vCnt) {
		this.vCnt = vCnt;
	}

	public void init() {
		
		max = 8;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loading success!!");
    	} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Connection makeConnection() {
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");
			System.out.println("DB Connection Success!!!");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return conn;
    }

	public void visitorCnt() {
		makeConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql1;
		String sql2;
		
		try {
			sql1 = "update counter set no = no + 1";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql1);
			
			if(rs.next()) {
			
			sql2 = "select no from counter";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql2);
			
			rs.next();
			setvCnt(rs.getInt("no"));
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
					try {
						if(rs != null)
							rs.close();
						if(stmt != null)
							stmt.close();
						if(conn != null)
							conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		}
		
		
	}
    
	public String makeCntForm(int vCnt) {
		counterStr = "";
		String numStr = String.valueOf(vCnt);
		int zeroCnt;
		
		zeroCnt = max - numStr.length();
		
		for(int i = 0 ; i < zeroCnt; i++) {
		counterStr += "0";
		
		}
		
		counterStr = counterStr.concat(numStr);
		
		return counterStr;
	}
	
	
    	@Override
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		
    		response.setContentType("text/html;charset=UTF-8");
    		PrintWriter out = response.getWriter();
    		
    		visitorCnt();
    		
    		
    		out.println("<html>");
    		out.println("<body>");
    		out.println("<div>당신은");
    		for(int i = 0; i<max;i++) {
    		out.println("<img src=\"/basicservlet/img/" + makeCntForm(getvCnt()).charAt(i) + ".png\" width=50>");
    		}
    		out.println("번째 방문자 입니다.</div>");
    		out.println("</body>");
    		out.println("</html>");
    	
    		
    	}
    	

    


}
