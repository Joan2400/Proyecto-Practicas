package TESTAEV5.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import TESTAEV5.model.Cliente;

import TESTAEV5.repository.ClienteRepository;


/**
 * @author Usuario
 *
 */
@Service
public class ClienteService {
	@Autowired
	ClienteRepository repository;
	
	/**
	 * @return repository.findById(id).get()
	 * retorna un preso en formato json con todos sus atributos correspondietes
	 */
	public Cliente getClienteById(int id) {
		return repository.findById(id).get();
	}
	



	
	/**
	 * @return presos
	 * retorna una lista en formato json de todos los presos y sus correspondientes atributos
	 */
	public List<Cliente> getAllClientes() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		repository.findAll().forEach(clientes1 -> clientes.add(clientes1));
		return clientes;
	}
	
	/**
	 * 
	 * Guarda un preso
	 */
	public void NewCliente(Cliente cliente) {
		repository.save(cliente);
	}

	public void deletePresoById(int id) {
	}
}