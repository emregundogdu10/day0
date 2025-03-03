package utilities;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CaptchaSolver {

    // 🔹 BURAYA API KEY'İNİ EKLEDİM!
    private static final String API_KEY = "dfd1dcc305ed7197b72ef24d2fb25168";

    // CAPTCHA Çözme Metodu
    public static String solveCaptcha(String siteKey, String pageUrl) throws InterruptedException {
        try {
            // CAPTCHA çözme isteğini API'ye gönder
            String requestUrl = "http://2captcha.com/in.php?key=" + API_KEY +
                    "&method=userrecaptcha&googlekey=" + siteKey + "&pageurl=" + pageUrl;
            URL url = new URL(requestUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            Scanner scanner = new Scanner(conn.getInputStream());
            String response = scanner.nextLine();
            scanner.close();

            if (!response.startsWith("OK|")) {
                return null; // CAPTCHA çözme başarısız
            }

            String captchaId = response.split("\\|")[1];

            // CAPTCHA çözülmesi için 15 saniye bekle
            Thread.sleep(15000);

            // CAPTCHA çözümünü al
            String resultUrl = "http://2captcha.com/res.php?key=" + API_KEY + "&action=get&id=" + captchaId;
            URL result = new URL(resultUrl);
            HttpURLConnection connResult = (HttpURLConnection) result.openConnection();
            connResult.setRequestMethod("GET");

            Scanner resultScanner = new Scanner(connResult.getInputStream());
            String resultResponse = resultScanner.nextLine();
            resultScanner.close();

            if (resultResponse.startsWith("OK|")) {
                return resultResponse.split("\\|")[1];
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
