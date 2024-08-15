//Test Invalid Login Wrong Username

package LetsTest.MyTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFifthTest {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/manisha/Downloads/chromedriver-mac-arm64/chromedriver");

        WebDriver driver = new ChromeDriver();

        try {

            driver.get("https://app.vwo.com/#/login");

            WebElement usernameField = driver.findElement(By.name("username"));
            WebElement passwordField = driver.findElement(By.name("password"));
            WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

            usernameField.sendKeys("themanisha@gmail.com");//Wrong Username
            passwordField.sendKeys("@Manisha");  
            loginButton.click();

            Thread.sleep(5000);

            try {
                WebElement errorMessage = driver.findElement(By.className("error-message"));
                if (errorMessage.isDisplayed()) {
                    System.out.println("Test Invalid Login - Wrong Username: Error message displayed.");
                }
            } catch (Exception e) {
                System.out.println("Test Invalid Login - Wrong Username: Error message not found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
