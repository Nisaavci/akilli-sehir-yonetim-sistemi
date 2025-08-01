// TrafikIzleme sınıfı, Hizmet arayüzünü (interface) uyguluyor (implements).
public class TrafikIzleme implements Hizmet {
    // Özel (private) erişim belirteci ile hizmet adı değişkeni tanımlanıyor.
    private String hizmetAdi;
    // TrafikIzleme sınıfının yapıcı metodu (constructor).
    // Bu metod, TrafikIzleme nesnesi oluşturulduğunda çalışır ve hizmet adını "Trafik İzleme" olarak
    // ayarlar.
    public TrafikIzleme() {
        this.hizmetAdi = "Trafik İzleme";
    }
    // Hizmet arayüzünün getHizmetAdi metodunu uyguluyor.
    // Bu metod, hizmet adının değerini döndürür.
    @Override
    public String getHizmetAdi() {
        return hizmetAdi;
    }
    // Hizmet arayüzünün izleme metodunu uyguluyor.
    // Bu metod, trafik yoğunluğunu izlemek için bir mesaj yazdırır.
    @Override
    public void izleme() {
        System.out.println("Trafik yoğunluğu izleniyor...");
    }
}
