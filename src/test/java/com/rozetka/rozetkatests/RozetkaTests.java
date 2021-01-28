package com.rozetka.rozetkatests;

import com.rozetka.BaseTest;
import com.rozetka.pages.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RozetkaTests extends BaseTest {

    private HomePageRozetka homePage;
    private String username="";


    @BeforeMethod(alwaysRun = true)
    public void setupTest() {
        homePage = new HomePageRozetka(driver);
    }

    //   -----------------------------Test 1-----------------------------

    @Test(groups = "main", suiteName = "ui")
    public void verifyLogInCorrectTest() throws Exception {

        //Given user navigates to the web page https://rozetka.com.ua/ua/

        //when from the home page click on link “увійдіть в особистий кабінет” on the right upper site
        // user navigates to logIn form

        homePage = homePage
                .clickOnLogInLink(LogInFormPage.class)
                .setEmail(getEmail())
                .setPassword(getPassword())
                .clickOnLogInButton(HomePageRozetka.class);

        //Then user inserts correct email and password and clicks button "Увійти",
        // user redirected to log in cabinet on Home page

        Assert.assertTrue(homePage.isUserLogIn(username), "LogIn form doesn't work correct");
    }

    //   -----------------------------Test 2-----------------------------

    @Test(groups = "main", suiteName = "ui")
    public void verifyLogInInCorrectUserTest() throws Exception {

        //Given user navigates to the web page https://rozetka.com.ua/ua/

        //when from the home page click on link “увійдіть в особистий кабінет” on the right upper site
        // user navigates to logIn form

        homePage = homePage
                .clickOnLogInLink(LogInFormPage.class)
                .setEmail(getEmail()+"g")
                .setPassword(getPassword())
                .clickOnLogInButton(HomePageRozetka.class);

        //Then user inserts incorrect email and correct password and clicks button "Увійти",
        // user isn't redirected to log in cabinet on Home page

        Assert.assertFalse(homePage.isUserLogIn(username), "Wrong User entered to cabinet. LogIn form doesn't work correct");
    }

    //   -----------------------------Test 3-----------------------------

    @Test(groups = "main", suiteName = "ui")
    public void verifyLogInInCorrectPasswordTest() throws Exception {

        //Given user navigates to the web page https://rozetka.com.ua/ua/

        //when from the home page click on link “увійдіть в особистий кабінет” on the right upper site
        // user navigates to logIn form

        homePage = homePage
                .clickOnLogInLink(LogInFormPage.class)
                .setEmail(getEmail())
                .setPassword(getPassword()+"g")
                .clickOnLogInButton(HomePageRozetka.class);

        //Then user inserts correct email and incorrect password and clicks button "Увійти",
        // user isn't redirected to log in cabinet on Home page

        Assert.assertFalse(homePage.isUserLogIn(username), " User entered to cabinet using wrong password. LogIn form doesn't work correct");
    }
}
