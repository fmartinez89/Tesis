package tesis.features.steps;

import utils.ScenarioContext;

public class TestContext {

public ScenarioContext scenarioContext;
	
	public TestContext(){
		scenarioContext = new ScenarioContext();
	}
	
	public ScenarioContext getScenarioContext() {
		return scenarioContext;
	}
}
