package org.sinau.servlets;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.sinau.beans.Aluno;
import org.sinau.beans.Departamento;
import org.sinau.beans.Professor;
import org.sinau.db.DBManager;

/**
 * Servlet implementation class Teste
 */
@WebServlet("/departamento")
public class DepartamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DepartamentoServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintStream out = new PrintStream(response.getOutputStream());
		response.setContentType("text/json; charset=ISO-8859-1");

		String depId = request.getParameter("depId");
		
		Session session = DBManager.getSession();
		session.beginTransaction();
		
		Collection colecao = null;
		
		String ret = "{";
		
		if (depId == null) {
			ret += "\"submenu\" : \"departamento?depId=\",";
			colecao = Departamento.findAll();
		} else {
			Departamento dep = Departamento.load(Integer.parseInt(depId));
			colecao = dep.getProfessores();
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

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
