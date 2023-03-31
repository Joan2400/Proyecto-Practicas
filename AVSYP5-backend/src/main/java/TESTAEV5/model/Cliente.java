package TESTAEV5.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class Cliente {

@Id
@GeneratedValue( strategy= GenerationType.AUTO ) 
public int id;
   @Column
   public String nombre;
   @Column
   public String mail;
   @Column
   public String password;
   @Column
   public boolean activo;
   @Column
   public String username;
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
public String getMail() {
	return mail;
}
public void setMail(String mail) {
	this.mail = mail;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public boolean isActivo() {
	return activo;
}
public void setActivo(boolean activo) {
	this.activo = activo;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}

   
   
   
}