package com.fancode.shop.qa.base;

import com.browserstack.local.Local;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BrowserStackTestNGTest {
    public WebDriver driver;
    public JavascriptExecutor jse;
    private Local l;


    @BeforeMethod(alwaysRun = true)
    @org.testng.annotations.Parameters(value = {"config", "environment"})
    @SuppressWarnings("unchecked")

    public void setUp(String config_file, String environment) throws Exception {
        JSONParser parser = new JSONParser();
        JSONObject config = (JSONObject) parser.parse(new FileReader("src/test/resources/conf/" + config_file));
        JSONObject envs = (JSONObject) config.get("environments");


        String username = System.getenv("BROWSERSTACK_USERNAME");
        if (username == null) {
            username = (String) config.get("user");
        }

        String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
        if (accessKey == null) {
            accessKey = (String) config.get("key");
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();

        /*
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability("os_version", "10.0");
        capabilities.setCapability("device", "Samsung Galaxy S20");
        capabilities.setCapability("real_mobile", "true");
        capabilities.setCapability("browserstack.local", "true");
        capabilities.setCapability("build", "Shop Mweb Build #1");
        capabilities.setCapability("project", "Sample sandbox project");

        capabilities.setCapability(ChromeOptions.CAPABILITY, "CustomDevice");

        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "Samsung Galaxy S20");

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("mobileEmulation", mobileEmulation);


       */

        Map<String, String> envCapabilities = (Map<String, String>) envs.get(environment);
        Iterator it = envCapabilities.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
        }

        Map<String, String> commonCapabilities = (Map<String, String>) config.get("capabilities");
        it = commonCapabilities.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if (capabilities.getCapability(pair.getKey().toString()) == null) {
                capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
            }
        }


        if (capabilities.getCapability("browserstack.local") != null
                && capabilities.getCapability("browserstack.local") == "true") {
            l = new Local();
            Map<String, String> options2 = new HashMap<String, String>();
            options2.put("key", accessKey);
            l.start(options2);
        }
        jse = (JavascriptExecutor) driver;
        driver = new RemoteWebDriver(
                new URL("http://" + username + ":" + accessKey + "@" + config.get("server") + "/wd/hub"), capabilities);

    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        if (l != null) {
            l.stop();
        }
    }

    public void testResultReporting(String testName, boolean flag, String reason) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String status = "";
        if (flag) {
            status = "passed";
        } else {
            status = "failed";
        }
        if (testName.equals("")) {
            testName = "Simple Test";
        }
        String result = "browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"name\":\"" + testName + "\" ,\"status\": \"" + status + "\"}}";
        jse.executeScript(result);
    }

}

