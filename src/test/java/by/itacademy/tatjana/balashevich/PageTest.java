package by.itacademy.tatjana.balashevich;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageTest {
    @Test
    public void testLoginForm() {
        Page page = new Page();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.onliner.by/");
        WebElement buttonLogin = driver.findElement(By.xpath(page.buttonEnterXpath));
        buttonLogin.click();

        WebElement inputLogin = driver.findElement(By.xpath(page.inputLoginXpath));
        inputLogin.sendKeys("name@gmail.com");

        WebElement inputPWD = driver.findElement(By.xpath(page.inputPasswordXpath));
        inputPWD.sendKeys("HGFtrt");

        WebElement buttonSubmit = driver.findElement(By.xpath(page.buttonSubmitXpath));
        buttonSubmit.click();
    }
}
