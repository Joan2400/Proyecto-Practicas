package TESTAEV5.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import TESTAEV5.model.Producto;
import TESTAEV5.model.ProductoPage;
import TESTAEV5.model.ProductoSearchCriteria;
import TESTAEV5.repository.ProductoRepository;

/**
 * @author Usuario
 *
 */
@Service
public class ProductoService {


	
private final ProductoRepository repositorio ; 

	public ProductoService(ProductoRepository repositorio) {
	this.repositorio = repositorio;
}

	/**
	 * 
	 * @return repository.findById(id).get()
	 * retorna un preso en formato json con todos sus atributos correspondietes
	 */
	public Producto getProductoById(int id) {
		return repositorio.findById(id).get();
	}

	/**
	 * @return presos
	 * retorna una lista en formato json de todos los presos y sus correspondientes atributos
	 */
	public List<Producto> getAllProductos() {
		List<Producto> producto = new ArrayList<Producto>();
		repositorio.findAll().forEach(productos1 -> producto.add(productos1));
		return producto;
	}
	
	
	public List<Producto> getAllPaginated(ProductoPage productoPage , ProductoSearchCriteria productosearchCriteria ){
		
		return repositorio.findAllWithFilters(productoPage, productosearchCriteria);
	}
	
	
	
	/**
	 * 
	 * Guarda un preso
	 */
	public void NewProducto(Producto producto) {
		repositorio.save(producto);
	}

	public void deletePresoById(int id) {
	}
	
	public void GetAllProductsFromTicket(int id) {
	}

	public Object getAllPaginated(int limit, int offset) {
		// TODO Auto-generated method stub
		return null;
	}
	
}