package org.sinau.patterns;

import java.util.HashMap;
import java.util.List;

import org.sinau.beans.Administrador;
import org.sinau.beans.Aluno;
import org.sinau.beans.AlunoDisciplina;
import org.sinau.beans.Curso;
import org.sinau.beans.Departamento;
import org.sinau.beans.Disciplina;
import org.sinau.beans.Professor;
import org.sinau.beans.ProfessorDisciplina;
import org.sinau.beans.Universidade;
import org.sinau.beans.Usuario;
import org.sinau.config.Config;

import com.sun.jersey.api.client.GenericType;

/**
 * Classe que permite criar listas com classes, dado um servico.
 * <p>Esta classe funciona como no <i>pattern</i> <b>Factory Method</b>.
 * </p>Utilizando esta classe, é possível buscar no servidor de WebServices qualquer classe que o sistema disponibiliza.
 * <br>Como o servidor não permite pegar um objeto isolado, não é possível pegar um único objeto. Porém é possível pegar uma lista com todos eles.
 * */
public class ServiceFactory {
	@SuppressWarnings("rawtypes")
	HashMap<String, GenericType> classes;
	
	/**
	 * Instancia uma nova fábrica na memória.
	 * */
	@SuppressWarnings("rawtypes")
	public ServiceFactory(){
		classes = new HashMap<String, GenericType>();
		
		classes.put("usuarios", new GenericType<List<Usuario>>() {});
		classes.put("alunos", new GenericType<List<Aluno>>() {});
		classes.put("professores", new GenericType<List<Professor>>() {});
		classes.put("administradores", new GenericType<List<Administrador>>() {});
		classes.put("alunodisciplina", new GenericType<List<AlunoDisciplina>>() {});
		classes.put("cursos", new GenericType<List<Curso>>() {});
		classes.put("departamentos", new GenericType<List<Departamento>>() {});
		classes.put("disciplinas", new GenericType<List<Disciplina>>() {});
		classes.put("profdisciplinas", new GenericType<List<ProfessorDisciplina>>() {});
		classes.put("universidades", new GenericType<List<Universidade>>() {});
	}
	
	/**
	 * Cria a lista, utilizando a string <code>servico</code> para diferenciar a lista.
	 * <br>Por exemplo:
	 * <p><code>ServiceFactory sf = new ServiceFactory();
	 * <br>List lista = sf.create("usuarios");</code>
	 * </p>Irá retornar uma lista de todos os usuários no servidor de WebService.
	 * @param servico String que diferencia a lista de retorno.
	 * */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List create(String servico) throws Exception {
		List list = Config.getInstance().getService(servico).get(classes.get(servico));
		return list;
	}
	
	/**
	 * Exemplo de uso da factory.
	 * <p><code>ServiceFactory sf = new ServiceFactory();
	 *	<br>List lista = sf.create("usuarios");
	 *	<br>
	 *	<br>for (Object item : lista) {
	 *	<br>&nbsp;&nbsp;&nbsp;System.out.println(item);
	 *	<br>}</code></p>
	 * @param args 
	 * */
	public static void main(String[] args) throws Exception {
		ServiceFactory sf = new ServiceFactory();
		@SuppressWarnings("rawtypes")
		List lista = sf.create("usuarios");
		for (Object item : lista) {
			System.out.println(item);
		}
	}

}
