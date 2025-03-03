Feature: Forceget register olma

Scenario: Kullanici kayit olup dogrulama kodu ile hesabini aktive eder
Given Kullanici kayit sayfasina gider
  When kullanici ismini girer
  And kullanici soyismini girer
  And kullanici ulke kodunu girer
  And kullanici telefon numarasi girer
  And kullanici sirket ismini girer
  And kullanici mail girer
  And kullanici gorevini girer
  And kullanici parolayi girer ve parolayi dogrular
  And kullanici hizmet sartlari ve gizlilik politikasini okur ve onaylar
  And kullanici  kayit ol tusuna basar ve kayit olur
  And kullanici mail dogrulamasini yapar
  And And kullanici yuklenen login sayfasında mail ve sifresini girip login olur
  Then kullanici anasayfaya giris yapar ve basariyla giris yaptigini dogrular







