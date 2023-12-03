package com.ait.qa27;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

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
        List<WebElement> elements = driver.findElements(By.cssSelector("p"));
        System.out.println(elements.size());
        WebElement element = driver.findElement(By.cssSelector(".topic-html-content-body > p"));
        System.out.println(element.getText());
        driver.findElement(By.cssSelector("#bar-notification"));
        driver.findElement(By.cssSelector("div.slider-wrapper.theme-default"));
        driver.findElement(By.cssSelector("[data-productid='72']"));
        driver.findElement(By.cssSelector("#bar-notification > span"));
        driver.findElement(By.cssSelector("div.header-logo"));
        driver.findElement(By.cssSelector(".ico-register"));
        driver.findElement(By.cssSelector("#flyout-cart.flyout-cart"));
        driver.findElement(By.cssSelector("form"));
        driver.findElement(By.cssSelector("[name='q']"));
    }

    @Test
    public void findElementsByXpath() {
        driver.findElement(By.xpath("//p[contains(.,'Feel free to shop')]"));
        driver.findElement(By.xpath("//p[.='Welcome to the new Tricentis store!']"));
        driver.findElement(By.xpath("//div[@id='bar-notification']"));
        driver.findElement(By.xpath(
                "//div[contains(@class, 'slider-wrapper') and contains(@class, 'theme-default')]"));
        driver.findElement(By.xpath("//div[@data-productid='72']"));
        driver.findElement(By.xpath("//span[@title='Close']"));
        driver.findElement(By.xpath("//div[@class='header-logo']"));
        driver.findElement(By.xpath("//a[contains(.,'Register')]"));
        driver.findElement(By.xpath("//div[@id='flyout-cart']"));
        driver.findElement(By.xpath("//form"));
        driver.findElement(By.xpath("//input[@name='q']"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}