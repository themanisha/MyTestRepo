//Test Invalid Login SQL Injection

package LetsTest.MyTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MySixthTest {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/manisha/Downloads/chromedriver-mac-arm64/chromedriver");

        WebDriver driver = new ChromeDriver();

        try {
        	
            driver.get("https://app.vwo.com/#/login");

            WebElement usernameField = driver.findElement(By.name("username"));
            WebElement passwordField = driver.findElement(By.name("password"));
            WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

            usernameField.sendKeys("themanisha017@gmail.com");
            passwordField.sendKeys("' OR '1'='1"); // SQL Injection payload
            loginButton.click();

            Thread.sleep(5000);

            try {
                WebElement errorMessage = driver.findElement(By.className("error-message"));
                if (errorMessage.isDisplayed()) {
                    System.out.println("Test Invalid Login - SQL Injection: Error message displayed.");
                }
            } catch (Exception e) {
                System.out.println("Test Invalid Login - SQL Injection: Error message not found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
