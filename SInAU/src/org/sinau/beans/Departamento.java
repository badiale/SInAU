package org.sinau.beans;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;

import org.sinau.config.Config;

import com.sun.jersey.api.client.GenericType;

@XmlRootElement
public class Departamento implements Serializable {
	private String iddepartamento;
	private Universidade universidade;
	private String nome;
	private String telefone;
	
	@XmlID
	public String getIddepartamento() {
		return iddepartamento;
	}
	
	@XmlElement(name = "iduniversidade")
	public void setIduniversidade(String iduniversidade) {
		this.universidade = Universidade.get(iduniversidade);
	}
	
	public Universidade getUniversidade() {
		return universidade;
	}
	public String getNome() {
		return nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setIddepartamento(String iddepartamento) {
		this.iddepartamento = iddepartamento;
	}
	public void setUniversidade(Universidade universidade) {
		this.universidade = universidade;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	@Override
	public String toString() {
		return "Departamento [iddepartamento=" + iddepartamento
				+ ", universidade=" + universidade + ", nome=" + nome
				+ ", telefone=" + telefone + "]";
	}
	
	public static Departamento get(String id) {
		return Config.getInstance().getService("departamentos").path(id).get(Departamento.class);
	}
	
	public static List<Departamento> getAll() {
		return Config.getInstance().getService("departamentos").get(new GenericType<List<Departamento>>() {});
	}
	
	// teste
	public static void main(String[] args) {
		System.out.println(get("1"));
		System.out.println(getAll());
	}
}