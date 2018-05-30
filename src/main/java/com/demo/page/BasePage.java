package com.demo.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BasePage {
    private static final Logger LOGGER = Logger.getLogger(BasePage.class);
    protected  WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     *
     * @param locator Xpath
     * @param timeoutSeconds in seconds
     * @return Webelemtn
     */
    protected WebElement findElement(By locator, int timeoutSeconds){
        WebDriverWait waiter = new WebDriverWait(driver,timeoutSeconds);
        return waiter.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected WebElement findElement(By locator){
        return findElement(locator,5);
    }

    protected boolean isElementPresent(By locator){
        try {
            return findElement(locator) != null;
        }catch (Exception e){
            LOGGER.error(e.getMessage(),e);
            return false;
        }
    }

    protected void setElement(WebElement e, String val){
        e.sendKeys(val);
    }

    public void clickElement(WebElement e){
        e.click();
    }
}
