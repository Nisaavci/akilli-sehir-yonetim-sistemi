// Soyut (abstract) Varlik sınıfı. Bu sınıf, diğer sınıflar için temel (base) olarak kullanılır.
public abstract class Varlik {

    // protected erişim belirteçleriyle tanımlanmış değişkenler (ad ve tur).
    // Bu değişkenler, bu sınıfı miras alan alt sınıflar tarafından erişilebilir.
    protected String ad;
    protected String tur;

    // Varlik sınıfının yapıcı metodu (constructor).
    // Bu metod, Varlik nesnesi oluşturulduğunda çalışır.
    // ad ve tur parametrelerini alır ve sınıf değişkenlerine atar.
    public Varlik(String ad, String tur) {
        this.ad = ad;
        this.tur = tur;
    }

    // getAd metodu, ad değişkeninin değerini döndürür.
    public String getAd() {
        return ad;
    }

    // setAd metodu, ad değişkeninin değerini günceller.
    public void setAd(String ad) {
        this.ad = ad;
    }

    // getTur metodu, tur değişkeninin değerini döndürür.
    public String getTur() {
        return tur;
    }

    // setTur metodu, tur değişkeninin değerini günceller.
    public void setTur(String tur) {
        this.tur = tur;
    }

    // toString metodu, Varlik nesnesinin temsilini döndürür.
    // Bu metod, nesnenin türünü ve adını içeren bir string oluşturur.
    @Override
    public String toString() {
        return tur + " Adı: " + ad;
    }
}
