package TESTAEV5.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Ticket {

	@Id
	@GeneratedValue( strategy=GenerationType.AUTO )
	private int id;

	@ManyToMany(targetEntity=Producto.class)
	private List<Producto> ListaProductos;

	
	@OneToOne
	private Historial_de_Compras Historial_de_Compras;
	
	public List<Producto> getListaProductos() {
		return ListaProductos;
	}

	public void setListaProductos(List<Producto> listaProductos) {
		ListaProductos = listaProductos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Historial_de_Compras getHistorial_de_Compras() {
		return Historial_de_Compras;
	}

	public void setHistorial_de_Compras(Historial_de_Compras historial_de_Compras) {
		Historial_de_Compras = historial_de_Compras;
	}

}