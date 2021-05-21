package co.com.carrito.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.carrito.model.DetalleVenta;
import co.com.carrito.repository.IDetalleVentaRepository;
import co.com.carrito.util.IConstantes;

/**
 * Implementación de la interface de servicio de DetalleVenta (Service)
 * 
 *
 */
@Service
public class DetalleVentaService {

	private IDetalleVentaRepository detalleVentaRepository;

	// Metodos publicos

	/**
	 * Retorna DetalleVenta según id
	 * 
	 * @param aId
	 */
	public DetalleVenta findById(Long aId) {
		return this.detalleVentaRepository.findById(aId).orElse(null);
	}

	/**
	 * Retorna un listado de todos los registros de DetalleVenta
	 * 
	 * @return
	 */
	public List<DetalleVenta> findAll() {
		return this.detalleVentaRepository.findAll();
	}

	/**
	 * Creacion DetalleVenta
	 * 
	 * @param aDetalleVenta
	 * @return
	 */
	@Transactional
	public DetalleVenta createDetalleVenta(DetalleVenta aDetalleVenta) {
		validateDetalleVenta(aDetalleVenta, IConstantes.MODO_INSERCION);
		return this.detalleVentaRepository.save(aDetalleVenta);
	}

	/**
	 * Actualiza DetalleVenta
	 * 
	 * @param aDetalleVenta
	 * @return
	 */
	@Transactional
	public DetalleVenta updateDetalleVenta(DetalleVenta aDetalleVenta) {
		validateDetalleVenta(aDetalleVenta, IConstantes.MODO_EDICION);
		DetalleVenta detalleVentaBD = this.detalleVentaRepository.findById(aDetalleVenta.getId()).get();
		return this.detalleVentaRepository.save(aDetalleVenta);
	}

	/**
	 * Elimina DetalleVenta
	 * 
	 * @param aId
	 * @return
	 */
	@Transactional
	public void deleteDetalleVenta(Long aId) {
		DetalleVenta detalleVentaBD = this.detalleVentaRepository.findById(aId).get();
		this.detalleVentaRepository.deleteById(detalleVentaBD.getId());
	}

	// Metodos privados

	/**
	 * Validaciones de la historia de usuario
	 * 
	 * @param aDetalleVenta
	 * @param aModoTransaction
	 */
	private void validateDetalleVenta(DetalleVenta aDetalleVenta, String aModoTransaction) {
		// Validaciones

	}

	// inyeccion
	@Autowired
	public void setDetalleVentaRepository(IDetalleVentaRepository detalleVentaRepository) {
		this.detalleVentaRepository = detalleVentaRepository;
	}

}
