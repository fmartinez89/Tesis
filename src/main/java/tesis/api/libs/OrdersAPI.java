package tesis.api.libs;

import java.util.List;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import tesis.environment.Variables;
import tesis.model.Order;
import tesis.model.Product;


public class OrdersAPI {
Response response;
JsonPath jsonPath;	
Order order;
Product product;


@Step
	public void requestOrders() {
		SerenityRest.given()
		.port(80)
		.auth(). preemptive().basic(Variables.clientID, Variables.secret)
		.header("Content-type", "application/json")	
		.when()
		.log().all()
		.get(Variables.apiURL + "orders");
	}

@Step
	public List<Order> getOrders() {
	List<Order> listaOrdenes =  SerenityRest.then()
			.log().all()
			.extract()
            .jsonPath()
            .getList("", Order.class); 
	return listaOrdenes;
}

@Step
	public Order getOrderByID(int orderID) {
	Order order = SerenityRest.given()
	.port(80)
	.auth(). preemptive().basic(Variables.clientID, Variables.secret)
	.header("Content-type", "application/json")	
	.when()
	.log().all()
	.get(Variables.apiURL + "orders" + "/" + orderID)
	.then()
	.log().all()
	.extract()
	.jsonPath()
	.getObject("", Order.class);
	return order;
	
}
	
@Step
public void createOrderRequest(Order order) {
	SerenityRest.given()
	.port(80)
	.auth(). preemptive().basic(Variables.clientID, Variables.secret)
	.header("Content-type", "application/json")
	.body(order)
	.when()
	.log().all()
	.post(Variables.apiURL + "orders");
	}

@Step
public int getStatusCode() {
	return SerenityRest.then().log().all().extract().statusCode();
}

@Step
public String getOrderCostumerName() {
	return SerenityRest.then().extract().jsonPath().getObject("", Order.class).getBillingData().getFirst_name();
}
}


