import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class mainAmazon
{
    public static void main(String[] args)
    {
        DesiredCapabilities chDCap = DesiredCapabilities.chrome();
        chDCap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        chDCap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);                    //Certification
        System.setProperty("webdriver.chrome.driver", "D:\\Docs\\Drivers\\chromedriver.exe");
        WebDriver amzDriver = new ChromeDriver();
        amzDriver.get("https://www.amazon.com.tr");
        amzDriver.manage().window().maximize();
        amzDriver.findElement(By.id("sp-cc-accept")).click();
        amzDriver.manage().deleteAllCookies();
        WebDriverWait expWait = new WebDriverWait(amzDriver, 3);

        String[] pcParts = new String[]
                {"Asus X570", "AMD Ryzen 5600X", "Kingston HyperX Beast", "Asus RTX 3070", "Samsung 970 Evo Plus"};

        for (int i = 0; i < pcParts.length; i++)
        {
            amzDriver.findElement(By.id("twotabsearchtextbox")).sendKeys(pcParts[i]);
            amzDriver.findElement(By.id("nav-search-submit-button")).click();
            SearchItem();
            amzDriver.findElement(By.id("twotabsearchtextbox")).clear();

        }


    }

    private static void SearchItem()
    {
        WebDriver srcDriver = new ChromeDriver();
        System.out.println(srcDriver.getTitle());
    }

}
