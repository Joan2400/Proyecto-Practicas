package TESTAEV5.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import TESTAEV5.model.Historial_de_Compras;
import TESTAEV5.repository.CustomRepository.CustomHistorialDeCompraRepository;
@Repository
public interface Historial_de_Compras_Repository extends JpaRepository<Historial_de_Compras, Integer>, CustomHistorialDeCompraRepository{

	
	
}