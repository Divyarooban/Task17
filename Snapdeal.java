import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Snapdeal {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        //Launch the webdriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    @Test
    public void snapdea() throws InterruptedException{
        //Launch the website
        driver.get("http://www.snapdeal.com");
        //Move the cursor on Sign In button and hold it
        Actions action=new Actions(driver);
        WebElement element=driver.findElement(By.xpath("//span[text()='Sign In']"));
        Thread.sleep(2000);
        action.moveToElement(element).clickAndHold().build().perform();
        driver.findElement(By.xpath("//span[@class='accountBtn btn rippleWhite']")).click();
        Thread.sleep(2000);
        WebElement iframe=driver.findElement(By.id("loginIframe"));
        driver.switchTo().frame(iframe);
        WebElement e=driver.findElement(By.id("userName"));
        e.sendKeys("pixila7118@tanlanav.com");
        driver.findElement(By.id("checkUser")).click();
        Thread.sleep(2000);
        String email=driver.findElement(By.xpath("//div[@id='verifyEmailUC']")).getText();
        Assert.assertEquals(email,"pixila7118@tanlanav.com");
    }
    @AfterClass
    public void tearDown(){

        driver.quit();
    }


}
