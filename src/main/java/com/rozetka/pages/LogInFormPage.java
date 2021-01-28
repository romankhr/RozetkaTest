package com.rozetka.pages;

import com.rozetka.framework.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LogInFormPage extends Page {
    private String eMailLocator="//input[@id='auth_email']";
    private String passwordLocator="//input[@id='auth_pass']";
    private String logInButtonLocator="//button[@class='button button--large button--green auth-modal__submit']";

    public LogInFormPage(RemoteWebDriver driver) {
        super(driver);
    }

            public LogInFormPage setEmail(String email){
            driver.findElement(By.xpath(eMailLocator)).sendKeys(email);
            return this;
        }

    public LogInFormPage setPassword(String password){
        driver.findElement(By.xpath(passwordLocator)).sendKeys(password);
        return this;
    }
    public <T extends Page> T clickOnLogInButton(Class<T> clazz) throws Exception {
        Thread.sleep(1000);
        driver.findElement(By.xpath(logInButtonLocator)).click();
        return PageFactory.newPage(driver, clazz);
    }
}
