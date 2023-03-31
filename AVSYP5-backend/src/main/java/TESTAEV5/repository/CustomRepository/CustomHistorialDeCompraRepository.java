package TESTAEV5.repository.CustomRepository;

import java.util.List;



import TESTAEV5.model.Cliente;
import TESTAEV5.model.HistorialDeCompraSearchCriteria;
import TESTAEV5.model.HistorialDeComprasPage;
import TESTAEV5.model.Historial_de_Compras;




public interface CustomHistorialDeCompraRepository{



	List<Historial_de_Compras> findAllWithFilters(HistorialDeComprasPage HistorialPage,HistorialDeCompraSearchCriteria HistorialSearchCriteria, Cliente id);
	
	
	

}