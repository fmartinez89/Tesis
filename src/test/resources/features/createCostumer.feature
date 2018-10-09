Feature: Crear un cliente

@rest
Scenario: Crear un orden de manera satisfactoria

When se completen los datos de facturacion del cliente
|first_name|last_name|address_1|city|state|postCode|country|email|phone|
|Fernando| Martinez|Ocean Bv 123|Manhatan|NY|10001|US|fgmartinez@test.com|1122112211|
And se completen los datos de entrega del cliente
|first_name|last_name|address_1|city|state|postCode|country|
|Fernando| Martinez|Ocean Bv 123|Manhatan|NY|10001|US|
And se completen los datos restantes del cliente, y se envie el request
|first_name|last_name|email|username|
|Fernando| Martinez|fgmartinez@test.com|fgmartinez|

Then se mostara un mensaje de exito "201"