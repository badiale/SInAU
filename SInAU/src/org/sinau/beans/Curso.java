package org.sinau.beans;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;

import org.sinau.config.Config;

import com.sun.jersey.api.client.GenericType;

@XmlRootElement
public class Curso implements Serializable {
	private String area;
	private String idcurso;
	private Departamento departamento;
	private String nome;
	private Integer vagas;
	
	@XmlID
	public String getIdcurso() {
		return idcurso;
	}
	
	@XmlElement(name = "iddepartamento")
	public void setIddepartamento(String id) {
		this.departamento = Departamento.get(id);
	}
	
	public String getArea() {
		return area;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public String getNome() {
		return nome;
	}
	public Integer getVagas() {
		return vagas;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public void setIdcurso(String idcurso) {
		this.idcurso = idcurso;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setVagas(Integer vagas) {
		this.vagas = vagas;
	}
	
	@Override
	public String toString() {
		return "Curso [area=" + area + ", idcurso=" + idcurso
				+ ", departamento=" + departamento + ", nome=" + nome
				+ ", vagas=" + vagas + "]";
	}
	
	public static Curso get(String id) {
		return Config.getInstance().getService("cursos").path(id).get(Curso.class);
	}
	
	public static List<Curso> getAll() {
		return Config.getInstance().getService("cursos").get(new GenericType<List<Curso>>() {});
	}
	
	// teste
	public static void main(String[] args) {
		System.out.println(get("1"));
		System.out.println(getAll());
	}
}