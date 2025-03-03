package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class ReusableMethods {

    public static void bekle(int saniye){

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            System.out.println("Bekleme yapilamadi");
        }
    }

    public static List<String> stringListeDonustur( List<WebElement> webElementList){

        List<String> stringList = new ArrayList<>();

        for (WebElement each: webElementList){

            stringList.add(each.getText());
        }

        return stringList;
    }

    public static void titleIleWindowGecisi( String hedefWindowTitle){
        // 1- acik tum window'larin whd'lerini kaydedelim
        Set<String> acikTumWindowlarinWhdSeti = Driver.getDriver().getWindowHandles();

        // 2- gecmek istedigimiz window'un title'ini kaydedelim
        // String hedefWindowTitle = "New Window";
        // yukarda parametre olarak var

        // 3- set'deki herbir whd'inin ait oldugu window'a gecis yapip
        //    gectigimiz window'un title'i hedefTitle ile ayni ise
        //    o window'da kalalim

        for (String eachWhd : acikTumWindowlarinWhdSeti){

            Driver.getDriver().switchTo().window(eachWhd);

            if (Driver.getDriver().getTitle().equals(hedefWindowTitle)){
                break;
            }

        }
    }

    public static void urlIleWindowGecisi( String hedefWindowUrl){
        // 1- acik tum window'larin whd'lerini kaydedelim
        Set<String> acikTumWindowlarinWhdSeti = Driver.getDriver().getWindowHandles();

        // 2- gecmek istedigimiz window'un title'ini kaydedelim
        // String hedefWindowTitle = "New Window";
        // yukarda parametre olarak var

        // 3- set'deki herbir whd'inin ait oldugu window'a gecis yapip
        //    gectigimiz window'un title'i hedefTitle ile ayni ise
        //    o window'da kalalim

        for (String eachWhd : acikTumWindowlarinWhdSeti){

            Driver.getDriver().switchTo().window(eachWhd);

            if (Driver.getDriver().getCurrentUrl().equals(hedefWindowUrl)){
                break;
            }

        }
    }

    public static void tumSayfaScreenshot(WebDriver driver) {
        // dosya ismine eklemek icin tarih etiketi olusturalim
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("_yyMMdd_HHmmss");
        String tarihEtiketi = ldt.format(formatter);


        // 1.adim TakesScreenshot objesi olusturun ve deger olarak driver'i atayip cast edin
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        // 2.adim : ekran goruntusunu kaydedecegimiz File'i olusturun
        //          parametre olarak kaydetmek istediginiz dosyanin, dosya yolunu girin
        File asilResim = new File("target/screenshots/tumSayfaScreenshot"+tarihEtiketi+".jpg");

        // 3.adim : olusturdugumuz takeScreenshot objesi ile ekran goruntusunu alip
        //          gecici bir File'a kaydedelim
        File geciciResim = takesScreenshot.getScreenshotAs(OutputType.FILE);

        // 4.adim : gecici dosyayi, asilResim dosyasina kopyalayin

        try {
            FileUtils.copyFile(geciciResim,asilResim);
        } catch (IOException e) {
            System.out.println("Ekran resmi alinamadi");
        }

    }

    public static void isimliTumSayfaScreenshot(WebDriver driver,String resimIsmi) {
        // dosya ismine eklemek icin tarih etiketi olusturalim
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("_yyMMdd_HHmmss");
        String tarihEtiketi = ldt.format(formatter);

        // 1.adim TakesScreenshot objesi olusturun ve deger olarak driver'i atayip cast edin
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        // 2.adim : ekran goruntusunu kaydedecegimiz File'i olusturun
        //          parametre olarak kaydetmek istediginiz dosyanin, dosya yolunu girin
        File asilResim = new File("target/screenshots/" + resimIsmi +tarihEtiketi+ ".jpg");

        // 3.adim : olusturdugumuz takeScreenshot objesi ile ekran goruntusunu alip
        //          gecici bir File'a kaydedelim
        File geciciResim = takesScreenshot.getScreenshotAs(OutputType.FILE);

        // 4.adim : gecici dosyayi, asilResim dosyasina kopyalayin

        try {
            FileUtils.copyFile(geciciResim,asilResim);
        } catch (IOException e) {
            System.out.println("Ekran resmi alinamadi");
        }

    }

    public static void webElementScreenshot(WebElement hedefElement){
        // dosya ismine eklemek icin tarih etiketi olusturalim
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("_yyMMdd_HHmmss");
        String tarihEtiketi = ldt.format(formatter);


        // 1.adim : screenshot alinmasi istenen Webelement'i locate edip kaydedin
        //          biz hedefElement'i parametre olarak aldik

        // 2.adim : screenshot'in kaydedilecegi asil File'i olusturun
        File asilResim = new File("target/screenshots/webelementScreenshot"+tarihEtiketi+".jpg");

        // 3.adim : resmini cekmek istediginiz webElement uzerinden
        //          getScreenshotAs() kullanin ve gecici dosyaya kaydedin
        File geciciResim = hedefElement.getScreenshotAs(OutputType.FILE);

        // 4.adim : FileUtils ile gecici dosyayi asilResim dosyasina kopyalayin

        try {
            FileUtils.copyFile(geciciResim,asilResim);
        } catch (IOException e) {
            System.out.println("Ekran resmi alinamadi");
        }
    }

    public static void isimliWebElementScreenshot(WebElement hedefElement, String resimIsmi){
        // dosya ismine eklemek icin tarih etiketi olusturalim
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("_yyMMdd_HHmmss");
        String tarihEtiketi = ldt.format(formatter);


        // 1.adim : screenshot alinmasi istenen Webelement'i locate edip kaydedin
        //          biz hedefElement'i parametre olarak aldik

        // 2.adim : screenshot'in kaydedilecegi asil File'i olusturun
        File asilResim = new File("target/screenshots/"+resimIsmi+tarihEtiketi+".jpg");

        // 3.adim : resmini cekmek istediginiz webElement uzerinden
        //          getScreenshotAs() kullanin ve gecici dosyaya kaydedin
        File geciciResim = hedefElement.getScreenshotAs(OutputType.FILE);

        // 4.adim : FileUtils ile gecici dosyayi asilResim dosyasina kopyalayin

        try {
            FileUtils.copyFile(geciciResim,asilResim);
        } catch (IOException e) {
            System.out.println("Ekran resmi alinamadi");
        }
    }

    public static String raporaResimEkle(String testIsmi) throws IOException {

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("_yyMMdd_HHmmss");
        String date = localDateTime.format(format); // _241219_080623

        // 1.adim tss objesi olusturalim
        //   ve takesScreenshot objesi ile gecici resmi kaydedelim
        TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
        File geciciDosya = takesScreenshot.getScreenshotAs(OutputType.FILE);

        // Asil resmi kaydedecegimiz dosya yolunu olusturup
        // bu dosya yolu ile resmi kaydedecegimiz asil dosyayi olusturalim
        String dosyaYolu = System.getProperty("user.dir") + "/test-output/Screenshots/" + testIsmi + date + ".jpg";
        File asilResimDosyasi = new File(dosyaYolu);
        // gecici dosyayi asil dosyaya kopyalayalim
        FileUtils.copyFile(geciciDosya, asilResimDosyasi);
        return dosyaYolu;
    }
    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }
}