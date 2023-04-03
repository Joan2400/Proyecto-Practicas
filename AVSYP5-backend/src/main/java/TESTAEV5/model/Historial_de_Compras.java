package TESTAEV5.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table (name = "Historial_de_Compras")
public class Historial_de_Compras {

@Id
@GeneratedValue( strategy= GenerationType.AUTO ) 
   private int id;
   @Column
   private Date Fecha;

   @OneToOne
   private Cliente Cliente;
   
   
   @OneToOne
   private Ticket Ticket;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public Date getFecha() {
	return Fecha;
}

public void setFecha(Date fecha) {
	Fecha = fecha;
}

public Cliente getCliente() {
	return Cliente;
}

public void setCliente(Cliente cliente) {
	Cliente = cliente;
}

public Ticket getTicket() {
	return Ticket;
}

public void setTicket(Ticket ticket) {
	Ticket = ticket;
}
   
   
   
}