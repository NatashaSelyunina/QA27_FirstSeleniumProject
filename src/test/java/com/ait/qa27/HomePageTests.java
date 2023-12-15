package com.ait.qa27;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

    @Test
    public void isDemoWebShopPresentTest() {
        //driver.findElement(By.cssSelector("[alt='Tricentis Demo Web Shop']"));
        Assert.assertTrue(isDemoWebShopPreset());
    }

    public boolean isDemoWebShopPreset() {
        return isElementPresent(By.cssSelector("[alt='Tricentis Demo Web Shop']"));
    }
}