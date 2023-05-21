package by.itacademy.tatjana.balashevich;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageTest {
    @Test
    public void testLoginForm() throws InterruptedException {
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

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5));

        WebElement actualMessage = driver.findElement(By.xpath("//*[@id='auth-container']/div/div[2]/div/form/div[3]"));
        String actualMessageText = actualMessage.getText();
        System.out.println(actualMessageText);
        Assertions.assertEquals("Неверный логин или пароль", actualMessageText);

        driver.quit();
    }
}
