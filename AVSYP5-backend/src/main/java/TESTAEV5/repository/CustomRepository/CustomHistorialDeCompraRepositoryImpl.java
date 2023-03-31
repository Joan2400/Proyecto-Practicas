package TESTAEV5.repository.CustomRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import TESTAEV5.model.Cliente;
import TESTAEV5.model.HistorialDeCompraSearchCriteria;
import TESTAEV5.model.HistorialDeComprasPage;
import TESTAEV5.model.Historial_de_Compras;



public class CustomHistorialDeCompraRepositoryImpl implements CustomHistorialDeCompraRepository{
	@PersistenceContext
	private  EntityManager entityManager;

	
	public List<Historial_de_Compras> findAllWithFilters(HistorialDeComprasPage HistorialPage , HistorialDeCompraSearchCriteria HistorialSearchCriteria , Cliente id){
		
		CriteriaBuilder criteriaBuilder  = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<Historial_de_Compras> criteriaQuery = criteriaBuilder.createQuery(Historial_de_Compras.class);
		Root<Historial_de_Compras> historialDeComprasRoot = criteriaQuery.from(Historial_de_Compras.class);
		TypedQuery<Historial_de_Compras> typedQuery = entityManager.createQuery(criteriaQuery);
		criteriaQuery.where(criteriaBuilder.equal(historialDeComprasRoot.get("cliente").get("id"), id));
		typedQuery.setFirstResult(HistorialPage.getOffset());
		typedQuery.setMaxResults(HistorialSearchCriteria.getLimit());
		
		
		criteriaQuery.select(historialDeComprasRoot);
		

		
		return typedQuery.getResultList();
	}








	

	



}