package TESTAEV5.Controller;

import org.springframework.beans.factory.annotation.Autowired;
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

import TESTAEV5.Service.ClienteService;


/**
 * @author Usuario
 *
 */
@RestController
@RequestMapping(path = "/data")
@CrossOrigin(origins = "*")
public class ClienteController {
	@Autowired
	ClienteService productoService;
	

	

	/**
	 * @return htmlresponse
	 * 
	 * retorna un html con los atributos del preso seleccionado mediante el id 
	 */
	@GetMapping("/Cliente/{id}")
	private String getById(@PathVariable("id") int id) {
		Cliente producto = productoService.getClienteById(id);
		String htmlresponse = "<html><body><h1>Preso nº "+ producto.getId() +"</h1>"+"<p>" + producto.getMail() + "</p>"+ "<p>" + producto.getNombre() + "</p>"+ "<p>" +  producto.getUsername() + "</p>"+ "<p>" + producto.isActivo() + "</p>" + "</body></html>" ; 
		return htmlresponse;
	}
	
	@GetMapping("/ClienteCheck/{username}/{password}")
	public boolean CheckClientePassword_Username(@RequestBody Cliente cliente , @PathVariable("password") String password , @PathVariable("username") String username) {
		if (cliente.getPassword().equals(password) && cliente.getUsername().equals(username)) {
			return true;
		}else {
			return false;
		}
	
	}
	
	
	

	@DeleteMapping("/DeleteCliente/{id}")
	public void deletePreso(@PathVariable("id") int id) {

	}
	/**
	 * 
	 * 
	 * Mediante un metodo post añade a la base de datos un preso con sus atributos
	 */
	@PostMapping("/AddCliente")
	public void addCliente(@RequestBody Cliente cliente) {
		productoService.NewCliente(cliente);
	}

	@PutMapping("/UpdateCliente/{id}")
	public void updateProducto(@RequestBody Cliente cliente) {
	}
}