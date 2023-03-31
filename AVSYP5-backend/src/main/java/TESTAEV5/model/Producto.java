package TESTAEV5.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "producto")
public class Producto {

@Id
@GeneratedValue( strategy= GenerationType.AUTO ) 
   private int id;
   @Column
   private String nombre;
   @Column
   private String descripcion;
   @Column
   private String precio;
   @Column
   private boolean activo;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public String getPrecio() {
	return precio;
}
public void setPrecio(String precio) {
	this.precio = precio;
}
public boolean isActivo() {
	return activo;
}
public void setActivo(boolean activo) {
	this.activo = activo;
}
 
   
   
}