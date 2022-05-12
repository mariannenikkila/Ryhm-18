package app;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;



@WebServlet("/loginServlet")

public class loginServlet extends HttpServlet {

	private Dao dao;
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "root", "0409678730");
	}
	
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	
    	String username2 = ("admin");
    	String username = request.getParameter("username");
    	
    	
    	String password2 = ("admin");
    	String password = request.getParameter("password");
    	
    	
    	boolean test1 = username.equals(username2);
    	boolean test2 = password.equals(password2);
    	PrintWriter writer = response.getWriter();
    	
    	if (test1 == true && test2 == true){
    		 
    	      System.out.println("Tervetuloa admin");
    	      String htmlRespone = "<html>";
    	        htmlRespone += "<h2>Kirjautuminen onnistui</h2>";      
    	        htmlRespone += "<p><a href='/jsp/ShowQuestions.jsp'>Näytä Kysymykset</a></p>";    
    	        htmlRespone += "</html>";
    	        
    	        writer.println(htmlRespone);
    	}
    	else {
    		System.out.println("Kirjautuminen epäonnistui");
    	}
    	

    }
}
