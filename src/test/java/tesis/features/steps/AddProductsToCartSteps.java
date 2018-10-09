package tesis.features.steps;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import tesis.pages.*;

public class AddProductsToCartSteps {

	HomePage homePage;
	ProductDetailsPage productPage;
	ShopPage shopPage;
	CartPage cartPage;
		
		@Given("^ha ingresado a la homePage$")
		public void ha_ingresado_a_la_homePage() throws Exception {
		    homePage.open();
		  
		}


		@When("^agregue el producto deseado al carro de compras$")
		public void agregue_el_producto_deseado_al_carro_de_compras() throws Exception {
			 homePage.shop();
			 shopPage.goToProductDetailsPage();
			 productPage.addProduct();
		}


		@When("^ingrese al carro de compras$")
		public void ingrese_al_carro_de_compras() throws Exception {
			productPage.goToCartPage();
		   
		}

		
		@Then("^el producto con el nombre seleccionado, ha sido agregado al carro$")
		public void el_producto_con_el_nombre_ha_sido_agregado_al_carro() throws Exception {
			String retrievedProductName = cartPage.getProductName();
			assertTrue("El producto fue agregado Correctamente", !retrievedProductName.isEmpty());
			
			
		}
	}
