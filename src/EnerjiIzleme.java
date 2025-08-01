// EnerjiIzleme sınıfı, Hizmet arayüzünü (interface) uyguluyor (implements).
public class EnerjiIzleme implements Hizmet {
    // Özel (private) erişim belirteci ile hizmet adı değişkeni tanımlanıyor.
    private String hizmetAdi;
    // EnerjiIzleme sınıfının yapıcı metodu (constructor).
    // Bu metod, EnerjiIzleme nesnesi oluşturulduğunda çalışır ve hizmet adını "Enerji İzleme"
    // olarak ayarlar.
    public EnerjiIzleme() {
        this.hizmetAdi = "Enerji İzleme";
    }
    // Hizmet arayüzünün getHizmetAdi metodunu uyguluyor.
    // Bu metod, hizmet adının değerini döndürür.
    @Override
    public String getHizmetAdi() {
        return hizmetAdi;
    }
    // Hizmet arayüzünün izleme metodunu uyguluyor.
    // Bu metod, enerji kullanımını izlemek için bir mesaj yazdırır.
    @Override
    public void izleme() {
        System.out.println("Enerji kullanımı izleniyor...");
    }
}

