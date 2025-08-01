// Hizmet arayüzü (interface) tanımlanıyor.
// Bu arayüz, implement eden sınıfların içermesi gereken metodları belirtir.
public interface Hizmet {

    // getHizmetAdi metodu, hizmet adının değerini döndürmelidir.
    String getHizmetAdi();

    // izleme metodu, izleme işlemi gerçekleştirilmelidir.
    void izleme();
}
