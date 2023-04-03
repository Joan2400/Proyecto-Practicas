package TESTAEV5.Controller;


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

import TESTAEV5.model.Cliente;
import TESTAEV5.model.HistorialDeCompraSearchCriteria;
import TESTAEV5.model.HistorialDeComprasPage;
import TESTAEV5.model.Historial_de_Compras;
import TESTAEV5.model.Producto;

import TESTAEV5.Service.HistorialDeCompraService;


/**
 * @author Usuario
 *
 */
@RestController
@RequestMapping(path = "/data")
@CrossOrigin(origins = "*")
public class HistorialController {
	@Autowired
	HistorialDeCompraService HistorialService;
	

	

	

	/**
	 * @return htmlresponse
	 * 
	 * retorna un html con los atributos del preso seleccionado mediante el id 
	 */
	@GetMapping("/Historial/{id}")
	private String getById(@PathVariable("id") int id) {
		Historial_de_Compras Historial = HistorialService.getHistorialById(id);
		String htmlresponse = "<html><body><h1>Preso nº "+ Historial.getId() +"</h1>"+"<p>" + Historial.getFecha() + "</p>"+ "<p>" + Historial.getCliente().getId() + "</p>"+ "<p>" +  Historial.getTicket().getId() + "</p>"+ "</body></html>" ; 
		return htmlresponse;
	}
	
	
	
	@GetMapping("/getAllClientPaginated/{limit}/{offset}")
	public ResponseEntity<List<Historial_de_Compras>> getAllClientPaginated(Cliente ClienteID , HistorialDeComprasPage HistorialPage , HistorialDeCompraSearchCriteria HistorialsearchCriteria){
		return new ResponseEntity<>(HistorialService.GetAllByClientPaginated( ClienteID, HistorialPage, HistorialsearchCriteria ),
			HttpStatus.OK	);
		
	}
	

	@DeleteMapping("/DeleteHistorial/{id}")
	public void deletePreso(@PathVariable("id") int id) {

	}
	/**
	 * 
	 * 
	 * Mediante un metodo post añade a la base de datos un preso con sus atributos
	 */
	@PostMapping("/AddHistorial")
	public void addProducto(@RequestBody Historial_de_Compras Historial) {
		HistorialService.NewPurchase(Historial);
	}

	@PutMapping("/UpdateHistorial/{id}")
	public void updateProducto(@RequestBody Producto producto) {
	}
}