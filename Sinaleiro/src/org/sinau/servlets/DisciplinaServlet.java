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
import org.sinau.beans.AlunoDisciplina;
import org.sinau.beans.Disciplina;
import org.sinau.db.DBManager;

/**
 * Servlet implementation class Teste
 */

@WebServlet("/disciplina")
public class DisciplinaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisciplinaServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PrintStream out = new PrintStream(response.getOutputStream());
		response.setContentType("text/json; charset=ISO-8859-1");

		String id = request.getParameter("id");
		
		Session session = DBManager.getSession();
		session.beginTransaction();
		
		Collection colecao = null;
		
		String ret = "{";
		
		if (id == null) {
			ret += "\"submenu\" : \"disciplina?id=\",";
			colecao = Disciplina.findAll();
		} else {
			colecao = AlunoDisciplina.findAlunoBolsistaByDisciplina(Integer.parseInt(id));
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
