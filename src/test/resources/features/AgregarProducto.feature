Feature: Agregar Productos
Como cliente, quiero agregar productos a mi Carro de compras, para luego efectuar la compra.

@ui
Scenario: Agregar un producto al carro.
	Given ha ingresado a la homePage
  	When agregue el producto deseado al carro de compras
  	And ingrese al carro de compras
  	Then el producto con el nombre seleccionado, ha sido agregado al carro