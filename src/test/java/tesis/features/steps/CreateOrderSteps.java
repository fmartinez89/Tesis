package tesis.features.steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import tesis.api.libs.OrdersAPI;
import tesis.model.Order;
import tesis.model.Product;
import tesis.rest.model.Billing;
import tesis.rest.model.Shipping;

public class CreateOrderSteps extends BaseSteps{
	@Steps
	OrdersAPI orderAPI;
	Billing billing;
	Shipping shipping;
	Product product;
	Order order;
	
	
	public CreateOrderSteps() {
		super();
	}

	@When ("^se completen todos los datos requeridos de facturacion$")
	public void se_completen_todos_los_datos_requeridos_de_facturacion(DataTable billingTable) throws Exception {
	   Billing billing = new Billing();
	   for (Map<String, String> data : billingTable.asMaps(String.class, String.class)) {
		   billing.setFirst_name(data.get("first_name"));
		   billing.setLast_name(data.get("last_name"));
		   billing.setAddress_1(data.get("address_1"));
		   billing.setCity(data.get("city"));
		   billing.setState(data.get("state"));
		   billing.setCountry(data.get("country"));
		   billing.setEmail(data.get("email"));
		   billing.setPhone(data.get("phone"));

		}
		context.put("billing", billing);
	   
	}
	
	@When("^se completen todos los datos requeridos de entrega$")
	public void se_completen_todos_los_datos_requeridos_de_entrega(DataTable shippingTable) throws Exception {
		Shipping shipping = new Shipping();
		   for (Map<String, String> data : shippingTable.asMaps(String.class, String.class)) {
			   shipping.setFirst_name(data.get("first_name"));
			   shipping.setLast_name(data.get("last_name"));
			   shipping.setAddress_1(data.get("address_1"));
			   shipping.setCity(data.get("city"));
			   shipping.setState(data.get("state"));
			   shipping.setCountry(data.get("country"));
		   }
		   context.put("shipping", shipping);
	}
	
	@When("^se completen los datos del producto$")
	public void se_completen_los_datos_del_producto(DataTable productTable) throws Exception {
		Product product = new Product();
		   for (Map<String, String> data : productTable.asMaps(String.class, String.class)) {
			   product.setProductID(data.get("product_id"));
			   product.setQuantity(data.get("quantity"));
		   }
		   context.put("product", product);
	}

	@When("^se envie el request$")
	public void se_envie_el_request() throws Exception {
		Order order = new Order();
	    order.setShippingData((Shipping) context.get("shipping"));
	    order.setBillingData((Billing) context.get("billing"));
	    List<Product> line_items= new ArrayList<>();
	    line_items.add((Product)context.get("product"));
	    order.setLine_items(line_items);    
	    orderAPI.createOrderRequest(order);

		
	}
	
	@Then("^se mostara un mensaje de exito \"([^\"]*)\" orden creada$")
	public void se_mostara_un_mensaje_de_exito_orden_creada(int expectedStatusCode) throws Exception {
		int statusCode=orderAPI.getStatusCode();
	    Assert.assertTrue("Cliente creado", statusCode==expectedStatusCode);
	}
}
