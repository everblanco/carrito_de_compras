package co.com.carrito.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.carrito.model.Venta;
import co.com.carrito.repository.IVentaRepository;
import co.com.carrito.util.IConstantes;

/**
 * Implementación de la interface de servicio de Venta (Service)
 * 
 *
 */
@Service
public class VentaService {

	private IVentaRepository ventaRepository;

	// Metodos publicos

	/**
	 * Retorna Venta según id
	 * 
	 * @param aId
	 */
	public Venta findById(Long aId) {
		return this.ventaRepository.findById(aId).orElse(null);
	}


	/**
	 * Retorna un listado de todos los registros de Venta
	 * 
	 * @return
	 */
	public List<Venta> findAll() {
		return this.ventaRepository.findAll();
	}

	/**
	 * Creacion Venta
	 * 
	 * @param aVenta
	 * @return
	 */
	@Transactional
	public Venta createVenta(Venta aVenta) {
		validateVenta(aVenta, IConstantes.MODO_INSERCION);
		return this.ventaRepository.save(aVenta);
	}

	/**
	 * Actualiza Venta
	 * 
	 * @param aVenta
	 * @return
	 */
	@Transactional
	public Venta updateVenta(Venta aVenta) {
		validateVenta(aVenta, IConstantes.MODO_EDICION);
		Venta ventaBD = this.ventaRepository.findById(aVenta.getId()).get();
		return this.ventaRepository.save(aVenta);
	}

	/**
	 * Elimina Venta
	 * 
	 * @param aId
	 * @return
	 */
	@Transactional
	public void deleteVenta(Long aId) {
		Venta ventaBD = this.ventaRepository.findById(aId).get();
		this.ventaRepository.deleteById(ventaBD.getId());
	}

	// Metodos privados

	/**
	 * Validaciones de la historia de usuario
	 * 
	 * @param aVenta
	 * @param aModoTransaction
	 */
	private void validateVenta(Venta aVenta, String aModoTransaction) {
		// Nombre mayuscula sostenida

	}

	// inyeccion
	@Autowired
	public void setVentaRepository(IVentaRepository ventaRepository) {
		this.ventaRepository = ventaRepository;
	}

}
