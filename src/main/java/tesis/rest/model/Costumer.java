package tesis.rest.model;

public class Costumer {
private String email;
private String first_name;
private String last_name;
Billing billing;
Shipping shipping;

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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getFirst_name() {
	return first_name;
}
public void setFirst_name(String first_name) {
	this.first_name = first_name;
}
public String getLast_name() {
	return last_name;
}
public void setLast_name(String last_name) {
	this.last_name = last_name;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
private String username;

public String generateRandomEmail() {
	return new StringBuilder("emailTest").append(System.currentTimeMillis()).append("@email.com").toString();

	}
}
