// Vatandas sınıfı, Kullanici sınıfından miras alır (extends).
public class Vatandas extends Kullanici {

    // Vatandas sınıfının yapıcı metodu (constructor).
    // Bu metod, Vatandas nesnesi oluşturulduğunda çalışır.
    // Kullanıcı adı ve şifre parametrelerini alır.
    public Vatandas(String kullaniciAdi, String sifre) {

        // super anahtar kelimesi, üst sınıfın (Kullanici) yapıcı metodunu çağırır.
        // Bu durumda, Kullanici sınıfının yapıcı metoduna kullanıcı adı ve şifre parametrelerini
        // gönderir.
        super(kullaniciAdi, sifre);
    }

    // suDurumunuIzle metodu, su izleme hizmetini başlatır.
    public void suDurumunuIzle() {
        // Hizmet sınıfından bir su izleme nesnesi oluşturur.
        Hizmet suIzleme = new SuIzleme();
        // suIzleme nesnesinin izleme metodunu çağırır.
        suIzleme.izleme();
    }

    // trafikDurumunuIzle metodu, trafik izleme hizmetini başlatır.
    public void trafikDurumunuIzle() {
        // Hizmet sınıfından bir trafik izleme nesnesi oluşturur.
        Hizmet trafikIzleme = new TrafikIzleme();
        // trafikIzleme nesnesinin izleme metodunu çağırır.
        trafikIzleme.izleme();
    }

    // enerjiDurumunuIzle metodu, enerji izleme hizmetini başlatır.
    public void enerjiDurumunuIzle() {
        // Hizmet sınıfından bir enerji izleme nesnesi oluşturur.
        Hizmet enerjiIzleme = new EnerjiIzleme();
        // enerjiIzleme nesnesinin izleme metodunu çağırır.
        enerjiIzleme.izleme();
    }
}
