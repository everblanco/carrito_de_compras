package co.com.carrito.dto;

import java.io.Serializable;

import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO para recibir datos de DetalleVenta (DTO)
 * 
 *
 */
@Setter
@NoArgsConstructor
public class DetalleVentaDTO implements Serializable {

	private static final long serialVersionUID = -3559300399907406753L;

	// Atributos
	private Long		id;
	private Long		idVenta;
	private Long		idProducto;
	private Integer	cantidad;
	private Long		precio;
	private Integer	porcentajeDescuento;
	private Long		valorTotal;
	// Relacion
	private String	nombreProducto;
	private String	marcaProducto;
	private Long		precioProducto;
	private Integer	cantidadStockProducto;
	private String	estadoProducto;
	private Integer	porcentajeDescuentoProducto;

	// ----------
	// Getters
	// ----------

	public Long getId() {
		return id;
	}

	public Long getIdVenta() {
		return idVenta;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public Long getPrecio() {
		return precio;
	}

	public Integer getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public Long getValorTotal() {
		return valorTotal;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public String getMarcaProducto() {
		return marcaProducto;
	}

	public Long getPrecioProducto() {
		return precioProducto;
	}

	public Integer getCantidadStockProducto() {
		return cantidadStockProducto;
	}

	public String getEstadoProducto() {
		return estadoProducto;
	}

	public Integer getPorcentajeDescuentoProducto() {
		return porcentajeDescuentoProducto;
	}

}
