package org.sinau.servlets;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.sinau.beans.Professor;
import org.sinau.beans.ProfessorDisciplina;
import org.sinau.db.DBManager;

/**
 * Servlet implementation class Teste
 */

@WebServlet("/professor")
public class ProfessorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfessorServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PrintStream out = new PrintStream(response.getOutputStream());
		response.setContentType("text/json; charset=ISO-8859-1");

		String id = request.getParameter("id");
		String query = request.getParameter("query");
		
		Session session = DBManager.getSession();
		session.beginTransaction();
		
		Collection colecao = null;
		
		String ret = "{";
		
		if (id != null) {
			colecao = ProfessorDisciplina.findDisciplinaByProfessor(Integer.parseInt(id));
		} else if (query != null) {
			ret += "\"submenu\" : \"professor?id=\",";
			colecao = Professor.findByNameLike(query);
		} else {
			ret += "\"submenu\" : \"professor?id=\",";
			colecao = Professor.findAll();
		}
		
		for (Object obj : colecao)
			ret += obj.toString() + ",";
		
		if (ret.charAt(ret.length() - 1) == ',')
			ret = ret.substring(0, ret.length() - 1);
		
		ret += "}";
		
		System.out.println(ret);
		out.print(ret);
		out.close();

		session.getTransaction().commit();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
