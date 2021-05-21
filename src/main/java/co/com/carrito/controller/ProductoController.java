package co.com.carrito.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.carrito.dto.ProductoDTO;
import co.com.carrito.mappers.ProductoMapper;
import co.com.carrito.model.Producto;
import co.com.carrito.service.ProductoService;
import co.com.carrito.util.IConstantes;
import javassist.NotFoundException;

/**
 * Clase controladora de Producto (Controller)
 * 
 */
@RestController
@RequestMapping("/api/producto")
public class ProductoController {

	private static final Logger	LOG	= Logger.getLogger(IConstantes.NOMBRE_PROYECTO);
	private ProductoService			productoService;

	@GetMapping("/todos")
	public Page<Producto> obtenerTodos(@Param("nombre") String nombre, @Param("precioMinimo") Long precioMinimo,
			@Param("precioMaximo") Long precioMaximo, @Param("marca") String marca,
			@PageableDefault(size = 10, page = 0) Pageable pageable) {
		Page<Producto> productoList = null;
		try {
			productoList = this.productoService.obtenerTodos(nombre, precioMinimo, precioMaximo, marca, pageable);

			if (productoList.isEmpty()) {
				throw new NotFoundException("No encontrado");
			}

		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return productoList;
	}

	/**
	 * Retorna un listado de todos los registros de Producto
	 * 
	 * @return
	 */
	@GetMapping("/all")
	public ResponseEntity<List<ProductoDTO>> findAll() {
		List<Producto> productoList = null;
		try {
			this.productoService.findAll();
			if (productoList == null || productoList.isEmpty()) {
				return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return new ResponseEntity<>(
				productoList.stream().map(ProductoMapper.INSTANCE::toProductoDTO).collect(Collectors.toList()), HttpStatus.OK);
	}

	/**
	 * Retorna Producto según id
	 * 
	 * @param aId
	 * @return
	 */
	@GetMapping("/id/{id}")
	public ResponseEntity<ProductoDTO> findById(@PathVariable(value = "id") Long aId) {
		Producto producto = null;
		try {
			producto = this.productoService.findById(aId);
			if (producto == null) {
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}

		return new ResponseEntity<>(ProductoMapper.INSTANCE.toProductoDTO(producto), HttpStatus.OK);
	}

	/**
	 * Guarda Producto
	 * 
	 * @param aProductoDTO
	 * @return
	 */
	@PostMapping
	public ResponseEntity<ProductoDTO> createProducto(@Valid @RequestBody ProductoDTO aProductoDTO) {
		Producto productoSaved = null;
		try {
			productoSaved = this.productoService.createProducto(ProductoMapper.INSTANCE.toProducto(aProductoDTO));
			if (productoSaved == null) {
				return new ResponseEntity<>(null, HttpStatus.CONFLICT);
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return new ResponseEntity<>(ProductoMapper.INSTANCE.toProductoDTO(productoSaved), HttpStatus.CREATED);
	}

	/**
	 * Actualiza Producto
	 * 
	 * @param aProductoDTO
	 * @return
	 */
	@PutMapping
	public ResponseEntity<ProductoDTO> updateProducto(@Valid @RequestBody ProductoDTO aProductoDTO) {
		Producto productoUpdated = null;
		try {
			if (aProductoDTO.getId() == null)
				return new ResponseEntity<>(null, HttpStatus.CONFLICT);
			productoUpdated = this.productoService.updateProducto(ProductoMapper.INSTANCE.toProducto(aProductoDTO));
			if (productoUpdated == null) {
				return new ResponseEntity<>(null, HttpStatus.CONFLICT);
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}

		return new ResponseEntity<>(ProductoMapper.INSTANCE.toProductoDTO(productoUpdated), HttpStatus.OK);
	}

	/**
	 * Elimina Producto
	 * 
	 * @param aId
	 * @return
	 */
	@DeleteMapping("/id/{id}")
	public ResponseEntity<Boolean> deleteProducto(@PathVariable(value = "id") Long aId) {
		try {
			this.productoService.deleteProducto(aId);
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	// inyeccion
	@Autowired
	public void setProductoService(ProductoService productoService) {
		this.productoService = productoService;
	}

	/**
	 * Endpoints
	 * --------------
	 */
//	  http://localhost:8080/carrito/api/carrito/all 		->GET
//	  
//	  http://localhost:8080/carrito/api/carrito 				->POST 
//	  	{ 
//	  		"nombre": "Huawei P40 Lite 128gb", 
//	  		"marca": "Huawey", 
//	  		"precio": 1249900, 
//	  		"cantidadStock": 95, 
//	  		"estado": "Nuevo", 
//	  		"porcentajeDescuento": 30 
//	  	 }
//
//	  http://localhost:8080/carrito/api/carrito 				->PUT 
//	  	{ 
//	  		"id":1, 
//	  		"nombre": "Huawei P40 Lite 128gb", 
//	  		"marca": "Huawey", "precio": 1249900, 
//	  		"cantidadStock": 95,
//	  		"estado": "Nuevo", 
//	  		"porcentajeDescuento": 30 
//	  	}
//
//	  http://localhost:8080/carrito/api/carrito/id/{id} 	->DELETE
}
