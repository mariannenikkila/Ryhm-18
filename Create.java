package app;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import data.Question;

@WebServlet(
	    name = "Create",
	    urlPatterns = {"/create"}
	)
public class Create extends HttpServlet {
	
	private Dao dao;
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "pena", "kukkuu");
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException, ServletException {
		String kysymys_id=request.getParameter("kysymys_id");
		String kysymys=request.getParameter("kysymys");
		
		Question f = new Question(kysymys_id,kysymys);
		
		
		ArrayList<Question> list=null;
		if (dao.getConnection()) {
			list=dao.createQuestion(f);
		}
		
		request.setAttribute("questionlist", list);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showquestion.jsp");
		rd.forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException, ServletException {
		String kysymys_id=request.getParameter("kysymys_id");
		String kysymys=request.getParameter("kysymys");
		
		Question f = new Question(kysymys_id,kysymys);
		
		
		ArrayList<Question> list=null;
		if (dao.getConnection()) {
			list=dao.createQuestion(f);
		}
		
		request.setAttribute("questionlist", list);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showquestion.jsp");
		rd.forward(request, response);
	}
}