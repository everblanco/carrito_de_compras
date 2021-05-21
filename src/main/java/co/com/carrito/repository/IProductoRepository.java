package co.com.carrito.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.carrito.model.Producto;

/**
 * Repositorio de Producto (Repository)
 * 
 */
@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {

	public List<Producto> findAllByOrderByNombreAsc();

	/**
	 * Retorna el Page de productos filtrados según los criterios
	 *
	 * @param aNombre
	 * @param pPrecioMinimo
	 * @param aPrecioMaximo
	 * @param aMarca
	 * @param aPageable
	 * @return
	 */
	@Query(" SELECT p FROM Producto p                                       "
			+ "  WHERE 1=1                                                      "
			+ "  AND (UPPER((TRANSLATE(p.nombre, 'áéíóúÁÉÍÓÚ', 'aeiouAEIOU')))  LIKE  UPPER (TRANSLATE(:pNombre, 'áéíóúÁÉÍÓÚ', 'aeiouAEIOU')) OR :pNombre IS NULL)   "
			+ "  AND (p.precio >= :pPrecioMinimo OR :pPrecioMinimo IS NULL)              "
			+ "  AND (p.precio <= :pPrecioMaximo OR :pPrecioMaximo IS NULL)              "
			+ "  AND (UPPER((TRANSLATE(p.marca, 'áéíóúÁÉÍÓÚ', 'aeiouAEIOU')))  LIKE  UPPER (TRANSLATE(:pMarca, 'áéíóúÁÉÍÓÚ', 'aeiouAEIOU')) OR :pMarca IS NULL)      ")
	public Page<Producto> findAll(@Param("pNombre") String aNombre, @Param("pPrecioMinimo") Long pPrecioMinimo,
			@Param("pPrecioMaximo") Long aPrecioMaximo, @Param("pMarca") String aMarca, Pageable aPageable);

}
