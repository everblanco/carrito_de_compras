package co.com.carrito.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

/**
 * Clase controladora de Carrito (Controller)
 * 
 *
 *
 */
@RestController
@RequestMapping("/api/carrito")
public class CarritoController {

	private ProductoService		productoService;
	private List<ProductoDTO>	productoDtoList;

	/**
	 * Retorna un listado de todos los registros de Producto
	 * 
	 * @return
	 */
	@GetMapping("/all")
	public ResponseEntity<List<ProductoDTO>> findAll() {
		return new ResponseEntity<>(this.productoDtoList, HttpStatus.OK);
	}

	/**
	 * Retorna Producto según id
	 * 
	 * @param aId
	 * @return
	 */
	@GetMapping("/id/{id}")
	public ResponseEntity<ProductoDTO> findById(@PathVariable(value = "id") Long aId) {
		Producto producto = this.productoService.findById(aId);
		if (producto == null) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(ProductoMapper.INSTANCE.toProductoDTO(producto), HttpStatus.OK);
	}

	/**
	 * Agrega un Producto al carrito
	 * 
	 * @param aProductoDTO
	 * @return
	 */
	@PostMapping("/add")
	public ResponseEntity<ProductoDTO> addCarrito(@Valid @RequestBody ProductoDTO aProductoDTO) {
		if (this.productoDtoList == null) {
			this.productoDtoList = new ArrayList<ProductoDTO>();
		}
		this.productoDtoList.add(aProductoDTO);
		return new ResponseEntity<>(aProductoDTO, HttpStatus.CREATED);
	}

	/**
	 * Guarda Producto
	 * 
	 * @param aProductoDTO
	 * @return
	 */
	@PostMapping()
	public ResponseEntity<ProductoDTO> createCarrito(@Valid @RequestBody ProductoDTO aProductoDTO) {
		if (this.productoDtoList == null) {
			this.productoDtoList = new ArrayList<ProductoDTO>();
		}
		this.productoDtoList.add(aProductoDTO);
		return new ResponseEntity<>(aProductoDTO, HttpStatus.CREATED);
	}

	/**
	 * Actualiza Producto
	 * 
	 * @param aProductoDTO
	 * @return
	 */
	@PutMapping
	public ResponseEntity<ProductoDTO> updateCarrito(@Valid @RequestBody ProductoDTO aProductoDTO) {
		if (aProductoDTO.getId() == null)
			return new ResponseEntity<>(null, HttpStatus.CONFLICT);
		Producto productoUpdated = this.productoService.updateProducto(ProductoMapper.INSTANCE.toProducto(aProductoDTO));
		if (productoUpdated == null) {
			return new ResponseEntity<>(null, HttpStatus.CONFLICT);
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
	public ResponseEntity<Boolean> deleteCarrito(@PathVariable(value = "id") Long aId) {
		this.productoService.deleteProducto(aId);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	/**
	 * Elimina productos del carrito
	 * 
	 * @param aId
	 * @return
	 */
	@DeleteMapping("/remove")
	public ResponseEntity<Boolean> removeCarrito() {
		this.productoDtoList = new ArrayList<ProductoDTO>();
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	// inyeccion
	@Autowired
	public void setProductoService(ProductoService productoService) {
		this.productoService = productoService;
	}

	/**
	 * Endpoints --------------
	 */
//	http://localhost:8080/carrito/api/carrito/add  		->POST
//	 {
//     "id": 2,
//     "nombre": "Huawei P40 Lite 128gb",
//     "marca": "Huawey",
//     "precio": 1249900,
//     "cantidadStock": 95,
//     "estado": "Nuevo",
//     "porcentajeDescuento": 30
//	 }
//
//	http://localhost:8080/carrito/api/carrito/all  			->GET
//
//	http://localhost:8080/carrito/api/carrito/remove  	->DELETE

}
