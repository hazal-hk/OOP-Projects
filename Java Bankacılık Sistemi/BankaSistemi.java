import java.util.*;

class Banka {
    private String ad;
    private String merkez;
    private List<Sube> subeler;
    private List<ATM> atmler;
    private List<Musteri> musteriler;
    
    public Banka(String ad, String merkez) {
        this.ad = ad;
        this.merkez = merkez;
        this.subeler = new ArrayList<>();
        this.atmler = new ArrayList<>();
        this.musteriler = new ArrayList<>();
    }
    
    public String getAd() { 
        return ad; 
    }
    public String getMerkez() { 
        return merkez; 
    }
    public List<Sube> getSubeler() { 
        return subeler; 
    }
    public List<ATM> getAtmler() { 
        return atmler; 
    }
    public List<Musteri> getMusteriler() { 
        return musteriler; 
    }
    
    public void subeEkle(Sube sube) {
        subeler.add(sube);
    }
    
    public void atmEkle(ATM atm) {
        atmler.add(atm);
    }
    
    public void musteriEkle(Musteri musteri) {
        musteriler.add(musteri);
    }
    
    public void bankaBilgileriniGoster() {
        System.out.println("Banka: " + ad + " - Merkez: " + merkez);
    }
}


class Sube {
    private String ad;
    private String adres;
    private Banka banka;
    
    public Sube(String ad, String adres, Banka banka) {
        this.ad = ad;
        this.adres = adres;
        this.banka = banka;
    }
    
    public String getAd() { 
        return ad; 
    }
    public String getAdres() { 
        return adres; 
    }
    public Banka getBanka() { 
        return banka; 
    }
    public void subeBilgileriniGoster() {
        System.out.println("Şube: " + ad, "Adres: " + adres);
    }
}

class ATM {
    private String seriNo;
    private String durum;
    private Banka banka;
    
    public ATM(String seriNo, Banka banka) {
        this.seriNo = seriNo;
        this.banka = banka;
        this.durum = "Aktif";
    }
    
    public String getSeriNo() { return seriNo; }
    public String getDurum() { return durum; }
    public Banka getBanka() { return banka; }
    
    public void paraYatir(Hesap hesap, double miktar) {
        System.out.println("ATM " + seriNo + " - " + miktar + " para yatiriliyor");
    }
    
    public void paraCek(Hesap hesap, double miktar) {
        System.out.println("ATM " + seriNo + " - " + miktar + " para çekiliyor");
    }
    
    public void atmBilgileriniGoster() {
        System.out.println("ATM: " + seriNo);
    }
}

class Musteri {
    private String tcKimlik;
    private String ad;
    private String soyad;
    private String telefon;
    private String email;
    private List<Hesap> hesaplar;
    
    public Musteri(String tcKimlik, String ad, String soyad, String telefon, String email) {
        this.tcKimlik = tcKimlik;
        this.ad = ad;
        this.soyad = soyad;
        this.telefon = telefon;
        this.email = email;
        this.hesaplar = new ArrayList<>();
    }
    
    public String getTcKimlik() { 
        return tcKimlik; 
    }
    public String getAd() { 
        return ad; 
    }
    public String getSoyad() { 
        return soyad; 
    }
    public String getTelefon() { 
        return telefon; 
    }
    public String getEmail() { 
        return email; 
    }
    public List<Hesap> getHesaplar() { 
        return hesaplar; 
    }
    
    public void hesapEkle(Hesap hesap) {
        hesaplar.add(hesap);
    }
    
    public void musteriBilgileriniGoster() {
        System.out.println("Müşteri: " + ad + " " + soyad + " - TC: " + tcKimlik);
    }
}

class Hesap {
    private String hesapNo;
    private double bakiye;
    private String paraBirimi;
    private String hesapTuru;
    private Musteri musteri;
    
    public Hesap(String hesapNo, double bakiye, String paraBirimi, String hesapTuru, Musteri musteri) {
        this.hesapNo = hesapNo;
        this.bakiye = bakiye;
        this.paraBirimi = paraBirimi;
        this.hesapTuru = hesapTuru;
        this.musteri = musteri;
    }
    
