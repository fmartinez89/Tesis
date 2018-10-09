package tesis.model;

import java.util.List;

import tesis.rest.model.Billing;
import tesis.rest.model.Shipping;

public class Order {
Shipping shipping;
Billing billing;
public Shipping getShippingData() {
	return shipping;
}
public void setShippingData(Shipping shippingData) {
	this.shipping = shippingData;
}
public Billing getBillingData() {
	return billing;
}
public void setBillingData(Billing billingData) {
	this.billing = billingData;
}
List<Product> line_items;
private int id;
private int number;
private String status;

public List<Product> getLine_items() {
	return line_items;
}
public void setLine_items(List<Product> line_items) {
	this.line_items = line_items;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getNumber() {
	return number;
}
public void setNumber(int number) {
	this.number = number;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}


}
