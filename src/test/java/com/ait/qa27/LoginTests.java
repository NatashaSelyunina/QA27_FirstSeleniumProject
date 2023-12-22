package com.ait.qa27;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent(By.cssSelector("[href='/register']"))) {
            driver.findElement(By.cssSelector("[href='/logout']"));
        }
    }

    @Test
    public void LoginPositiveTest() {
        click(By.cssSelector("[href='/login']"));

        type(By.id("Email"), "larina@mail.ru");

        type(By.id("Password"), "000333");

        click(By.id("RememberMe"));

        click(By.cssSelector("[value='Log in']"));

        Assert.assertTrue(isElementPresent(By.cssSelector("[href='/logout']")));
    }
}