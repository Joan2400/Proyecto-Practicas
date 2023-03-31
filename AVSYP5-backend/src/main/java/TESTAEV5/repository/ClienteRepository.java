package TESTAEV5.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import TESTAEV5.model.Cliente;



@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> 
{
}