package TESTAEV5.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import TESTAEV5.model.Producto;
import TESTAEV5.repository.CustomRepository.CustomProductoRepository;
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>, CustomProductoRepository  {
	
}