package TESTAEV5.Service;


import java.util.List;
import org.springframework.stereotype.Service;

import TESTAEV5.model.Cliente;
import TESTAEV5.model.HistorialDeCompraSearchCriteria;
import TESTAEV5.model.HistorialDeComprasPage;
import TESTAEV5.model.Historial_de_Compras;

import TESTAEV5.repository.Historial_de_Compras_Repository;
;

/**
 * @author Usuario
 *
 */
@Service
public class HistorialDeCompraService {


	
private final Historial_de_Compras_Repository repositorio ; 

	public HistorialDeCompraService(Historial_de_Compras_Repository repositorio) {
	this.repositorio = repositorio;
}

	/**
	 * 
	 * @return repository.findById(id).get()
	 * retorna un preso en formato json con todos sus atributos correspondietes
	 */
	public Historial_de_Compras getHistorialById(int id) {
		return repositorio.findById(id).get();
	}

	/**
	 * @return presos
	 * retorna una lista en formato json de todos los presos y sus correspondientes atributos
	 */
	public List<Historial_de_Compras> GetAllByClientPaginated(Cliente ClienteID , HistorialDeComprasPage HistorialPage , HistorialDeCompraSearchCriteria HistorialsearchCriteria) {
		return repositorio.findAllWithFilters(HistorialPage, HistorialsearchCriteria , ClienteID );
	}
	
	
	
	
	/**
	 * 
	 * Guarda un preso
	 */
	public void NewPurchase( Historial_de_Compras Purchase) {
		repositorio.save(Purchase);
	}

	
	public void GetAllProductsFromTicket(int id) {
	}

	
	
}