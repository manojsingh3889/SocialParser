package stepdefinitions.common;

import com.demo.utils.Configs;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Hook {
    private Scenario scenario;
    public static WebDriver driver;
    DesiredCapabilities capabilities;
    private static Logger LOGGER = LoggerFactory.getLogger(Hook.class);

    @Before
    public void setUp(Scenario scenario){
        LOGGER.info("Starting set up....");
        Configs.load();
        this.scenario = scenario;
        LOGGER.info("Executing scenerio ["+this.scenario.getName()+"]");

        if ((Configs.get("ExecutionPlatform").equalsIgnoreCase("Web"))) {
            LOGGER.info("Our browser will be invoked here");
            switch (Configs.get("browserName")){
                case "chrome":
                    System.setProperty("webdriver.chrome.driver",
                            System.getProperty("user.dir")+ File.separator+Configs.get("ChromeDriver"));
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--disable-extensions");
                    options.addArguments("--disable-print-preview");
                    driver = new ChromeDriver(options);
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "IE":
                    System.setProperty("webdriver.ie.driver",
                            System.getProperty("user.dir")+ File.separator+Configs.get("ChromeDriver"));
                    driver = new InternetExplorerDriver();
                    break;
                default:
                    throw new IllegalArgumentException("only chrome|firefox|IE supported as browserName. change config");
            }
        }else{
            throw new IllegalArgumentException("Only 'Web' supported for 'ExecutionPlatform'. change config");
        }

        //If everything goes as per plan then set implicit wait for general element extraction
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

    @After
    public void tearDown(){
        if(Configs.get("ExecutionPlatform").equalsIgnoreCase("web")){
            driver.quit();
        }
    }
}
