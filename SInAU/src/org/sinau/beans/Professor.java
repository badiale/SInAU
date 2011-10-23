package org.sinau.beans;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.sinau.config.Config;

import com.sun.jersey.api.client.GenericType;

@XmlRootElement
public class Professor implements Serializable {
	private Boolean coordenador;
	private Departamento departamento;
	private Usuario usuario;
	
	public Professor() {}
	
	@XmlElement(name = "iddepartamento")
	public void setIddepartamento (String id) {
		this.departamento = Departamento.get(id);
	}
	
	@XmlElement(name = "idusuario")
	public void setIdusuario (String id) {
		this.usuario = Usuario.get(id);
	}
	
	public Boolean getCoordenador() {
		return coordenador;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setCoordenador(Boolean coordenador) {
		this.coordenador = coordenador;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public String toString() {
		return "Professor [coordenador=" + coordenador + ", departamento="
				+ departamento + ", usuario=" + usuario + "]";
	}
	
	public static List<Professor> getAll() {
		return Config.getInstance().getService("professores").get(new GenericType<List<Professor>>() {});
	}
	
	// teste
	public static void main(String[] args) {
		System.out.println(Professor.getAll());
	}

}
