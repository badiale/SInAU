package org.sinau.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;

import org.sinau.config.Config;

import com.sun.jersey.api.client.GenericType;

@XmlRootElement
public class Aluno implements Serializable {
	private String matriculaNusp;
	private Date anoInicio;
	private Boolean bolsista;
	private String endereco;
	private Usuario usuario;
	private Integer semestre;
	
	public Aluno () {}
	
	@XmlElement(name = "idusuario")
	public void setIdusuario (String id) {
		this.usuario = Usuario.get(id);
	}
	
	public Date getAnoInicio() {
		return anoInicio;
	}

	public Boolean getBolsista() {
		return bolsista;
	}

	public String getEndereco() {
		return endereco;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	@XmlID
	public String getMatriculaNusp() {
		return matriculaNusp;
	}

	public Integer getSemestre() {
		return semestre;
	}

	public void setAnoInicio(Date anoInicio) {
		this.anoInicio = anoInicio;
	}

	public void setBolsista(Boolean bolsista) {
		this.bolsista = bolsista;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setMatriculaNusp(String matriculaNusp) {
		this.matriculaNusp = matriculaNusp;
	}

	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}

	@Override
	public String toString() {
		return "Alunos [anoInicio=" + anoInicio + ", bolsista=" + bolsista
				+ ", endereco=" + endereco + ", usuario=" + usuario
				+ ", matriculaNusp=" + matriculaNusp + ", semestre=" + semestre
				+ "]";
	}
	
	public static List<Aluno> getAll() {
		return Config.getInstance().getService("alunos").get(new GenericType<List<Aluno>>() {});
	}
	
	// teste
	public static void main(String[] args) {
		System.out.println(Aluno.getAll());
	}
}
