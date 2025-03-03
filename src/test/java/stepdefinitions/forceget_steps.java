package stepdefinitions;


import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ElementsPage;
import utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Driver;

import java.time.Duration;

public class forceget_steps {

    static ElementsPage elementsPage = new ElementsPage();
    static String fakemail;


    @Given("Kullanici kayit sayfasina gider")
    public void kullanici_kayit_sayfasina_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
    }

    @When("kullanici ismini girer")
    public void kullaniciisminigirer() {
        ReusableMethods.bekle(2);
        elementsPage.firstNameInput.sendKeys("emre" + Keys.ENTER);
    }

    @And("kullanici soyismini girer")
    public void kullanicisoymisinigirer() {
        ReusableMethods.bekle(2);
        elementsPage.lastNameInput.sendKeys("gundogdu" + Keys.ENTER);
    }

    @And("kullanici ulke kodunu girer")
    public void kullaniciulkekodunugirer() {
        ReusableMethods.bekle(2);
        elementsPage.countryDropdown.sendKeys("+90" + Keys.ENTER);
    }

    @And ("kullanici telefon numarasi girer")
    public void kullanicitelefonnumarasigirer() {
        ReusableMethods.bekle(2);
        elementsPage.phoneNumberInput.sendKeys("5345808027" + Keys.ENTER);
    }

    @And ("kullanici sirket ismini girer")
    public void kullanicisirketisminigirer() {
        ReusableMethods.bekle(2);
        elementsPage.companyNameInput.sendKeys("Forgecet" + Keys.ENTER);
    }

    @And ("kullanici mail girer")
    public static void kullanicimailgirer() {
        ReusableMethods.bekle(2);
        Faker faker = new Faker();
        fakemail = faker.internet().emailAddress();
        elementsPage.kullanicimail.sendKeys(fakemail);
    }

    @And ("kullanici gorevini girer")
    public void kullanicigorev() {
        ReusableMethods.bekle(2);
        elementsPage.titleField.click();
        elementsPage.ceoOption.click();
    }

    @And ("kullanici parolayi girer ve parolayi dogrular")
    public void kullaniciparolagirer() {
        ReusableMethods.bekle(2);

        elementsPage.emailInput.sendKeys("E1260e.00*");
        ReusableMethods.bekle(3);
        elementsPage.passwordInput.sendKeys("E1260e.00*");
        ReusableMethods.bekle(2);

    }
    @And("kullanici hizmet sartlari ve gizlilik politikasini okur ve onaylar")
            public void hizmetVegizlilik() {
        elementsPage.termsCheckbox.click();
        ReusableMethods.bekle(2);
        elementsPage.ConfirmButton.click();

        ReusableMethods.bekle(2);
    }

    @And("kullanici  kayit ol tusuna basar ve kayit olur")
    public void kabuletvekaydol() {
        elementsPage.sonbuton.click();
        ReusableMethods.bekle(10);

    }

        @And("kullanici mail dogrulamasini yapar")
                public void maildogrulama(){

       // DateTimeFormatter formatter =DateTimeFormatter.ofPattern("mmHHdd");
        //String formattedDate = LocalDateTime.now().format(formatter);
        elementsPage.ilkbosluk.sendKeys("401128");
    }

    @And("And kullanici yuklenen login sayfasında mail ve sifresini girip login olur")
    public void kullaniciloginmail(){



        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.urlContains("account/login")); // Login sayfasına yönlendirmeyi bekle

        if (fakemail == null || fakemail.isEmpty()) {
            System.out.println("❌ Fake email is null! Using fallback email.");
            fakemail = "fallbackEmail" + System.currentTimeMillis() + "@test.com"; // Yedek mail oluştur
        }

        System.out.println("Logging in with Email: " + fakemail);

        // Login alanlarının görünmesini bekle
        WebElement emailField = wait.until(ExpectedConditions.visibilityOf(elementsPage.loginmail));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOf(elementsPage.loginpassword));

        emailField.click();
        emailField.sendKeys(fakemail);
        passwordField.sendKeys("E1260e.00*");

        ReusableMethods.bekle(1);
        elementsPage.loginbuton.click();
    }

    @Then("kullanici anasayfaya giris yapar ve basariyla giris yaptigini dogrular")
    public void kullanici_giris_dogrular() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        try {
            WebElement welcomeMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Welcome, emre gundogdu')]")));

            if (welcomeMessage.isDisplayed()) {
                System.out.println("✅ Kullanıcı başarıyla giriş yaptı ve anasayfada!");
            } else {
                System.out.println("❌ Giriş başarısız! Welcome mesajı görünmüyor.");
            }
        } catch (TimeoutException e) {
            System.out.println("❌ Giriş başarısız! Welcome mesajı sayfada bulunamadı.");
        }
    }


}


/*
    @When("kullanici testi gecer")
    public void kullanici_testi_gecer() {
        WebDriver driver = Driver.getDriver();
        driver.get("http://app.forceget.com/system/account/register");

        // CAPTCHA'nın siteKey'ini bul
        String siteKey = driver.findElement(By.cssSelector("[data-sitekey]")).getAttribute("data-sitekey");

        try {
            // 2Captcha API ile CAPTCHA'yı çöz
            String captchaToken = CaptchaSolver.solveCaptcha(siteKey, "http://app.forceget.com/system/account/register");

            if (captchaToken != null) {
                WebElement captchaInput = driver.findElement(By.id("g-recaptcha-response"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", captchaInput);
                captchaInput.sendKeys(captchaToken);

                System.out.println("✅ CAPTCHA başarıyla çözüldü ve gönderildi!");
            } else {
                System.out.println("❌ CAPTCHA çözülemedi!");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } */
