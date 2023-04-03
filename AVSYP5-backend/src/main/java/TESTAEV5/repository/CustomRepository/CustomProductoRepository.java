package TESTAEV5.repository.CustomRepository;

import java.util.List;


import TESTAEV5.model.Producto;
import TESTAEV5.model.ProductoPage;
import TESTAEV5.model.ProductoSearchCriteria;



public interface CustomProductoRepository{

	List<Producto> findAllWithFilters(ProductoPage productoPage, ProductoSearchCriteria productosearchCriteria);
	
	
	

}