    public String getHesapNo() { 
        return hesapNo; 
    }
    public double getBakiye() { 
        return bakiye; 
    }
    public String getParaBirimi() { 
        return paraBirimi; 
    }
    public String getHesapTuru() { 
        return hesapTuru; 
    }
    public Musteri getMusteri() { 
        return musteri; 
    }
    
    public void transferEt(Hesap hedefHesap, double miktar) {
        System.out.println(hesapNo + " numarali hesaptan " + 
                         hedefHesap.getHesapNo() + " numarali hesaba " + 
                         miktar + " transfer ediliyor");
    }
    
    public void bakiyeGoster() {
        System.out.println(hesapNo + " - Bakiye: " + bakiye + " " + paraBirimi);
    }
    
    public void paraYatir(double miktar) {
        bakiye += miktar;
        System.out.println(miktar + " " + paraBirimi + " yatırıldı. Yeni bakiye: " + bakiye);
    }
    
    public void paraCek(double miktar) {
        if (bakiye >= miktar) {
            bakiye -= miktar;
            System.out.println(miktar + " " + paraBirimi + " çekildi. Yeni bakiye: " + bakiye);
        } else {
            System.out.println("Yetersiz bakiye!");
        }
    }
}

class MobilUygulama {
    private Banka banka;
    
    public MobilUygulama(Banka banka) {
        this.banka = banka;
    }
    
    public Banka getBanka() { return banka; }
    
    public void krediOdemeYap(Hesap hesap, double miktar) {
        System.out.println("Mobil uygulama üzerinden " + miktar + " kredi ödemesi yapiliyor");
    }
    
    public void bakiyeGoster(Hesap hesap) {
        System.out.println("Mobil uygulama - Hesap: " + hesap.getHesapNo() + 
                          " - Bakiye: " + hesap.getBakiye() + " " + hesap.getParaBirimi());
    }
}

public class BankaSistemi {
    public static void main(String[] args) {

        Banka banka = new Banka("HK Bank", "Trabzon");
        
        Sube sube1 = new Sube("SUBE1", "OF Şube", banka);
        Sube sube2 = new Sube("SUBE2", "Vakfikebir Şube", banka);
        
        ATM atm1 = new ATM("ATM1", banka);
        ATM atm2 = new ATM("ATM2", banka);
        
        Musteri musteri1 = new Musteri("12345678901", "Ali", "A", "0555 111 1111", "ali@email.com");
        Musteri musteri2 = new Musteri("12345678902", "Ayşe", "B", "0555 222 2222", "ayse@email.com");
        Musteri musteri3 = new Musteri("12345678903", "Mehmet", "C", "0555 333 3333", "mehmet@email.com");
        
        Hesap hesap1 = new Hesap("TR001", 5000.0, "TL", "Vadeli", musteri1);
        Hesap hesap2 = new Hesap("TR002", 10000.0, "TL", "Vadesiz", musteri2);
        Hesap hesap3 = new Hesap("TR003", 2500.0, "USD", "Vadeli", musteri1);
        Hesap hesap4 = new Hesap("TR004", 7500.0, "TL", "Vadesiz", musteri3);
        
        banka.subeEkle(sube1);
        banka.subeEkle(sube2);
        banka.atmEkle(atm1);
        banka.atmEkle(atm2);
        banka.musteriEkle(musteri1);
        banka.musteriEkle(musteri2);
        banka.musteriEkle(musteri3);
        
        musteri1.hesapEkle(hesap1);
        musteri1.hesapEkle(hesap3);
        musteri2.hesapEkle(hesap2);
        musteri3.hesapEkle(hesap4);
        
        MobilUygulama mobilApp = new MobilUygulama(banka);
        
        System.out.println("HK BANKACILIK'A HOSGELDINIZ");
        
        mobilApp.krediOdemeYap(hesap1, 1000.0);
        
        mobilApp.bakiyeGoster(hesap1);
        mobilApp.bakiyeGoster(hesap3);
        
        atm1.paraYatir(hesap2, 500.0);

        atm2.paraCek(hesap4, 200.0);
        
        hesap1.transferEt(hesap2, 750.0);
          
        System.out.println("\n HESAP BAKİYE");
        hesap1.bakiyeGoster();
        hesap2.bakiyeGoster();
        hesap3.bakiyeGoster();
        hesap4.bakiyeGoster();
    }
}