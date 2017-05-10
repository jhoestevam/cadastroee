package br.univel.rest.dto;

import java.io.Serializable;
import br.univel.model.Cliente;
import javax.persistence.EntityManager;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ClienteDTO implements Serializable {

	private Long id;
	private int version;
	private String nome;
	private String endereco;

	public ClienteDTO() {
	}

	public ClienteDTO(final Cliente entity) {
		if (entity != null) {
			this.id = entity.getId();
			this.version = entity.getVersion();
			this.nome = entity.getNome();
			this.endereco = entity.getEndereco();
		}
	}

	public Cliente fromDTO(Cliente entity, EntityManager em) {
		if (entity == null) {
			entity = new Cliente();
		}
		entity.setVersion(this.version);
		entity.setNome(this.nome);
		entity.setEndereco(this.endereco);
		entity = em.merge(entity);
		return entity;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(final int version) {
		this.version = version;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(final String endereco) {
		this.endereco = endereco;
	}
}