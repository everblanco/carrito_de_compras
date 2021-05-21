package co.com.carrito.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.carrito.model.Venta;

/**
 * Repositorio de Venta (Repository)
 * 
 */
@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long> {

	public List<Venta> findAll();

}
