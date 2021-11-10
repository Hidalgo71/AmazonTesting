import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.stream.Stream;

public class mainAmazon
{
    static WebDriver amzDriver;

    public static void main(String[] args)
    {
        DesiredCapabilities chDCap = DesiredCapabilities.chrome();
        chDCap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        chDCap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);                    //Certification
        System.setProperty("webdriver.chrome.driver", "D:\\Docs\\Drivers\\chromedriver.exe");
        amzDriver = new ChromeDriver();
        amzDriver.get("https://www.amazon.com.tr");
        amzDriver.manage().window().maximize();
        amzDriver.manage().deleteAllCookies();
        WebDriverWait expWait = new WebDriverWait(amzDriver, 3);

        TypeClick();

    }

    public static void TypeClick()
    {
        String[] pcParts = new String[]
        {"Asus X570", "AMD Ryzen 5600X", "Kingston HyperX Beast", "Asus RTX 3070", "Samsung 970 Evo Plus"};
        for (String pcPart : pcParts)
        {
            amzDriver.findElement(By.id("sp-cc-accept")).click();
            amzDriver.findElement(By.id("twotabsearchtextbox")).sendKeys(pcPart);
            amzDriver.findElement(By.id("nav-search-submit-button")).click();
            amzDriver.findElement(By.id("twotabsearchtextbox")).clear();
            SearchItem();
        }
    }
    public static void SearchItem()
    {
        for (int i = 0; i < amzDriver.findElements(By.xpath("span[class='a-size-base a-color-base a-text-normal']")).size(); i++)
        {
            String longTxt = amzDriver.findElement(By.xpath("span[class='a-size-base a-color-base a-text-normal']")).getText();
            //Stream.of(longTxt).filter(l -> l.contains("X570-Plus"));
            Stream.of(longTxt).filter(l -> l.equalsIgnoreCase("X570-Plus"));
            amzDriver.findElement(By.className("span[class='a-size-base a-color-base a-text-normal']")).click();

        }
    }
}
