package tesis.model;

import tesis.rest.model.Billing;
import tesis.rest.model.Shipping;

public class Customer {
private String nombre;
private String apellido;
private String telefono;
private String email;
private String notas;
private Billing billing;
private Shipping shipping;


public String getNombre() {
	return nombre;
}
public Billing getBilling() {
	return billing;
}
public void setBilling(Billing billing) {
	this.billing = billing;
}
public Shipping getShipping() {
	return shipping;
}
public void setShipping(Shipping shipping) {
	this.shipping = shipping;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}


public String getTelefono() {
	return telefono;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getNotas() {
	return notas;
}
public void setNotas(String notas) {
	this.notas = notas;
}

}
