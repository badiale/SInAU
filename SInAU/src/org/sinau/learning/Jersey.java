/**
 * Este pacote contém exemplos que poderão ser usados como guia na hora da implementação do projeto.
 * */
package org.sinau.learning;

import org.sinau.config.Config;

import java.io.Serializable;
import java.util.List;
import com.sun.jersey.api.client.GenericType;

import javax.xml.bind.annotation.XmlRootElement;

/** 
 * Este é um exemplo de como uma classe se comunica com um webservice.
 * <br>Para criar uma classe que se comunique com o webservice, é necessário colocar a annotation <code>@XmlRootElement</code>.
 * <br>A annotation tem dois parâmetros opcionais:
 * <ul>
 * 		<li><code>name</code> - Deve ser usado caso o nome da classe nao seja o mesmo do xml.</li>
 * 		<li><code>namespace</code> - Deve ser usado caso o xml tenha um namespace.</li>
 * </ul> 
 * @author badiale
 */
@XmlRootElement(name = "usuario")
public class Jersey implements Serializable {
	/**
	 * Eclipse coloca isso aqui, não sei o que é. 
	 */
	private static final long serialVersionUID = 4939789647817447009L;
	
	/**
	 * É só colocar as variáveis, normalmente, sempre usando objetos.
	 * */
	private Boolean ativo;
	private String email;
	private Integer idusuario;
	private String nome;
	private String nomeUsuario;
	private String senha;
	private String telefone;
	private String tipo;
	
	/**
	 * Pojo.
	 * <br>Funciona sem ele, mas não custa colocar.
	 * */
	public Jersey() {}
	
	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Jersey [ativo=" + ativo + ", email=" + email + ", idusuario="
				+ idusuario + ", nome=" + nome + ", nomeUsuario=" + nomeUsuario
				+ ", senha=" + senha + ", telefone=" + telefone + ", tipo="
				+ tipo + "]";
	}

	/**
	 * Executa o teste.
	 * <p>
	 * O importante neste projeto, é o método get.<br>
	 * Para conseguir pegar uma classe via WebService, é necessário um serviço: <code>Config.getInstance().getService()</code>.<br>
	 * Esse serviço é genérico, então é necessário colcoar o "path" para os usuários: <code>.path("usuarios")</code>.<br>
	 * Após isso, é só dar GET, especificando o tipo de retorno, que nesse caso é uma lista de usuários: <code>.get(new GenericType<List<Jersey>>() {})</code>.<br> 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(
				// pega o servico
				Config.getInstance().getService()
				// coloca usuarios na path
				.path("usuarios")
				// da GET na lista de usuarios
				.get(new GenericType<List<Jersey>>() {}));
	}

}
