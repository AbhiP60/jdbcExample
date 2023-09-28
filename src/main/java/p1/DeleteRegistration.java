package p1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteRegistration() {
        super();
      
    }

    protected void doGet(HttpServletRequest request, 
    		HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
	
		
		String name = request.getParameter("name");
		System.out.println(name);
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");// if this is not present the date do not go to the database 
			// because Tomcat cannot locate this class automatically.
			//1.connecting to database
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/practice_db","root","test");
			System.out.println(con);
			
			//2.To  create SQL query(java+ SQL insert
			Statement stmnt = con.createStatement();		
			stmnt.executeUpdate("delete from  employee where name='"+name+"'");
			
			//3. To close the connection
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

}
