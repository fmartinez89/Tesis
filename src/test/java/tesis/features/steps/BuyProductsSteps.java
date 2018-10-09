package tesis.features.steps;


import java.util.Map;

import static org.junit.Assert.*;
import net.thucydides.core.*;
import tesis.environment.Variables;
import tesis.model.Customer;
import tesis.model.Address;
import tesis.model.Product;
import tesis.pages.CartPage;
import tesis.pages.CheckoutPage;
import tesis.pages.HomePage;
import tesis.pages.OrdenCreadaPage;
import tesis.pages.ProductDetailsPage;
import tesis.pages.ShopPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class BuyProductsSteps {

	HomePage homePage;
	ProductDetailsPage productPage;
	ShopPage shopPage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	Product producto;
	Customer cliente;
	OrdenCreadaPage ordenCreada;
	
		
	@Given("^el usuario ya se encuentra en la pagina del producto$")
	public void el_usuario_ya_se_encuentra_en_la_pagina_del_producto(DataTable productTable) throws Exception {
		Product producto = new Product();
		for (Map<String, String> data : productTable.asMaps(String.class, String.class)) {
			producto.setProductID(data.get("productID"));
		}
		
	    productPage.openUrl(Variables.baseURL + "/"+ producto.getProductID());
	}
	
	@When("^agregue el producto al carro$")
	public void agregue_el_producto_al_carro() throws Exception {
		productPage.addProduct(); 
		productPage.goToCartPage();
		cartPage.goToCheckoutPage();
	}

	@When("^complete los detalles de facturacion$")
	public void complete_los_detalles_de_facturacion(DataTable tablaCliente) throws Exception {
	   Customer cliente = new Customer();
	   for (Map<String, String> data : tablaCliente.asMaps(String.class, String.class)) {
			cliente.setNombre(data.get("nombre"));
			cliente.setApellido(data.get("apellido"));
			cliente.setTelefono(data.get("telefono"));
			cliente.setEmail(data.get("email"));
			
		}	  
	   checkoutPage.completarFormularioCompra(cliente);
	}

	@When("^complete los datos de la direccion$")
	public void complete_los_datos_de_la_direccion(DataTable tablaDireccion) throws Exception {
		 Address direccion= new Address();
		for (Map<String, String> data : tablaDireccion.asMaps(String.class, String.class)) {
			direccion.setPais(data.get("pais"));
			direccion.setCalle(data.get("calle"));
			direccion.setEstado(data.get("estado"));
			direccion.setCiudad(data.get("ciudad"));
			direccion.setCodigoPostal(data.get("codigoPostal"));
			
		}
		checkoutPage.completarDatosDireccion(direccion);
		
	}
	
	@When("^envie el formulario de compra$")
	public void envie_el_formulario_de_compra() throws Exception {
		checkoutPage.goToOrdenCreadaPage();
	}

	@Then("^el usuario es redireccionado a la pagina de orden creada$")
	public void el_usuario_es_redireccionado_a_la_pagina_de_orden_creada() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    assertTrue("Orden No creada", ordenCreada.validarInformacion());
	}
	
	@When("^complete los detalles de facturacion dejando al menos uno de los campos obligatorios vacios: nombre \"([^\"]*)\" and apellido \"([^\"]*)\" and telefono \"([^\"]*)\" and email \"([^\"]*)\"$")
	public void complete_los_detalles_de_facturacion_dejando_al_menos_uno_de_los_campos_obligatorios_vacios_nombre_and_apellido_and_telefono_and_email_and_pais(String nombre, String apellido, String telefono, String email) throws Exception {
		Customer cliente = new Customer();
		cliente.setNombre(nombre);
		cliente.setApellido(apellido);
		cliente.setTelefono(telefono);
		cliente.setEmail(email);

   checkoutPage.completarFormularioCompra(cliente);
	}
	
	@When("^envie el formulario de compra con errores$")
	public void envie_el_formulario_de_compra_con_errores() throws Exception {
		checkoutPage.validarMensajesError();
	}

	@Then("^se mostrara un mensaje de error indicando que el campo es requerido$")
	public void se_mostrara_un_mensaje_de_error_indicando_que_el_campo_es_requerido() throws Exception {
		 assertTrue("Se deberia mostrar un mensaje de error indicando que campos son obligatorios", checkoutPage.validarMensajesError());
	  
	}
}
