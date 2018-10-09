package tesis.features.steps;

import java.util.Map;

import org.junit.Assert;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import tesis.api.libs.CostumerAPI;
import tesis.rest.model.Billing;
import tesis.rest.model.Costumer;
import tesis.rest.model.Shipping;

public class CreateCostumerSteps extends BaseSteps{

	@Steps
	CostumerAPI costumerAPI;
	Billing billing;
	Shipping shipping;
	Costumer costumer;
	
@When("^se completen los datos de facturacion del cliente$")
public void se_completen_los_datos_de_facturacion_del_cliente(DataTable billingTable)  {
	Billing billing = new Billing();
	for (Map<String, String> data : billingTable.asMaps(String.class, String.class)) {
		billing.setFirst_name(data.get("first_name"));
		billing.setLast_name(data.get("last_name"));
		billing.setAddress_1(data.get("address_1"));
		billing.setCity(data.get("city"));
		billing.setCountry(data.get("country"));
		billing.setPhone(data.get("phone"));
		billing.setEmail(data.get("email"));
		context.put("billing", billing);
	}
}

@When("^se completen los datos de entrega del cliente$")
public void se_completen_los_datos_de_entrega_del_cliente(DataTable shippingTable) throws Exception {
	Shipping shipping = new Shipping();
	for (Map<String, String> data : shippingTable.asMaps(String.class, String.class)) {
		shipping.setFirst_name(data.get("first_name"));
		shipping.setLast_name(data.get("last_name"));
		shipping.setAddress_1(data.get("address_1"));
		shipping.setCity(data.get("city"));
		shipping.setCountry(data.get("country"));
		context.put("shipping", shipping);
	}
}

@When("^se completen los datos restantes del cliente, y se envie el request$")
public void se_completen_los_datos_restantes_del_cliente_y_se_envie_el_request(DataTable costumerTable) throws Exception {
	Costumer costumer = new Costumer();
	for (Map<String, String> data : costumerTable.asMaps(String.class, String.class)) {
		costumer.setFirst_name(data.get("first_name"));
		costumer.setLast_name(data.get("last_name"));
		costumer.setEmail(costumer.generateRandomEmail());
		costumer.setUsername(data.get("userName"));
		costumer.setShipping((Shipping) context.get("shipping"));
		costumer.setBilling((Billing) context.get("billing"));	
	}
	costumerAPI.createCostumerRequest(costumer);
}

@Then("^se mostara un mensaje de exito \"([^\"]*)\"$")
public void se_mostara_un_mensaje_de_exito(int expectedStatusCode) throws Exception {
	int statusCode=costumerAPI.getStatusCode();
    Assert.assertTrue("Cliente creado", statusCode==expectedStatusCode);
	}
}
