Feature: crear orden

@rest
Scenario: crear orden de manera satisfactoria

When se completen todos los datos requeridos de facturacion
|first_name|last_name|address_1|city|state|postCode|country|email|phone|
|Fernando| Martinez|Ocean Bv 123|Manhatan|NY|10001|US|fgmartinez@test.com|1122112211|
And se completen todos los datos requeridos de entrega
|first_name|last_name|address_1|city|state|postCode|country|
|Fernando| Martinez|Ocean Bv 123|Manhatan|NY|10001|US|
And se completen los datos del producto
|product_id|quantity|
|9|1|
And se envie el request
Then se mostara un mensaje de exito "201" orden creada