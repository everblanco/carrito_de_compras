package co.com.carrito.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import co.com.carrito.dto.DetalleVentaDTO;
import co.com.carrito.model.DetalleVenta;

/**
 * Mappers de DetalleVenta (Mapper)
 * 
 *
 */
@Mapper
public interface DetalleVentaMapper {
	DetalleVentaMapper INSTANCE = Mappers.getMapper(DetalleVentaMapper.class);

	// Dto's to Entitys

	/**
	 * convierte de DTO DetalleVenta a su entidad
	 * 
	 * @param aDetalleVentaDTO
	 * 
	 */
	@Mapping(target = "id", source = "id")
	@Mapping(target = "idVenta", source = "idVenta")
	@Mapping(target = "idProducto", source = "idProducto")
	@Mapping(target = "cantidad", source = "cantidad")
	@Mapping(target = "precio", source = "precio")
	@Mapping(target = "porcentajeDescuento", source = "porcentajeDescuento")
	@Mapping(target = "valorTotal", source = "valorTotal")
	DetalleVenta toDetalleVenta(DetalleVentaDTO aDetalleVentaDTO);

	// Entitys to DTO's

	/**
	 * Convierte de DetalleVenta a su DTO
	 * 
	 * @param aDetalleVenta
	 */
	@InheritInverseConfiguration
	@Mapping(target = "nombreProducto", source = "producto.nombre")
	@Mapping(target = "marcaProducto", source = "producto.marca")
	@Mapping(target = "precioProducto", source = "producto.precio")
	@Mapping(target = "cantidadStockProducto", source = "producto.cantidadStock")
	@Mapping(target = "estadoProducto", source = "producto.estado")
	@Mapping(target = "porcentajeDescuentoProducto", source = "producto.porcentajeDescuento")
	DetalleVentaDTO toDetalleVentaDTO(DetalleVenta aDetalleVenta);

}
