package tesis.api.libs;


import io.restassured.RestAssured;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import tesis.environment.Variables;

public class AuthLib {


@Step
public void autenticar(String userName, String password) {
	SerenityRest.given().auth(). preemptive().basic(userName, password);
	
}


}
