Forceget Kayıt & Giriş Otomasyon Testi

Bu proje, Selenium ve Cucumber kullanılarak Forceget platformundaki kayıt ve giriş süreçlerinin test otomasyonunu gerçekleştirmektedir.
CAPTCHA doğrulama süreci Driver Class üzerinden geçilmiş ve giriş sonrası müşteri adı doğrulaması yapılmıştır.

Test Senaryosu

Kayıt Sayfası (/system/account/register)
Test otomasyonu, kayıt formundaki gerekli alanları otomatik olarak doldurur.
CAPTCHA doğrulaması Driver Class ile geçilir.
Kullanıcı başarılı şekilde login ekranına yönlendirilir.
Giriş Yapma (/system/account/login)
Otomasyon, kayıt sırasında girilen e-posta ve şifreyi kullanarak giriş yapar.
"Welcome, [Müşteri Adı]" mesajı doğrulanır.

Test Başarısı
Test, giriş sonrası müşteri adının doğrulanmasıyla tamamlanır.
Cucumber Runner'da tüm adımların PASS olduğu görülür.


Kullanılan Teknolojiler
Selenium WebDriver – Web otomasyon testi
Cucumber (BDD) – Gherkin dili ile senaryo yazımı
Maven – Proje bağımlılık yönetimi
WebDriver Manager – Tarayıcı sürücü yönetimi

Geliştirme Notları
CAPTCHA doğrulaması Chrome Options ile devre dışı bırakılarak geçildi.
Başarılı login sonrası Müşteri Adı doğrulaması ile test tamamlandı.
Cucumber Feature dosyaları Gherkin diliyle yazılmıştır.
