Feature: Como usuario administrador quiero listar las ordenes creadas

@rest
Scenario: listar todas las ordenes

	When se envia un request para solicitar la lisa de ordenes creadas
	Then se retornara una lista con las ordenes creadas
	
