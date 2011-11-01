package org.sinau.beans;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.sinau.config.Config;

import com.sun.jersey.api.client.GenericType;

@XmlRootElement
public class Universidade implements Serializable {
	private String cep;
	private String cidade;
	private String endereco;
	private Integer iduniversidade;
	private String nome;
	public String getCep() {
		return cep;
	}
	public String getCidade() {
		return cidade;
	}
	public String getEndereco() {
		return endereco;
	}
	public Integer getIduniversidade() {
		return iduniversidade;
	}
	public String getNome() {
		return nome;
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
	public void setIduniversidade(Integer iduniversidade) {
		this.iduniversidade = iduniversidade;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "Universidade [cep=" + cep + ", cidade=" + cidade
				+ ", endereco=" + endereco + ", iduniversidade="
				+ iduniversidade + ", nome=" + nome + "]";
	}
}
