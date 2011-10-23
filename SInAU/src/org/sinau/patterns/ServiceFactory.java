package org.sinau.patterns;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Properties;

/**
 * Classe que permite criar listas com classes, dado um servico.
 * <p>Esta classe funciona como no <i>pattern</i> <b>Factory Method</b>.
 * </p>Utilizando esta classe, é possível buscar no servidor de WebServices qualquer classe que o sistema disponibiliza.
 * <br>Como o servidor não permite pegar um objeto isolado, não é possível pegar um único objeto. Porém é possível pegar uma lista com todos eles.
 * */
public class ServiceFactory {
	private Properties classes;
	
	/**
	 * Instancia uma nova fábrica na memória.
	 * @param file Arquivo de propriedades com as chaves e classes.
	 * */
	public ServiceFactory(String file) throws Exception {
		classes = new Properties();
		classes.load(new FileInputStream(file));
	}
	
	/**
	 * Instancia uma nova fábrica na memória, utilizando o arquivo padrão <code>services.properties</code>.
	 * */
	public ServiceFactory() throws Exception {
		this("configs/services.properties");
	}
	
	/**
	 * Cria a lista, utilizando a string <code>servico</code> para diferenciar a lista.
	 * <br>Por exemplo:
	 * <p><code>ServiceFactory sf = new ServiceFactory();
	 * <br>List lista = sf.create("usuarios");</code>
	 * </p>Irá retornar uma lista de todos os usuários no servidor de WebService.
	 * @param servico String que diferencia a lista de retorno.
	 * */
	public List create(String servico) throws Exception {
		String servicoClasse = classes.getProperty(servico);
		Class c = Class.forName(servicoClasse);
		Method m = c.getMethod("getAll", new Class[] {});
		return (List) m.invoke(null, null);
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
		List lista = sf.create("usuarios");
		
		for (Object item : lista) {
			System.out.println(item);
		}
	}

}
