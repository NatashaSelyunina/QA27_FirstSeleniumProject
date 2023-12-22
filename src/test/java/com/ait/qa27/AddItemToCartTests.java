package com.ait.qa27;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddItemToCartTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent(By.cssSelector("[href='/register']"))) {
            driver.findElement(By.cssSelector("[href='/logout']"));
        }

        click(By.cssSelector("[href='/login']"));

        type(By.id("Email"), "larina@mail.ru");

        type(By.id("Password"), "000333");

        click(By.id("RememberMe"));

        click(By.cssSelector("[value='Log in']"));
    }

    @Test
    public void addItemToCartPositiveTest() {
        click(By.cssSelector("[src='https://demowebshop.tricentis.com/content/images/thumbs/" +
                "0000172_build-your-own-cheap-computer_125.jpeg']"));
        click(By.id("add-to-cart-button-72"));
        click(By.xpath("//span[.='Shopping cart']"));
        Assert.assertTrue(isItemCreatedByText("Build your own cheap computer"));
    }

    public boolean isItemCreatedByText(String text) {
        List<WebElement> items = driver.findElements(By.cssSelector("a"));
        for (WebElement element : items) {
            if (element.getText().contains(text)) {
                return true;
            }
        }
        return false;
    }
}