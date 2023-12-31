package com.ait.qa27;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent(By.cssSelector("[href='/register']"))) {
            driver.findElement(By.cssSelector("[href='/logout']"));
        }
    }

    @Test
    public void registerPositiveUserTest() {
        click(By.cssSelector("[href='/register']"));

        click(By.cssSelector("[for='gender-female']"));

        type(By.id("FirstName"), "Lana");

        type(By.id("LastName"), "Larina");

        type(By.id("Email"), "larina@mail.ru");

        type(By.id("Password"), "000333");

        type(By.id("ConfirmPassword"), "000333");

        click(By.id("register-button"));

        click(By.cssSelector("[value='Continue']"));

        Assert.assertTrue(isElementPresent(By.cssSelector("[href='/logout']")));
    }
}