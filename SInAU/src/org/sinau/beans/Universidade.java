package org.sinau.beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.Session;
import org.sinau.db.DBManager;

@Entity
@XmlRootElement
public class Universidade implements Serializable {
	private static final long serialVersionUID = 1840896364124720644L;

	@Id
	private Integer iduniversidade;
	
	private String cep;
	private String cidade;
	private String endereco;
	private String nome;
	
	@OneToMany
	@JoinColumn(name="universidadeid")
	private Set<Departamento> departamentos = new HashSet<Departamento>();
	
	public Integer getIduniversidade() {
		return iduniversidade;
	}

	public String getCep() {
		return cep;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getNome() {
		return nome;
	}

	public Set<Departamento> getDepartamentos() {
		return departamentos;
	}

	public void setIduniversidade(Integer iduniversidade) {
		this.iduniversidade = iduniversidade;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDepartamentos(Set<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

	@Override
	public String toString() {
		return "Universidade [iduniversidade=" + iduniversidade + ", cep="
				+ cep + ", cidade=" + cidade + ", endereco=" + endereco
				+ ", nome=" + nome + "]";
	}

	public static Universidade load (Integer id) {
		Session session = DBManager.getSession();
		return (Universidade) session.load(Universidade.class, id);
	}
}
