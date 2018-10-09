package tesis.features.steps;

import java.util.List;

import org.springframework.util.Assert;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import net.thucydides.core.annotations.Steps;
import tesis.api.libs.AuthLib;
import tesis.api.libs.OrdersAPI;
import tesis.environment.Variables;
import tesis.model.Order;
import utils.ContenedorResponse;
import utils.Context;

public class ListOrdersSteps {
	
	@Steps
	OrdersAPI ordenAPI;
	AuthLib autenticacion;

	
	@When("^se envia un request para solicitar la lisa de ordenes creadas$")
	public void se_envia_un_request_para_solicitar_la_lisa_de_ordenes_creadas() {
		ordenAPI.requestOrders();
	       
	}

	@Then("^se retornara una lista con las ordenes creadas$")
	public void se_retornara_una_lista_con_las_ordenes_creadas() {
	
	List<Order> listaOrdenes = ordenAPI.getOrders();
	 Assert.notNull(listaOrdenes, "La lista no es nula");
	 Assert.notEmpty(listaOrdenes, "La lista no se encuentra vacia");
	 
	}



}
