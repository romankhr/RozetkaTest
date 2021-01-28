package com.rozetka.pages;


import com.rozetka.framework.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HomePageRozetka extends Page {

    protected RemoteWebDriver driver;
    private String logInLinkLocator = "//button[@class='header-topline__user-link button--link']";
    private String logInUserLinkLocator = "//p[@class='header-topline__user-text']";


    public HomePageRozetka(RemoteWebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public <T extends Page> T clickOnLogInLink(Class<T> clazz) throws Exception {
        driver.findElement(By.xpath(logInLinkLocator)).click();
        return PageFactory.newPage(driver, clazz);
    }

    public boolean isUserLogIn(String userName) {
        System.out.println(driver.findElement(By.xpath(logInUserLinkLocator)).getText());
        return driver.findElement(By.xpath(logInUserLinkLocator)).getText().contains(userName);
    }

}
