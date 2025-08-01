// Bina sınıfı, Varlik sınıfından miras alır (extends).
public class Bina extends Varlik {

    // Özel (private) erişim belirteci ile kat sayısı ve akıllı bina bilgisi değişkenleri tanımlanıyor.
    private int katSayisi;
    private boolean akilli;

    // Bina sınıfının yapıcı metodu (constructor).
    // Bu metod, Bina nesnesi oluşturulduğunda çalışır.
    // ad, kat sayısı ve akıllı bina bilgisi parametrelerini alır ve üst sınıfın (Varlik)
    // yapıcı metodunu çağırır.
    public Bina(String ad, int katSayisi, boolean akilli) {
        super(ad, "Bina");
        this.katSayisi = katSayisi;
        this.akilli = akilli;
    }
    // getKatSayisi metodu, katSayisi değişkeninin değerini döndürür.
    public int getKatSayisi() {
        return katSayisi;
    }
    // setKatSayisi metodu, katSayisi değişkeninin değerini günceller.

    public void setKatSayisi(int katSayisi) {
        this.katSayisi = katSayisi;
    }
    // isAkilli metodu, akilli değişkeninin değerini döndürür.
    public boolean isAkilli() {
        return akilli;
    }
    // setAkilli metodu, akilli değişkeninin değerini günceller.
    public void setAkilli(boolean akilli) {
        this.akilli = akilli;
    }

    // toString metodu, Bina nesnesinin temsilini döndürür.
    // Bu metod, üst sınıfın (Varlik) toString metodunu çağırır ve kat sayısı ile akıllı
    // bina bilgisini ekler.
    @Override
    public String toString() {
        return super.toString() + ", Kat Sayısı: " + katSayisi + ", Akıllı: " + (akilli ? "Evet" :"Hayır");
    }
}


