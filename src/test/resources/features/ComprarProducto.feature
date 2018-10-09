Feature: Como usuario quiero comprar un producto ya agregado a mi carro de compras. 

@ui
Scenario: Comprar un producto de manera satisfactoria

	Given el usuario ya se encuentra en la pagina del producto 
		|productID|
		|pelota-futbol|
		
	When agregue el producto al carro 
	And complete los detalles de facturacion 
		|nombre|apellido|telefono|email|
		|Fernando|martinez|555444331|fgmartinez1989@gmail.com|
		
	And complete los datos de la direccion 
		|pais|ciudad|departamento|estado|codigoPostal|calle|
		|US|New York|2c|NY|10001|Ocean Bv|
	And envie el formulario de compra
	
	Then el usuario es redireccionado a la pagina de orden creada 
	
@ui
Scenario Outline: Comprar un producto, enviando el formulario de compra con al menos un campo obligatorio vacio, se debera mostrar un mensaje de error

	Given el usuario ya se encuentra en la pagina del producto 
		|productID|
		|pelota-futbol|
		
	When agregue el producto al carro 
	
	And  complete los detalles de facturacion dejando al menos uno de los campos obligatorios vacios: nombre "<nombre>" and apellido "<apellido>" and telefono "<telefono>" and email "<email>" 
	
	And complete los datos de la direccion 
		|pais|ciudad|departamento|estado|codigoPostal|calle|
		|US|New York|2c|NY|10001|Ocean Bv|
	And envie el formulario de compra con errores
	
	Then se mostrara un mensaje de error indicando que el campo es requerido 
	
	Examples: 
	|nombre|apellido|telefono|email|
	||martinez|555444331|fgmartinez1989@gmail.com|
	|Fernando||555444331|fgmartinez1989@gmail.com|
	|Fernando|martinez||fgmartinez1989@gmail.com|
	|Fernando|martinez|555444331||
