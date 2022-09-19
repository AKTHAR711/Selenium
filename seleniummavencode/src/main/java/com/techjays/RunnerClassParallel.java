
package com.techjays;

@CucumberOptions(

	strict =true;
	glue = {"pol.bde"}

)

@API(statu= API.Status.STABLE)
public class RunnerClassParallel extends BaseTest {

	protected Logger log = LogManager.getLogger(this.getClass().getName());

	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeClass(alwaysRun = true)
	public void setUpClass(){ testNGCucumberRunner = TestNGCucumberRunner(this.getClass());}

@Test(groups = "cucumber", description = "Runs Cucumber Scenarios". dataProvoder = "scenarios")

public void runScenario(PickleEventWrapper pickeWrapper, CucumberFeatureWrapper featureWrapper, Map<String, Sting> map) throws Throwable{

	testNGCucumberRunner.runScenario(pickleWrapper.getPickleEvent());
}


@DataProvide(parallel =true, name ="scenarios")

public Object[][] scenarios() {

	//List of Scenarios(){
	Object[][] x = dpScenario();

	//browser driver stack
	JSONArray jsonArr = dpDriverStackJSON();

	//Creating object with scnarip and browser stack combination

	Object[][] obj = new Object[x.length * jsonArr.length()][3];
	Gson gson = new GsonBuilder().create();

	int K =0;

	for (int j =0; j < jsonArr.length(); j++) {
		JSONObject jsonObj = jsonArr.getJSONObject(j);
		/unchecked/
		Map<String, String> map = gson.fromJson(jsonObj.toString(), Map.class);
		for ( int i = 0; i< x.length; i++){
			obj[k][0] = x[i][0];
			obj[k][1] = x[i][1];
			obj[k][1] = map;
			k++;
		}
	}
	return obj;
}

@AfterClass(alwaysRun = true)
public void tearDownClass() {
	if (testNGCucumberRunner == null) {
	return;
	}

	testNGCucumberRunner.finich();
}

public Object[][] dpScenario() {
	if (testNGCucumberRunner == null){
		return new Object[0][0];
	}

	return testNGCucumber.provideScenarios();
}

public JSONArray dpDriverStackJSON(){
	log.debug("spinning up parallel execution threads for multi browser testing");
	return JsonHelper.getJSONArray(PropertyHepler.getVariable(propname: "driverstack") != null
	? Constants.DRIVERSTACKPATH + PropertyHelper.getVariable(propname: "driverstack") + ".json"
	: Constants.DRIVERSTACKPATH + PropertyHelper.getDefaultPropert(key: "driverstack") + ".json");
}
}










