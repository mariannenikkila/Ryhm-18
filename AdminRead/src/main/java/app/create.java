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
	    name = "create",
	    urlPatterns = {"/create"} )
public class create extends HttpServlet{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Dao dao;
    public void init() {
        dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "pena", "kukkuu");
    }



    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
         throws IOException, ServletException {
        String KYSYMYS=request.getParameter("addQuestion");
        ArrayList<Question> list=null;
        if (dao.getConnection()) {;
            dao.AddTableData(KYSYMYS);

        }
        request.setAttribute("questionlist", list);
        RequestDispatcher rd=request.getRequestDispatcher("/jsp/ShowQuestions.jsp");
        rd.forward(request, response);
    }
}