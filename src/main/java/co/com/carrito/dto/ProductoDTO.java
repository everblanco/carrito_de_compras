package co.com.carrito.dto;

import java.io.Serializable;

import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO para recibir datos de Producto (DTO)
 * 
 *
 */
@Setter
@NoArgsConstructor
public class ProductoDTO implements Serializable {

	private static final long serialVersionUID = -3559300399907406753L;

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
	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getMarca() {
		return marca;
	}

	public Long getPrecio() {
		return precio;
	}

	public Integer getCantidadStock() {
		return cantidadStock;
	}

	public String getEstado() {
		return estado;
	}

	public Integer getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

}
