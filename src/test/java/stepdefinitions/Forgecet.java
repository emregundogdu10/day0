package stepdefinitions;

import io.cucumber.java.an.E;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ElementsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.Driver;

import java.time.Duration;
import java.util.List;
import java.util.Random;


import static pages.ElementsPage.*;
// import static utilities.Driver.driver;

/* public class Forgecet {


    ElementsPage elementsPage = new ElementsPage();

    @Given("Kullanici kayit sayfasina gider")
    public void kullanici_kayit_sayfasina_gider() {

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
    }

    @When("kullanici ismini girer")
    public void kullaniciisminigirer() {
        ReusableMethods.bekle(2);
        ElementsPage.firstNameInput.sendKeys("emre" + Keys.ENTER);
    }

    @When("kullanici soyismini girer")
    public void kullanicisoymisinigirer() {
        ReusableMethods.bekle(2);
        ElementsPage.lastNameInput.sendKeys("gundogdu" + Keys.ENTER);
    }

    @When("kullanici ulke kodunu girer")
    public void kullaniciulkekodunugirer() {
        ReusableMethods.bekle(2);
        ElementsPage.countryDropdown.sendKeys("+90" + Keys.ENTER);

    }

    @When("kullanici telefon numarasi girer")
    public void kullanicitelefonnumarasigirer() {
        ReusableMethods.bekle(2);
        ElementsPage.phoneNumberInput.sendKeys("5345808027" + Keys.ENTER);
    }

    @When("kullanici sirket ismini girer")
    public void kullanicisirketisminigirer() {
        ReusableMethods.bekle(2);
        ElementsPage.companyNameInput.sendKeys("Forgecet" + Keys.ENTER);
    }

    @When("kullanici mail girer")
    public void kullanicimailgirer() {
        ReusableMethods.bekle(2);
        ElementsPage.kullanicimail.sendKeys("emregundogduinto@gmail.com");


    }

    @When("kullanici gorevini girer")
    public void kullanicigorev() {
        ReusableMethods.bekle(2);
        ElementsPage.titleField.click();
        ElementsPage.ceoOption.click();
    }

    @When("kullanici parola girer")
    public void kullaniciparolagirer() {
        ReusableMethods.bekle(2);
        ElementsPage.emailInput.sendKeys("E1260e.00*");
        ReusableMethods.bekle(3);
        ElementsPage.passwordInput.sendKeys("E1260e.00*");
        ReusableMethods.bekle(2);
        ElementsPage.termsCheckbox.click();
        ReusableMethods.bekle(2);
        ElementsPage.ConfirmButton.click();
        ReusableMethods.bekle(2);
        //Actions actions = new Actions(driver);
        // actions.sendKeys(Keys.PAGE_DOWN).perform();

    }
        // WebDriver'ı başlat



        @When("kullanici testi gecer")
        public void kullanicitestigecer() {
             WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("--headless");
            options.addArguments("--disable-blink-features=AutomationControlled");
            options.setExperimentalOption("useAutomationExtension", false);

            // ChromeDriver'ı başlat
            WebDriver driver = new ChromeDriver(options);

            // Stealth uygulama kısmı burada eklenebilir, ancak selenium-stealth'ın Java sürümü yok.
            // Bu yüzden "undetected-chromedriver" gibi bir kütüphane Java'da da kullanılabilir.

            driver.get("http://app.forceget.com/system/account/register");

            System.out.println(driver.findElement(By.xpath("/html/body")).getText());

            // driver.quit();  // Tarayıcıyı kapat


        }
    }

*/






