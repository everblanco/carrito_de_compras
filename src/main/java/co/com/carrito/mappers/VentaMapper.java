package co.com.carrito.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import co.com.carrito.dto.VentaDTO;
import co.com.carrito.model.Venta;

/**
 * Mappers de Venta (Mapper)
 * 
 *
 */
@Mapper
public interface VentaMapper {
	VentaMapper INSTANCE = Mappers.getMapper(VentaMapper.class);

	// Dto's to Entitys

	/**
	 * convierte de DTO Venta a su entidad
	 * 
	 * @param aVentaDTO
	 * 
	 */
	@Mapping(target = "id", source = "id")
	@Mapping(target = "valor", source = "valor")
	Venta toVenta(VentaDTO aVentaDTO);

	// Entitys to DTO's

	/**
	 * Convierte de Venta a su DTO
	 * 
	 * @param aVenta
	 */
	@InheritInverseConfiguration
	VentaDTO toVentaDTO(Venta aVenta);

}
