package co.com.carrito.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import co.com.carrito.dto.ProductoDTO;
import co.com.carrito.model.Producto;

/**
 * Mappers de Producto (Mapper)
 * 
 *
 */
@Mapper
public interface ProductoMapper {
	ProductoMapper INSTANCE = Mappers.getMapper(ProductoMapper.class);

	// Dto's to Entitys

	/**
	 * convierte de DTO Producto a su entidad
	 * 
	 * @param aProductoDTO
	 * 
	 */
	@Mapping(target = "id", source = "id")
	@Mapping(target = "nombre", source = "nombre")
	@Mapping(target = "marca", source = "marca")
	@Mapping(target = "precio", source = "precio")
	@Mapping(target = "cantidadStock", source = "cantidadStock")
	@Mapping(target = "estado", source = "estado")
	@Mapping(target = "porcentajeDescuento", source = "porcentajeDescuento")
	Producto toProducto(ProductoDTO aProductoDTO);

	// Entitys to DTO's

	/**
	 * Convierte de Producto a su DTO
	 * 
	 * @param aProducto
	 */
	@InheritInverseConfiguration
	ProductoDTO toProductoDTO(Producto aProducto);

}
