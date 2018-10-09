package tesis.api.libs;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import tesis.environment.Variables;
import tesis.rest.model.Costumer;

public class CostumerAPI {
	@Step
	public void createCostumerRequest(Costumer costumer) {
		SerenityRest.given()
		.port(80)
		.auth(). preemptive().basic(Variables.clientID, Variables.secret)
		.header("Content-type", "application/json")
		.body(costumer)
		.when()
		.log().all()
		.post(Variables.apiURL + "customers");
		}

	@Step
	public int getStatusCode() {
		return SerenityRest.then().log().all().extract().statusCode();
	}


}
