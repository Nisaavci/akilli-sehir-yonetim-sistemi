// SuIzleme sınıfı, Hizmet arayüzünü (interface) uyguluyor (implements).
public class SuIzleme implements Hizmet {
    // Özel (private) erişim belirteci ile hizmet adı değişkeni tanımlanıyor.
    private String hizmetAdi;
    // SuIzleme sınıfının yapıcı metodu (constructor).
    // Bu metod, SuIzleme nesnesi oluşturulduğunda çalışır ve hizmet adını "Su İzleme" olarak ayarlar.
    public SuIzleme() {
        this.hizmetAdi = "Su İzleme";
    }
    // Hizmet arayüzünün getHizmetAdi metodunu uyguluyor.
    // Bu metod, hizmet adının değerini döndürür.
    @Override
    public String getHizmetAdi() {
        return hizmetAdi;
    }
    // Hizmet arayüzünün izleme metodunu uyguluyor.
    // Bu metod, su seviyesini izlemek için bir mesaj yazdırır.
    @Override
    public void izleme() {
        System.out.println("Su seviyesi izleniyor...");
    }
}

