package com.demo.page;

import com.demo.utils.Configs;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Facebook extends BasePage{
    private static final Logger LOGGER = Logger.getLogger(Facebook.class);
    private static final By emailBox = By.id("email");
    private static final By passBox = By.id("pass");
    private static final By loginBtm = By.xpath("//*[@id=\"loginbutton\"]//input[@data-testid=\"royal_login_button\"]");
    public Facebook(WebDriver driver) {
        super(driver);
    }

    public void open(){
        String URL = Configs.get("Facebook_URL","https://www.facebook.com/");
        driver.get(URL);
        driver.manage().window().maximize();
    }

    public void setEmailBox(){
        setElement(findElement(emailBox),Configs.get("FB.user", "John@doe.com"));
    }

    public void setPassBox(){
        setElement(findElement(passBox),Configs.get("FB.pass","password"));
    }

    public void login() {
        clickElement(findElement(loginBtm));
    }

    public void checkTitle() {
        Assert.assertEquals(Configs.get("FB.expectedNickName","John doe"),
                findElement(By.xpath("//a[@data-testid=\"left_nav_item_"
                        +Configs.get("FB.expectedNickName","John doe"+"]")))
                        .getAttribute("title"));
    }
}
