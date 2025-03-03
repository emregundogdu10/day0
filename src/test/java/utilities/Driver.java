package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class Driver {

    private Driver() {
        // Private constructor, bu sınıftan nesne üretimini engeller
    }

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            String kullanilacakBrowser = ConfigReader.getProperty("browser");

            switch (kullanilacakBrowser) {
                case "safari":
                    System.setProperty("webdriver.safari.allowRemoteAutomation", "true");
                    driver = new SafariDriver();
                    break;

                case "firefox":
                    driver = new FirefoxDriver();
                    break;

                case "edge":
                    driver = new EdgeDriver();
                    break;

                default: // Default olarak Chrome çalıştır
                    WebDriverManager.chromedriver().setup();

                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--start-maximized");  // Tarayıcıyı tam ekran aç
                    // options.addArguments("--headless=new");  // Headless kapalı olacak
                    options.addArguments("--disable-blink-features=AutomationControlled"); // Bot tespiti önleme
                    options.setExperimentalOption("useAutomationExtension", false);
                    options.addArguments("--remote-allow-origins=*");
                    options.addArguments("--disable-dev-shm-usage");
                    options.addArguments("--no-sandbox");

                    driver = new ChromeDriver(options);
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
