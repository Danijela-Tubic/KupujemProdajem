import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KupujemProdajem {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tubic\\Desktop\\IT BOOTCAMP\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Proveravam da li sam na Google i da li se očekivani i dobijeni naslov poklapaju:
        driver.get("https://www.google.rs");

        String actualTitleForGoogle = driver.getTitle();
        String expectedTitleForGoogle = "Google";

        if (actualTitleForGoogle.equals(expectedTitleForGoogle)) {
            System.out.println("Google title: Valid!");
        } else {
            System.out.println("Actual result: " + actualTitleForGoogle);
        }

        //Ulazak na kupujemProdajem sajt:
        WebElement googleSearch = driver.findElement(By.name("q"));
        googleSearch.sendKeys("Kupujemprodajem");
        googleSearch.submit();

        //Provera da li sam na KupujemProdajem sajtu:
        driver.get("https://www.kupujemprodajem.com/");

        //Provera očekivanog i dobijenog naslova:
        String actualTitleForKp = driver.getTitle();
        String expectedTitleForKp = "KupujemProdajem";

        if (actualTitleForKp.equals(expectedTitleForKp)) {
            System.out.println("KupujemProdajem title: Valid!");
        } else {
            System.out.println("Actual result: " + actualTitleForKp);
        }

        //Gašenje pop-up prozora:
        WebElement closeButton = driver.findElement(By.className("kpBoxCloseButton"));
        closeButton.click();

        //Kucanje u pretragu:
        WebElement searchKp = driver.findElement(By.id("searchKeywordsInput"));
        searchKp.sendKeys("Iphone 13");
        searchKp.submit();

        //Scroll down da bi se došlo do prvog oglasa:
        Actions scrollDown = new Actions(driver);
        scrollDown.sendKeys(Keys.PAGE_DOWN).build().perform();

        //Biranje prvog ponuđenog oglasa:
        WebElement ad = driver.findElement(By.xpath("//*[@id=\"adDescription7321776\"]/a"));
        ad.click();

        //Upoređivanje očekivanog i dobijenog naslova:
        String actualTitleForAd = driver.getTitle();
        String expectedTitleForAd = "iPhone 13, iPhone 12, iPhone 11 - NOVO!";


        if (expectedTitleForAd.equals(actualTitleForAd)) {
            System.out.println("Ad title: Valid!");
        } else {
            System.out.println("Actual title: " + actualTitleForAd);
        }

        //Zatvaranje:
        driver.close();
    }
}
