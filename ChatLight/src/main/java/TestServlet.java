

import jakarta.servlet.RequestDispatcher;
	import jakarta.servlet.ServletException;
	import jakarta.servlet.annotation.WebServlet;
	import jakarta.servlet.http.HttpServlet;
	import jakarta.servlet.http.HttpServletRequest;
	import jakarta.servlet.http.HttpServletResponse;
	import jakarta.servlet.http.HttpSession;

	import java.io.IOException;
	import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


	public class TestServlet  extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       

	    public TestServlet() {
	        super();
	       
	    }


		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter pw = response.getWriter();
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			try {
				Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ChatLight", "postgres", "Qwerty");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * from \"Users\"");
				
				while(rs.next()) {
					pw.println(rs.getString("User_Login"));
				}
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
					
		}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			
		}

	}
