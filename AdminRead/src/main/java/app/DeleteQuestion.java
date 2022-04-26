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
	    name = "DeleteQuestion",
	    urlPatterns = {"/delete"} )
public class DeleteQuestion extends HttpServlet{
	
	private Dao dao;
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "pena", "kukkuu");
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException, ServletException {
		String KYSYMYS_ID=request.getParameter("KYSYMYS_ID");
		ArrayList<Question> list=null;
		if (dao.getConnection()) {;
			list=dao.deleteQuestion(KYSYMYS_ID);
		
		}
		request.setAttribute("questionlist", list);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/ShowQuestions.jsp");
		rd.forward(request, response);
	}
}