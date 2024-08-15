//Test Valid Login

package LetsTest.MyTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstTest {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/manisha/Downloads/chromedriver-mac-arm64/chromedriver");

        WebDriver driver = new ChromeDriver();

        try {
        	
            driver.get("https://app.vwo.com");

            WebElement usernameField = driver.findElement(By.name("username"));
            WebElement passwordField = driver.findElement(By.name("password"));
            WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

            usernameField.sendKeys("themanisha017@gmail.com");
            passwordField.sendKeys("@Manisha");
            loginButton.click();

            Thread.sleep(5000);

            WebElement profileMenu = driver.findElement(By.cssSelector("div.profile-menu")); 
            if (profileMenu.isDisplayed()) {
                System.out.println("Test Valid Login: Login successful.");
            } else {
                System.out.println("Test Valid Login: Login failed.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
