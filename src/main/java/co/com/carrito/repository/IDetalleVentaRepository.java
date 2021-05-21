package co.com.carrito.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.carrito.model.DetalleVenta;

/**
 * Repositorio de DetalleVenta (Repository)
 * 
 */
@Repository
public interface IDetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {

	public List<DetalleVenta> findAll();

}
