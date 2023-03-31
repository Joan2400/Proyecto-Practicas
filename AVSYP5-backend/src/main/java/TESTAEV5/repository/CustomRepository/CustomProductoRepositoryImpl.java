package TESTAEV5.repository.CustomRepository;


import java.util.List;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;



import TESTAEV5.model.Producto;
import TESTAEV5.model.ProductoPage;
import TESTAEV5.model.ProductoSearchCriteria;

public class CustomProductoRepositoryImpl implements CustomProductoRepository{
	@PersistenceContext
	private  EntityManager entityManager;


	
	public List<Producto> findAllWithFilters(ProductoPage productoPage , ProductoSearchCriteria productoSearchCriteria){
		
		CriteriaBuilder criteriaBuilder  = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Producto> criteriaQuery = criteriaBuilder.createQuery(Producto.class);
		Root<Producto> productoRoot = criteriaQuery.from(Producto.class);
		TypedQuery<Producto> typedQuery = entityManager.createQuery(criteriaQuery);
		
		
		typedQuery.setFirstResult(productoPage.getOffset());
		typedQuery.setMaxResults(productoPage.getLimit());
		
		criteriaQuery.select(productoRoot);
		

		
		return typedQuery.getResultList();
	}









	

	



}