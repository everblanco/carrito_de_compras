package co.com.carrito.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase para el manejo de Venta (Entidad)
 * 
 *
 */
@Entity
@Setter
@NoArgsConstructor
@Table(name = "VENTA")
public class Venta implements Serializable {

	private static final long serialVersionUID = -6470576679846374423L;
	// Atributos
	private Long	id;
	private Long	valor;

	// ----------
	// Getters
	// ----------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	@Column(name = "VALOR", nullable = false)
	public Long getValor() {
		return valor;
	}
}
