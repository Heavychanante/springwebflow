package org.mju.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entidad que representa la tabla Campaña de la base de datos
 * @author Hugo
 *
 */
@Entity
@Table(name = "campania")
public class Campania {

	// ATRIBUTOS //

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "titulo", nullable = false, length = 100)
	private String titulo;

	@Column(name = "acto", nullable = false)
	private Integer acto = 1;

	@ManyToOne
	@JoinColumn(name = "campania_id")
	private Campania campania;

	@Column(name = "creacion")
	private Timestamp creacion;

	@Column(name = "modificacion")
	private Timestamp modificacion;

	// CONSTRUCTORES //

	public Campania() {

	}

	public Campania(String titulo, Integer acto) {
		this.titulo = titulo;
		this.acto = acto;
	}

	// MÉTODOS //

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getActo() {
		return acto;
	}

	public void setActo(Integer acto) {
		this.acto = acto;
	}

	public Campania getCampania() {
		return campania;
	}

	public void setCampania(Campania campania) {
		this.campania = campania;
	}

	public Timestamp getCreacion() {
		return creacion;
	}

	public void setCreacion(Timestamp creacion) {
		this.creacion = creacion;
	}

	public Timestamp getModificacion() {
		return modificacion;
	}

	public void setModificacion(Timestamp modificacion) {
		this.modificacion = modificacion;
	}
}
