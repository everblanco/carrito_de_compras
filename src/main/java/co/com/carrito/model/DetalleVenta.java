package co.com.carrito.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase para el manejo de DetalleVenta (Entidad)
 * 
 *
 */
@Entity
@Setter
@NoArgsConstructor
@Table(name = "DETALLE_VENTA")
public class DetalleVenta implements Serializable {

	private static final long serialVersionUID = -868212921779464777L;

	// Atributos
	private Long		id;
	private Long		idVenta;
	private Long		idProducto;
	private Integer	cantidad;
	private Long		precio;
	private Integer	porcentajeDescuento;
	private Long		valorTotal;
	// Relacion
	private Venta			venta;
	private Producto	producto;

	// ----------
	// Getters
	// ----------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	@Column(name = "ID_VENTA", nullable = false)
	public Long getIdVenta() {
		return idVenta;
	}

	@Column(name = "ID_PRODUCTO", nullable = false)
	public Long getIdProducto() {
		return idProducto;
	}

	@Column(name = "CANTIDAD", nullable = false)
	public Integer getCantidad() {
		return cantidad;
	}

	@Column(name = "PRECIO", nullable = false)
	public Long getPrecio() {
		return precio;
	}

	@Column(name = "PORCENTAJE_DESCUENTO", nullable = false)
	public Integer getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	@Column(name = "VALOR_TOTAL", nullable = false)
	public Long getValorTotal() {
		return valorTotal;
	}

	// ----------
	// ManyToOne
	// ----------

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_VENTA", insertable = false, updatable = false)
	public Venta getVenta() {
		return venta;
	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PRODUCTO", insertable = false, updatable = false)
	public Producto getProducto() {
		return producto;
	}

}
