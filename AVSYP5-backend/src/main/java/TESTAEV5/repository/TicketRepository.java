package TESTAEV5.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import TESTAEV5.model.Ticket;
@Repository
public interface TicketRepository extends CrudRepository<Ticket, Integer>  {
}