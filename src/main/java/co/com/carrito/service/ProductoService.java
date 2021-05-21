package co.com.carrito.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import co.com.carrito.model.Producto;
import co.com.carrito.repository.IProductoRepository;
import co.com.carrito.util.IConstantes;

/**
 * Implementación de la interface de servicio de Producto (Service)
 * 
 *
 */
@Service
public class ProductoService {

	private IProductoRepository productoRepository;

	// Metodos publicos

	/**
	 * Retorna Producto según id
	 * 
	 * @param aId
	 */
	public Producto findById(Long aId) {
		return this.productoRepository.findById(aId).orElse(null);
	}

	/**
	 * Retorna un Page de registros de Producto
	 * 
	 * @return
	 */
	public Page<Producto> obtenerTodos(String nombre, Long precioMinimo, Long precioMaximo, String marca,
			Pageable pageable) {
		nombre = (nombre != null) ? "%" + nombre + "%" : null;
		marca = (marca != null) ? "%" + marca + "%" : null;
		return this.productoRepository.findAll(nombre, precioMinimo, precioMaximo, marca, pageable);
	}

	/**
	 * Retorna un listado de todos los registros de Producto
	 * 
	 * @return
	 */
	public List<Producto> findAll() {
		return this.productoRepository.findAllByOrderByNombreAsc();
	}

	/**
	 * Creacion Producto
	 * 
	 * @param aProducto
	 * @return
	 */
	@Transactional
	public Producto createProducto(Producto aProducto) {
		validateProducto(aProducto, IConstantes.MODO_INSERCION);
		return this.productoRepository.save(aProducto);
	}

	/**
	 * Actualiza Producto
	 * 
	 * @param aProducto
	 * @return
	 */
	@Transactional
	public Producto updateProducto(Producto aProducto) {
		validateProducto(aProducto, IConstantes.MODO_EDICION);
		Producto productoBD = this.productoRepository.findById(aProducto.getId()).get();
		return this.productoRepository.save(aProducto);
	}

	/**
	 * Elimina Producto
	 * 
	 * @param aId
	 * @return
	 */
	@Transactional
	public void deleteProducto(Long aId) {
		Producto productoBD = this.productoRepository.findById(aId).get();
		this.productoRepository.deleteById(productoBD.getId());
	}

	// Metodos privados

	/**
	 * Validaciones de la historia de usuario
	 * 
	 * @param aProducto
	 * @param aModoTransaction
	 */
	private void validateProducto(Producto aProducto, String aModoTransaction) {
		// Nombre mayuscula sostenida
		aProducto.setNombre(aProducto.getNombre().trim().toUpperCase());

	}

	// inyeccion
	@Autowired
	public void setProductoRepository(IProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}

}
