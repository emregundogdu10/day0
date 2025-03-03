Feature: Forgecet register olma

Scenario: Kullanici kayit olup dogrulama kodu ile hesabini aktive eder
Given Kullanici kayit sayfasina gider
  When kullanici ismini girer
  When kullanici soyismini girer
  When kullanici ulke kodunu girer
  When kullanici telefon numarasi girer
  When kullanici sirket ismini girer
  When kullanici mail girer
  When kullanici gorevini girer
  When kullanici parola girer
  When kullanici login icin mail girer
  Then kullanici basariyla giris yaptigini dogrular







