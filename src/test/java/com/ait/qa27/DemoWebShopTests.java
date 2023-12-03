package com.ait.qa27;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoWebShopTests {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findElementsByCssSelector() {
        driver.findElements(By.cssSelector("p"));
        driver.findElement(By.cssSelector(".topic-html-content-body > p"));
        driver.findElement(By.cssSelector("#bar-notification"));
        driver.findElement(By.cssSelector("div.slider-wrapper.theme-default"));
        driver.findElement(By.cssSelector("[data-productid='72']"));
    }

    @Test
    public void findElementsByXpath() {
        driver.findElement(By.xpath("//p[contains(.,'Feel free to shop')]"));
        driver.findElement(By.xpath("//p[.='Welcome to the new Tricentis store!']"));
        driver.findElement(By.xpath("//div[@id='bar-notification']"));
        driver.findElement(By.xpath(
                "//div[contains(@class, 'slider-wrapper') and contains(@class, 'theme-default')]"));
        driver.findElement(By.xpath("//div[@data-productid='72']"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}