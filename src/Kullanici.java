// Kullanici sınıfı tanımlanıyor.
public class Kullanici {
    // protected erişim belirteçleriyle tanımlanmış değişkenler (kullaniciAdi ve sifre).
    // Bu değişkenler, bu sınıfı miras alan alt sınıflar tarafından erişilebilir.
    protected String kullaniciAdi;
    protected String sifre;
    // Kullanici sınıfının yapıcı metodu (constructor).
    // Bu metod, Kullanici nesnesi oluşturulduğunda çalışır.
    // kullaniciAdi ve sifre parametrelerini alır ve sınıf değişkenlerine atar.
    public Kullanici(String kullaniciAdi, String sifre) {
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
    }
    // getKullaniciAdi metodu, kullaniciAdi değişkeninin değerini döndürür.
    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    // getSifre metodu, sifre değişkeninin değerini döndürür.
    public String getSifre() {
        return sifre;
    }
}
