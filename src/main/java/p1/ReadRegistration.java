package p1;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/read")
public class ReadRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ReadRegistration() {
        super();
      
    }

    protected void doGet(HttpServletRequest request, 
    		HttpServletResponse response) throws ServletException, IOException {
    	
    	  response.setContentType("text/html");// this tells that i write text or html.
	      PrintWriter writer = response.getWriter();
          writer.println("<table>");
          
	      writer.println("<tr>");
	      
	      writer.println("<th>");
	      writer.println("id");
	      writer.println("</th>");
	      
	      writer.println("<th>");
	      writer.println("name");
	      writer.println("</th>");
	      
	      writer.println("<th>");
	      writer.println("salary");
	      writer.println("</th>");
	      
	      writer.println("<th>");
	      writer.println("address");
	      writer.println("</th>");
	      
	      writer.println("</tr>");
	      try {
				Class.forName("com.mysql.cj.jdbc.Driver");// if this is not present the date do not go to the database 
				// because Tomcat cannot locate this class automatically.
				//1.connecting to database
				Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/practice_db","root","test");
		
		       Statement stmnt = con.createStatement();		
				
			 ResultSet result1 = stmnt.executeQuery("select * from employee");
			
			while(result1.next()) {
	    		  writer.println("<tr>");
	    	      
	    	      writer.println("<td>");
	    	      writer.println(result1.getString(1));
	    	      writer.println("</td>");
	    	      
	    	      writer.println("<td>");
	    	      writer.println(result1.getString(2));
	    	      writer.println("</td>");
	    	      
	    	      writer.println("<td>");
	    	      writer.println(result1.getString(3));
	    	      writer.println("</td>");
	    	      
	    	      writer.println("<td>");
	    	      writer.println(result1.getString(4));
	    	      writer.println("</td>");
	    	      
	    	      writer.println("</tr>");
		}
			
			 con.close();
	      }catch(Exception e) {
	    	  e.printStackTrace();
	      }
	      writer.println("</table");
			
		 }
      

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		}
} 


