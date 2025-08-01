// EnerjiKaynagi sınıfı, Varlik sınıfından miras alır (extends).
class EnerjiKaynagi extends Varlik {
    // Özel (private) erişim belirteci ile kapasite değişkeni tanımlanıyor.
    private int kapasite;
    // EnerjiKaynagi sınıfının yapıcı metodu (constructor).
    // Bu metod, EnerjiKaynagi nesnesi oluşturulduğunda çalışır.
    // ad ve kapasite parametrelerini alır ve üst sınıfın (Varlik) yapıcı metodunu çağırır.
    public EnerjiKaynagi(String ad, int kapasite) {
        super(ad, "Enerji Kaynağı");
        this.kapasite = kapasite;
    }// getKapasite metodu, kapasite değişkeninin değerini döndürür.
    public int getKapasite() {
        return kapasite;
    }
    // setKapasite metodu, kapasite değişkeninin değerini günceller.
    public void setKapasite(int kapasite) {
        this.kapasite = kapasite;
    }
    // toString metodu, EnerjiKaynagi nesnesinin temsilini döndürür.
    // Bu metod, üst sınıfın (Varlik) toString metodunu çağırır ve kapasite bilgisini ekler.
    @Override
    public String toString() {
        return super.toString() + ", Kapasite: " + kapasite + " kW";}}

