package org.sinau.beans;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;

import org.sinau.config.Config;

import com.sun.jersey.api.client.GenericType;

@XmlRootElement(name = "admin")
public class Administrador implements Serializable {
	private String cargo;
	private Usuario usuario;
	
	public Administrador() {}
	
	@XmlElement(name = "idusuario")
	public void setIdusuario (String id) {
		setUsuario(Usuario.get(id));
	}
	
	public String getCargo() {
		return cargo;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public String toString() {
		return "Administrador [cargo=" + cargo + ", usuario=" + usuario + "]";
	}

	public static List<Administrador> getAll() {
		return Config.getInstance().getService("administradores").get(new GenericType<List<Administrador>>() {});
	}
	
	// teste
	public static void main(String[] args) {
		System.out.println(getAll());
	}
}
