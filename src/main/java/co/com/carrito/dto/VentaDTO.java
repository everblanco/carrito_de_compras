package co.com.carrito.dto;

import java.io.Serializable;

import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO para recibir datos de Venta (DTO)
 * 
 *
 */
@Setter
@NoArgsConstructor
public class VentaDTO implements Serializable {

	private static final long serialVersionUID = -3559300399907406753L;

	// Atributos
	private Long	id;
	private Long	valor;

	// ----------
	// Getters
	// ----------

	public Long getId() {
		return id;
	}

	public Long getValor() {
		return valor;
	}

}
