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
 * Clase para el manejo de Producto (Entidad)
 * 
 *
 */
@Entity
@Setter
@NoArgsConstructor
@Table(name = "PRODUCTO")
public class Producto implements Serializable {

	private static final long serialVersionUID = -254747720094795954L;

	// Atributos
	private Long		id;
	private String	nombre;
	private String	marca;
	private Long		precio;
	private Integer	cantidadStock;
	private String	estado;
	private Integer	porcentajeDescuento;

	// ----------
	// Getters
	// ----------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	@Column(name = "NOMBRE", nullable = false)
	public String getNombre() {
		return nombre;
	}

	@Column(name = "MARCA", nullable = false)
	public String getMarca() {
		return marca;
	}

	@Column(name = "PRECIO", nullable = false)
	public Long getPrecio() {
		return precio;
	}

	@Column(name = "CANTIDAD_STOCK", nullable = false)
	public Integer getCantidadStock() {
		return cantidadStock;
	}

	@Column(name = "ESTADO", nullable = false)
	public String getEstado() {
		return estado;
	}

	@Column(name = "PORCENTAJE_DESCUENTO", nullable = false)
	public Integer getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

}
