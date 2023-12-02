package com.ait.qa27;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

    WebDriver driver;

    // before - setUp
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        //driver.get("https://www.google.com/"); // без истории (нам нужно, чтобы открывался свежий браузер)
        driver.navigate().to("https://www.google.com/"); // с историей действий
        driver.navigate().back(); // откроется пустой браузер, возвращает обратно, стрелочка назад (клик на нее)
        driver.navigate().forward(); // на стрелочку вперед
        driver.navigate().refresh(); // обновление
    }

    // test
    @Test
    public void openGoogleTest() {
        System.out.println("Site opened");
    }

    // after - tearDown
    @AfterMethod(enabled = false) // тестовый метод с аннотацией не отрабатывал, то выставить атрибут у аннотации (enabled = false)
    public void tearDown() {
        // driver.quit(); //закрывает браузер, все вкладки
        driver.close(); // закрывает только одну вкладку
    }
}
