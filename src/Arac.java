// Arac sınıfı, Varlik sınıfından miras alır (extends).
public class Arac extends Varlik {

    // Özel (private) erişim belirteci ile kapasite ve elektrikli bilgi değişkenleri tanımlanıyor.
    private int kapasite;
    private boolean elektrikli;

    // Arac sınıfının yapıcı metodu (constructor).
    // Bu metod, Arac nesnesi oluşturulduğunda çalışır.
    // ad, kapasite ve elektrikli bilgi parametrelerini alır ve üst sınıfın (Varlik)
    // yapıcı metodunu çağırır.
    public Arac(String ad, int kapasite, boolean elektrikli) {
        super(ad, "Araç");
        this.kapasite = kapasite;
        this.elektrikli = elektrikli;
    }

    // getKapasite metodu, kapasite değişkeninin değerini döndürür.
    public int getKapasite() {
        return kapasite;
    }

    // setKapasite metodu, kapasite değişkeninin değerini günceller.
    public void setKapasite(int kapasite) {
        this.kapasite = kapasite;
    }

    // isElektrikli metodu, elektrikli değişkeninin değerini döndürür.
    public boolean isElektrikli() {
        return elektrikli;
    }
    // setElektrikli metodu, elektrikli değişkeninin değerini günceller.
    public void setElektrikli(boolean elektrikli) {
        this.elektrikli = elektrikli;
    }
    // toString metodu, Arac nesnesinin temsilini döndürür.
    // Bu metod, üst sınıfın (Varlik) toString metodunu çağırır ve kapasite ile
    // elektrikli bilgilerini ekler.
    @Override
    public String toString() {
        return super.toString() + ", Kapasite: " + kapasite + ", Elektrikli: " + (elektrikli ? "Evet":
                "Hayır");
    }
}
