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

public class FindElementsTests {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.berlin.de/");

        // Мы разворачиваем браузер
        driver.manage().window().maximize();

        // необходимо немножко подождать, когда все элементы на данном сайте загрузятся,
        // прежде чем начинать тестирование
        // 10 секунд - это стандарт / неявное время ожидания
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findElementsByTag() {
        // ищем элемент по тегу
        WebElement element = driver.findElement(By.tagName("h1"));
        System.out.println(element.getText());

        // находим список элементов по тегу
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        System.out.println(elements.size());
    }

    @Test
    public void findElementsByLocators() {
        driver.findElement(By.id("layout-grid__area--contentheader"));

        driver.findElement(By.className("logo"));

        // где есть ссылка (href)
        driver.findElement(By.linkText("Aktuelle Medungen"));

        // частичное совпадение
        driver.findElement(By.partialLinkText("Meldungen"));
    }

    @Test
    public void findElementByCssSelector() {
        // by id -> #id
        driver.findElement(By.cssSelector("#layout-grid__area--contentheader"));

        // by className -> .className
        driver.findElement(By.cssSelector(".logo"));

        // менять кавычки на одинарные/ пара ключ-значение
        driver.findElement(By.cssSelector("[title='Weitrblattern'"));
    }

    @Test
    public void findElementByXpath() {
        // -> //tag[@attr='value']
        driver.findElement(By.xpath("//*[@title='Weitrblattern'"));

        //xpath by text, частичное совпадение текста
        driver.findElement(By.xpath("//label[contains(.,'Berlin, ich brauche Informationen zu:')]"));

        //точное совпадения текста
        driver.findElement(By.xpath("//label[text()='Berlin, ich brauche Informationen zu:']"));
        driver.findElement(By.xpath("//label[.='Berlin, ich brauche Informationen zu:']"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
