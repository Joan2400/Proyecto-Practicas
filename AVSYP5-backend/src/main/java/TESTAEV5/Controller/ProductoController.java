package TESTAEV5.Controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import TESTAEV5.model.Producto;
import TESTAEV5.model.ProductoPage;
import TESTAEV5.model.ProductoSearchCriteria;
import TESTAEV5.Service.ProductoService;

/**
 * @author Usuario
 *
 */
@RestController
@RequestMapping(path = "/data")
@CrossOrigin(origins = "*")
public class ProductoController {
	@Autowired
	ProductoService productoService;
	

	

	/**
	 * @return htmlresponse
	 * 
	 * retorna un string con la forma de un html que contiene la lista de los alias de los presos
	 */
	@GetMapping("/Producto/showAll")
	public String getAllEmployees() {
		String htmlresponse ="<html><body><h1>Lista de Productos</h1></body></html>" ; 
		List<String> list = new ArrayList<String>();
		List<Producto> arrayJsonPresos = productoService.getAllProductos();
		for (Producto p : arrayJsonPresos) {
			
			list.add("<p>" + p.getId() + "</p>" + "<p>" + p.getDescripcion() + "</p>" + "<p>" + p.getNombre() + "</p>" + "<p>" + p.getPrecio() + "</p>" + "<p>" + p.isActivo() + "</p>");
			htmlresponse = "<html><body><h1>Lista de Productos</h1>" + list + "</body></html>" ; 

		}
		System.out.println(list);
		return htmlresponse;
	}

	/**
	 * @return htmlresponse
	 * 
	 * retorna un html con los atributos del preso seleccionado mediante el id 
	 */
	@GetMapping("/Producto/{id}")
	private String getById(@PathVariable("id") int id) {
		Producto producto = productoService.getProductoById(id);
		String htmlresponse = "<html><body><h1>Preso nº "+ producto.getId() +"</h1>"+"<p>" + producto.getDescripcion() + "</p>"+ "<p>" + producto.getNombre() + "</p>"+ "<p>" +  producto.getPrecio() + "</p>"+ "<p>" + producto.isActivo() + "</p>" + "</body></html>" ; 
		return htmlresponse;
	}
	
	
	
	@GetMapping("/getAllPaginated/{limit}/{offset}")
	public ResponseEntity<List<Producto>> getAllPaginatedProducts(ProductoPage productoPage, ProductoSearchCriteria productoSearchCriteria){
		return new ResponseEntity<>(productoService.getAllPaginated(productoPage, productoSearchCriteria),
			HttpStatus.OK	);
		
	}
	

	@DeleteMapping("/DeleteProducto/{id}")
	public void deletePreso(@PathVariable("id") int id) {


	}
	/**
	 * 
	 * 
	 * Mediante un metodo post añade a la base de datos un preso con sus atributos
	 */
	@PostMapping("/AddProducto")
	public void addProducto(@RequestBody Producto producto) {
		productoService.NewProducto(producto);
	}

	@PutMapping("/UpdateProducto/{id}")
	public void updateProducto(@RequestBody Producto producto) {
	}
}