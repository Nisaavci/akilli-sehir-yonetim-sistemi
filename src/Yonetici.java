// Yönetici sınıfı Kullanici sınıfından miras alır (extends).
public class Yonetici extends Kullanici {

    // Yonetici sınıfının yapıcı metodu (constructor).
    // Bu metod, Yonetici nesnesi oluşturulduğunda çalışır.
    // Kullanıcı adı ve şifre parametrelerini alır.
    public Yonetici(String kullaniciAdi, String sifre) {
        // super anahtar kelimesi, üst sınıfın (Kullanici) yapıcı metodunu çağırır.
        // Bu durumda, Kullanici sınıfının yapıcı metoduna kullanıcı adı ve şifre parametrelerini
        // gönderir.
        super(kullaniciAdi, sifre);
    }
}
