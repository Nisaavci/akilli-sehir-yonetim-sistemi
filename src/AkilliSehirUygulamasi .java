import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// AkilliSehirUygulamasi sınıfı JFrame sınıfından miras alır (extends).
class AkilliSehirUygulamasi extends JFrame {

    // Özel (private) erişim belirteci ile varliklar ve kullanicilar listeleri tanımlanıyor.
    private List<Varlik> varliklar;
    private List<Kullanici> kullanicilar;

    // AkilliSehirUygulamasi sınıfının yapıcı metodu (constructor).
    // Bu metod, AkilliSehirUygulamasi nesnesi oluşturulduğunda çalışır.
    public AkilliSehirUygulamasi() {
        varliklar = new ArrayList<>(); // Varlik listesi başlatılıyor.
        kullanicilar = new ArrayList<>(); // Kullanici listesi başlatılıyor.
        kullanicilariBaslat(); // Kullanici listesi dolduruluyor.
        varliklariBaslat(); // Varlik listesi dolduruluyor.

        setTitle("Giriş Ekranı"); // Pencere başlığı ayarlanıyor.
        setSize(300, 200); // Pencere boyutu ayarlanıyor.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Pencere kapatıldığında
        // uygulama sonlandırılıyor.
        setLocationRelativeTo(null); // Pencere ekranın ortasına yerleştiriliyor.
        setLayout(new GridLayout(3, 2)); // Pencere düzeni 3x2 ızgara şeklinde ayarlanıyor.

        JLabel kullaniciAdiEtiketi = new JLabel("Kullanıcı Adı:"); // Kullanıcı adı
        // etiketi oluşturuluyor.
        JTextField kullaniciAdiAlani = new JTextField(); // Kullanıcı adı girişi için metin
        // alanı oluşturuluyor.
        JLabel sifreEtiketi = new JLabel("Şifre:"); // Şifre etiketi oluşturuluyor.
        JPasswordField sifreAlani = new JPasswordField(); // Şifre girişi için parola alanı oluşturuluyor.
        JButton girisButonu = new JButton("Giriş Yap"); // Giriş yap butonu oluşturuluyor.

        // Giriş yap butonuna tıklama olayı için dinleyici ekleniyor.
        girisButonu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String kullaniciAdi = kullaniciAdiAlani.getText(); // Kullanıcı adı alınıyor.
                String sifre = new String(sifreAlani.getPassword()); // Şifre alınıyor.

                // Kullanıcı listesi üzerinde döngü yapılıyor.
                for (Kullanici kullanici : kullanicilar) {
                    // Kullanıcı adı ve şifre kontrol ediliyor.
                    if (kullanici.getKullaniciAdi().equals(kullaniciAdi) && kullanici.getSifre().equals(sifre)) {
                        // Eğer kullanıcı Yonetici ise, yoneticiPaneliniGoster metodu çağırılıyor.
                        if (kullanici instanceof Yonetici) {
                            yoneticiPaneliniGoster();
                            // Eğer kullanıcı Vatandas ise, vatandasPaneliniGoster metodu çağırılıyor.
                        } else if (kullanici instanceof Vatandas) {
                            vatandasPaneliniGoster();
                        }
                        return; // Eğer doğru kullanıcı bulunduysa döngüden çıkılıyor.
                    }
                }
                // Eğer kullanıcı adı veya şifre yanlış ise hata mesajı gösteriliyor.
                JOptionPane.showMessageDialog(AkilliSehirUygulamasi.this,
                        "Geçersiz kullanıcı adı veya şifre", "Hata", JOptionPane.ERROR_MESSAGE);
            }
        });

        add(kullaniciAdiEtiketi); // Kullanıcı adı etiketi pencereye ekleniyor.
        add(kullaniciAdiAlani); // Kullanıcı adı metin alanı pencereye ekleniyor.
        add(sifreEtiketi); // Şifre etiketi pencereye ekleniyor.
        add(sifreAlani); // Şifre parola alanı pencereye ekleniyor.
        add(new JLabel()); // Boş etiket aralığı pencereye ekleniyor.
        add(girisButonu); // Giriş yap butonu pencereye ekleniyor.
    }
    // Kullanıcıları başlatır ve önceden tanımlanmış kullanıcıları ekler
    private void kullanicilariBaslat() {
        kullanicilar.add(new Yonetici("admin", "admin123")); // Yonetici ekler
        kullanicilar.add(new Vatandas("vatandas", "vatandas123")); // Vatandas ekler
    }

    // Varlıkları başlatır ve önceden tanımlanmış varlıkları ekler
    private void varliklariBaslat() {
        varliklar.add(new Arac("Otobüs", 50, false)); // Otobüs ekler
        varliklar.add(new Arac("Elektrikli Araç", 4, true)); // Elektrikli araç ekler
        varliklar.add(new Bina("Akıllı Bina", 5, true)); // Akıllı bina ekler
        varliklar.add(new Bina("Geleneksel Bina", 3, false)); // Geleneksel bina ekler
        varliklar.add(new EnerjiKaynagi("Güneş Enerjisi", 500)); // Güneş enerjisi kaynağı ekler
        varliklar.add(new EnerjiKaynagi("Rüzgar Enerjisi", 300)); // Rüzgar enerjisi kaynağı ekler
    }

    // Yönetici panelini oluşturur ve gösterir
    private void yoneticiPaneliniGoster() {
        JFrame yoneticiFrame = new JFrame("Yönetici Paneli");
        yoneticiFrame.setSize(400, 300);
        yoneticiFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        yoneticiFrame.setLocationRelativeTo(null);
        yoneticiFrame.setLayout(new GridLayout(7, 1)); // 7 satırlık grid yerleşimi kullanır

        // Butonlar oluşturulup eylemleri tanımlanır
        JButton varlikEkleButonu = new JButton("Varlık Ekle");
        JButton varlikGuncelleButonu = new JButton("Varlık Güncelle");
        JButton varliklariGoruntuleButonu = new JButton("Varlıkları Görüntüle");
        JButton hizmetleriIzleButonu = new JButton("Hizmetleri İzle");
        JButton raporOlusturButonu = new JButton("Rapor Oluştur");
        JButton uyariYonetButonu = new JButton("Uyarıları Yönet");

        // Butonlara tıklama olayları eklenir
        varlikEkleButonu.addActionListener(e -> varlikEklePaneliniGoster());
        varlikGuncelleButonu.addActionListener(e -> varlikGuncellePaneliniGoster());
        varliklariGoruntuleButonu.addActionListener(e -> JOptionPane.showMessageDialog
                (yoneticiFrame, varlikListesiniAl(),
                "Mevcut Varlıklar", JOptionPane.INFORMATION_MESSAGE));
        hizmetleriIzleButonu.addActionListener(e -> hizmetleriIzlePaneliniGoster());
        raporOlusturButonu.addActionListener(e -> raporOlustur());
        uyariYonetButonu.addActionListener(e -> uyariYonet());

        // Butonlar panele eklenir
        yoneticiFrame.add(varlikEkleButonu);
        yoneticiFrame.add(varlikGuncelleButonu);
        yoneticiFrame.add(varliklariGoruntuleButonu);
        yoneticiFrame.add(hizmetleriIzleButonu);
        yoneticiFrame.add(raporOlusturButonu);
        yoneticiFrame.add(uyariYonetButonu);

        // Panel görünür hale getirilir
        yoneticiFrame.setVisible(true);
        dispose(); // Mevcut pencereyi kapatır
    }
    // Vatandaş panelini oluşturur ve gösterir
    private void vatandasPaneliniGoster() {
        // Yeni bir JFrame penceresi oluşturulur
        JFrame vatandasFrame = new JFrame("Vatandaş Paneli");
        // Pencere boyutu ayarlanır
        vatandasFrame.setSize(400, 300);
        // Pencere kapatıldığında kaynakları serbest bırakmak için ayarlama yapılır
        vatandasFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Pencere ortalanır
        vatandasFrame.setLocationRelativeTo(null);
        // Pencereye 3 satır, 1 sütundan oluşan bir grid düzeni uygulanır
        vatandasFrame.setLayout(new GridLayout(3, 1));

        // Trafik bilgisi görüntüleme butonu oluşturulur
        JButton trafikBilgisiGoruntuleButonu = new JButton("Trafik Bilgisi Görüntüle");
        // Enerji raporu görüntüleme butonu oluşturulur
        JButton enerjiRaporuGoruntuleButonu = new JButton("Enerji Raporu Görüntüle");
        // Su durumu görüntüleme butonu oluşturulur
        JButton suDurumuGoruntuleButonu = new JButton("Su Durumu Görüntüle");

        // Trafik bilgisi görüntüleme butonuna tıklama olayı eklenir
        trafikBilgisiGoruntuleButonu.addActionListener(e -> JOptionPane.showMessageDialog
                (vatandasFrame, "Trafik Yoğunluğu: "
                        + (new Random().nextInt(100) + 1) + "%"));
        // Enerji raporu görüntüleme butonuna tıklama olayı eklenir
        enerjiRaporuGoruntuleButonu.addActionListener(e -> JOptionPane.showMessageDialog
                (vatandasFrame, "Enerji Kullanımı: " + (new Random().nextInt(1000) + 1) + " kW"));
        // Su durumu görüntüleme butonuna tıklama olayı eklenir
        suDurumuGoruntuleButonu.addActionListener(e -> JOptionPane.showMessageDialog
                (vatandasFrame, "Su Seviyesi: " + (new Random().nextInt(100) + 1) + " cm"));

        // Butonlar panele eklenir
        vatandasFrame.add(trafikBilgisiGoruntuleButonu);
        vatandasFrame.add(enerjiRaporuGoruntuleButonu);
        vatandasFrame.add(suDurumuGoruntuleButonu);

        // Panel görünür hale getirilir
        vatandasFrame.setVisible(true);
        // Mevcut pencere kapatılır
        dispose();
    }

    // Yeni varlık ekleme panelini oluşturur ve gösterir
    private void varlikEklePaneliniGoster() {
        // Yeni bir JFrame penceresi oluşturulur
        JFrame varlikEklePenceresi = new JFrame("Varlık Ekle");
        // Pencere boyutu ayarlanır
        varlikEklePenceresi.setSize(300, 200);
        // Pencere kapatıldığında kaynakları serbest bırakmak için ayarlama yapılır
        varlikEklePenceresi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Pencere ortalanır
        varlikEklePenceresi.setLocationRelativeTo(null);
        // Pencereye 5 satır, 2 sütundan oluşan bir grid düzeni uygulanır
        varlikEklePenceresi.setLayout(new GridLayout(5, 2));

        // Form elemanları oluşturulur
        JLabel varlikTuruEtiketi = new JLabel("Varlık Türü:"); // Varlık türü etiketi
        JComboBox<String> varlikTuruComboBox = new JComboBox<>(new String[]{"Araç", "Bina",
                "Enerji Kaynağı"}); // Varlık türü seçimi için combo box
        JLabel varlikAdiEtiketi = new JLabel("Varlık Adı:"); // Varlık adı etiketi
        JTextField varlikAdiAlani = new JTextField(); // Varlık adı girişi için metin alanı
        JLabel kapasiteEtiketi = new JLabel("Kapasite/Kat:"); // Kapasite etiketi
        JTextField kapasiteAlani = new JTextField(); // Kapasite girişi için metin alanı
        JLabel elektrikliMiAkilliMiEtiketi = new JLabel("Elektrikli/Akıllı:"); // Elektrikli
        // /Akıllı bilgisi etiketi
        JCheckBox elektrikliMiAkilliMiCheckBox = new JCheckBox(); // Elektrikli/Akıllı bilgisi için
        // kontrol kutusu
        JButton ekleButonu = new JButton("Ekle"); // Ekle butonu

        // Ekle butonuna tıklama olayı eklenir
        ekleButonu.addActionListener(e -> {
            // Form alanlarından bilgiler alınır
            String varlikTuru = (String) varlikTuruComboBox.getSelectedItem();
            String varlikAdi = varlikAdiAlani.getText();
            String kapasite = kapasiteAlani.getText();
            boolean elektrikliMiAkilliMi = elektrikliMiAkilliMiCheckBox.isSelected();
            Varlik yeniVarlik = null;

            // Gerekli bilgiler kontrol edilir ve yeni varlık oluşturulur
            if (varlikTuru != null && !varlikAdi.isEmpty() && !kapasite.isEmpty()) {
                try {
                    int kapasiteDegeri = Integer.parseInt(kapasite);
                    // Varlık türüne göre yeni varlık oluşturulur
                    switch (varlikTuru) {
                        case "Araç":
                            yeniVarlik = new Arac(varlikAdi, kapasiteDegeri, elektrikliMiAkilliMi);
                            break;
                        case "Bina":
                            yeniVarlik = new Bina(varlikAdi, kapasiteDegeri, elektrikliMiAkilliMi);
                            break;
                        case "Enerji Kaynağı":
                            yeniVarlik = new EnerjiKaynagi(varlikAdi, kapasiteDegeri);
                            break;
                    }
                    if (yeniVarlik != null) {
                        // Yeni varlık listeye eklenir
                        varliklar.add(yeniVarlik);
                        // Kullanıcıya başarı mesajı gösterilir
                        JOptionPane.showMessageDialog(varlikEklePenceresi, "Yeni varlık eklendi:\n"
                                + yeniVarlik.toString(), "Bilgi", JOptionPane.INFORMATION_MESSAGE);
                        // Pencere kapatılır
                        varlikEklePenceresi.dispose();
                    }
                } catch (NumberFormatException ex) {
                    // Kapasite/Kat alanına geçersiz bir değer girilirse hata mesajı gösterilir
                    JOptionPane.showMessageDialog(varlikEklePenceresi,
                            "Kapasite/Kat alanına sayısal bir değer giriniz.",
                            "Hata", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // Tüm alanlar doldurulmadıysa hata mesajı gösterilir
                JOptionPane.showMessageDialog(varlikEklePenceresi,
                        "Lütfen tüm alanları doldurun.", "Hata", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Form elemanları panele eklenir
        varlikEklePenceresi.add(varlikTuruEtiketi);
        varlikEklePenceresi.add(varlikTuruComboBox);
        varlikEklePenceresi.add(varlikAdiEtiketi);
        varlikEklePenceresi.add(varlikAdiAlani);
        varlikEklePenceresi.add(kapasiteEtiketi);
        varlikEklePenceresi.add(kapasiteAlani);
        varlikEklePenceresi.add(elektrikliMiAkilliMiEtiketi);
        varlikEklePenceresi.add(elektrikliMiAkilliMiCheckBox);
        varlikEklePenceresi.add(new JLabel()); // Boş etiket aralığı için
        varlikEklePenceresi.add(ekleButonu);

        // Panel görünür hale getirilir
        varlikEklePenceresi.setVisible(true);
    }


    // Varlık güncelleme panelini oluşturur ve gösterir
    private void varlikGuncellePaneliniGoster() {
        // Yeni bir JFrame penceresi oluşturulur ve başlık "Varlık Güncelle" olarak ayarlanır
        JFrame guncellemePenceresi = new JFrame("Varlık Güncelle");
        // Pencere boyutu 300x200 piksel olarak ayarlanır
        guncellemePenceresi.setSize(300, 200);
        // Pencere kapatıldığında kaynakları serbest bırakmak için ayarlama yapılır
        guncellemePenceresi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Pencere ekranın ortasında açılacak şekilde ayarlanır
        guncellemePenceresi.setLocationRelativeTo(null);
        // Pencereye 5 satır ve 3 sütundan oluşan bir grid düzeni uygulanır
        guncellemePenceresi.setLayout(new GridLayout(5, 3));

        // Varlık seçimi için etiket oluşturulur
        JLabel varlikSecEtiketi = new JLabel("Varlık Seç:");
        // Varlıkları görüntülemek için comboBox oluşturulur ve varlık listesindeki varlıklar eklenir
        JComboBox<String> varlikComboBox = new JComboBox<>
                (varliklar.stream().map(Varlik::toString).toArray(String[]::new));
        // Yeni varlık adı girişi için etiket oluşturulur
        JLabel yeniVarlikAdiEtiketi = new JLabel("Yeni Varlık Adı:");
        // Yeni varlık adı girişi için metin alanı oluşturulur
        JTextField yeniVarlikAdiAlani = new JTextField();
        // Yeni kapasite girişi için etiket oluşturulur
        JLabel yeniKapasiteEtiketi = new JLabel("Yeni Kapasite:");
        // Yeni kapasite girişi için metin alanı oluşturulur
        JTextField yeniKapasiteAlani = new JTextField();
        // Yeni elektrikli/akıllı durumu için etiket oluşturulur
        JLabel yeniElektrikliMiAkilliMiEtiketi = new JLabel("Yeni Elektrikli/Akıllı:");
        // Yeni elektrikli/akıllı durumu için kontrol kutusu oluşturulur
        JCheckBox yeniElektrikliMiAkilliMiCheckBox = new JCheckBox();
        // Güncelleme işlemi için buton oluşturulur
        JButton guncelleButonu = new JButton("Güncelle");

        // Güncelle butonuna tıklama olayı eklenir
        guncelleButonu.addActionListener(e -> {
            // Seçilen varlığın indeksini al
            int secilenIndeks = varlikComboBox.getSelectedIndex();
            // Eğer varlık seçilmemişse hata mesajı gösterilir
            if (secilenIndeks == -1) {
                JOptionPane.showMessageDialog(guncellemePenceresi,
                        "Lütfen bir varlık seçin.", "Hata", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Form alanlarından bilgiler alınır
            String yeniVarlikAdi = yeniVarlikAdiAlani.getText().trim();
            String yeniKapasite = yeniKapasiteAlani.getText().trim();
            boolean yeniElektrikliMiAkilliMi = yeniElektrikliMiAkilliMiCheckBox.isSelected();

            // Eğer gerekli alanlar boşsa hata mesajı gösterilir
            if (yeniVarlikAdi.isEmpty() || yeniKapasite.isEmpty()) {
                JOptionPane.showMessageDialog(guncellemePenceresi, "Lütfen tüm alanları doldurun.",
                        "Hata", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                // Kapasite alanının sayısal olup olmadığını kontrol et
                int kapasite = Integer.parseInt(yeniKapasite);
                Varlik secilenVarlik = varliklar.get(secilenIndeks);

                // Seçilen varlık türüne göre güncelleme yapılır
                if (secilenVarlik instanceof Arac) {
                    ((Arac) secilenVarlik).setAd(yeniVarlikAdi);
                    ((Arac) secilenVarlik).setKapasite(kapasite);
                    ((Arac) secilenVarlik).setElektrikli(yeniElektrikliMiAkilliMi);
                } else if (secilenVarlik instanceof Bina) {
                    ((Bina) secilenVarlik).setAd(yeniVarlikAdi);
                    ((Bina) secilenVarlik).setKatSayisi(kapasite);
                    ((Bina) secilenVarlik).setAkilli(yeniElektrikliMiAkilliMi);
                } else if (secilenVarlik instanceof EnerjiKaynagi) {
                    ((EnerjiKaynagi) secilenVarlik).setAd(yeniVarlikAdi);
                    ((EnerjiKaynagi) secilenVarlik).setKapasite(kapasite);
                } else {
                    // Bilinmeyen varlık türü için hata mesajı gösterilir
                    JOptionPane.showMessageDialog(guncellemePenceresi,
                            "Bilinmeyen varlık türü.", "Hata", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Güncellenen varlıklar combo box modeline yeniden eklenir ve seçim sıfırlanır
                varlikComboBox.setModel(new DefaultComboBoxModel<>
                        (varliklar.stream().map(Varlik::toString).toArray(String[]::new)));
                varlikComboBox.setSelectedIndex(-1); // Seçimi sıfırla
                // Başarı mesajı gösterilir
                JOptionPane.showMessageDialog(guncellemePenceresi, "Varlık başarıyla güncellendi!",
                        "Bilgi", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                // Kapasite alanına geçersiz bir değer girilirse hata mesajı gösterilir
                JOptionPane.showMessageDialog(guncellemePenceresi,
                        "Kapasite alanına sayısal bir değer giriniz.",
                        "Hata", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Form elemanları panele eklenir
        guncellemePenceresi.add(varlikSecEtiketi);
        guncellemePenceresi.add(varlikComboBox);
        guncellemePenceresi.add(yeniVarlikAdiEtiketi);
        guncellemePenceresi.add(yeniVarlikAdiAlani);
        guncellemePenceresi.add(yeniKapasiteEtiketi);
        guncellemePenceresi.add(yeniKapasiteAlani);
        guncellemePenceresi.add(yeniElektrikliMiAkilliMiEtiketi);
        guncellemePenceresi.add(yeniElektrikliMiAkilliMiCheckBox);
        guncellemePenceresi.add(new JLabel()); // Boş etiket aralığı
        guncellemePenceresi.add(guncelleButonu);

        // Panel görünür hale getirilir
        guncellemePenceresi.setVisible(true);
    }


    // Mevcut varlıkları listeleyen bir metot
    private String varlikListesiniAl() {
        // Eğer varlık listesi boşsa, uygun bir mesaj döner
        if (varliklar.isEmpty()) {
            return "Varlık bulunmamaktadır.";
        }
        // Varlık listesi oluşturulur
        StringBuilder varlikListesi = new StringBuilder("Mevcut Varlıklar:\n");
        // Her bir varlık listeye eklenir
        for (Varlik varlik : varliklar) {
            varlikListesi.append(varlik.toString()).append("\n");
        }
        // Varlık listesini döner
        return varlikListesi.toString();
    }

    // Hizmetleri izleme panelini oluşturur ve gösterir
    private void hizmetleriIzlePaneliniGoster() {
        // Yeni bir JFrame penceresi oluşturulur
        JFrame hizmetFrame = new JFrame("Hizmetleri İzle");
        // Pencere boyutu ayarlanır
        hizmetFrame.setSize(300, 200);
        // Pencere kapatıldığında kaynakları serbest bırakmak için ayarlama yapılır
        hizmetFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Pencere ekranın ortasında açılacak şekilde ayarlanır
        hizmetFrame.setLocationRelativeTo(null);
        // Pencereye 3 satır, 1 sütundan oluşan bir grid düzeni uygulanır
        hizmetFrame.setLayout(new GridLayout(3, 1));

        // Trafik yoğunluğunu gösteren etiket oluşturulur ve rastgele bir değer atanır
        JLabel trafikLabel = new JLabel("Trafik Yoğunluğu: "
                + (new Random().nextInt(100) + 1) + "%");
        // Enerji kullanımını gösteren etiket oluşturulur ve rastgele bir değer atanır
        JLabel enerjiLabel = new JLabel("Enerji Kullanımı: "
                + (new Random().nextInt(1000) + 1) + " kW");
        // Su seviyesini gösteren etiket oluşturulur ve rastgele bir değer atanır
        JLabel suLabel = new JLabel("Su Seviyesi: "
                + (new Random().nextInt(100) + 1) + " cm");

        // Etiketler panele eklenir
        hizmetFrame.add(trafikLabel);
        hizmetFrame.add(enerjiLabel);
        hizmetFrame.add(suLabel);

        // Panel görünür hale getirilir
        hizmetFrame.setVisible(true);
    }

    // Rapor oluşturma penceresini oluşturur ve gösterir
    private void raporOlustur() {
        // Yeni bir JFrame penceresi oluşturulur
        JFrame raporFrame = new JFrame("Rapor Oluştur");
        // Pencere boyutu ayarlanır
        raporFrame.setSize(600, 400);
        // Pencere kapatıldığında kaynakları serbest bırakmak için ayarlama yapılır
        raporFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Pencere ekranın ortasında açılacak şekilde ayarlanır
        raporFrame.setLocationRelativeTo(null);
        // Pencereye border layout düzeni uygulanır
        raporFrame.setLayout(new BorderLayout());

        // Mevcut tarih ve saat alınır
        String currentDateTime = java.time.LocalDateTime.now().
                format(java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
        // Rapor başlığı oluşturulur ve ortalanır
        JLabel raporTitle = new JLabel("Rapor - " + currentDateTime, JLabel.CENTER);
        // Başlık fontu ayarlanır
        raporTitle.setFont(new Font("Arial", Font.BOLD, 18));
        // Başlık kenarlıkları ayarlanır
        raporTitle.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Grafik paneli oluşturulur ve içerik eklenir
        JPanel chartPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Rastgele veri ve kategoriler oluşturulur
                int[] data = {new Random().nextInt(100),
                        new Random().nextInt(100), new Random().nextInt(100)};
                String[] categories = {"Trafik", "Enerji", "Su"};
                Color[] colors = {Color.BLUE, Color.GREEN, Color.ORANGE};

                // Panel boyutları ve çubuk genişliği hesaplanır
                int width = getWidth();
                int height = getHeight();
                int margin = 50;
                int barWidth = (width - (2 * margin)) / (data.length * 2);

                // Çubukların maksimum yüksekliği hesaplanır ve çizilir
                int maxBarHeight = height - 2 * margin;
                for (int i = 0; i < data.length; i++) {
                    int barHeight = (data[i] * maxBarHeight) / 100;
                    int x = margin + i * 2 * barWidth;
                    int y = height - margin - barHeight;

                    // Çubukların rengi ve kenarlıkları çizilir
                    g.setColor(colors[i]);
                    g.fillRect(x, y, barWidth, barHeight);
                    g.setColor(Color.BLACK);
                    g.drawRect(x, y, barWidth, barHeight);

                    // Kategoriler ve veri değerleri yazdırılır
                    g.drawString(categories[i], x + barWidth / 4, height - margin + 15);
                    g.drawString(data[i] + "%", x + barWidth / 4, y - 5);
                }
            }
        };

        // Grafik paneli boyutu ayarlanır
        chartPanel.setPreferredSize(new Dimension(600, 300));

        // Rapor alt metni oluşturulur ve ortalanır
        JLabel footerLabel = new JLabel("Bu rapor AkilliSehirUygulamasi tarafından oluşturulmuştur."
                , JLabel.CENTER);
        // Alt metnin fontu ve kenarlıkları ayarlanır
        footerLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        footerLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Rapor bileşenleri panele eklenir
        raporFrame.add(raporTitle, BorderLayout.NORTH);
        raporFrame.add(chartPanel, BorderLayout.CENTER);
        raporFrame.add(footerLabel, BorderLayout.SOUTH);

        // Rapor penceresi görünür hale getirilir
        raporFrame.setVisible(true);
    }

    // Uyarı yönetim işlemini gerçekleştirir
    private void uyariYonet() {
        try {
            // Rastgele bir değer oluşturulur
            int randomValue = new Random().nextInt(100);

            // Rastgele değere göre uyarı mesajları gösterilir
            if (randomValue < 25) {
                throw new Exception("Yüksek riskli uyarı! Trafik yoğun. Değer: " + randomValue);
            } else if (randomValue >= 25 && randomValue <= 45) {
                JOptionPane.showMessageDialog(null, "Riskli: Değer: "
                        + randomValue, "Uyarı Yönetimi", JOptionPane.WARNING_MESSAGE);
            } else if (randomValue > 45 && randomValue <= 50) {
                JOptionPane.showMessageDialog(null, "Uyarı yok. Değer: "
                        + randomValue, "Uyarı Yönetimi", JOptionPane.INFORMATION_MESSAGE);
            } else {
                throw new Exception("Yüksek riskli uyarı! BDE Enerji durumu. Değer: " + randomValue);
            }
        } catch (Exception e) {
            // Yüksek riskli uyarı durumunda hata mesajı gösterilir
            JOptionPane.showMessageDialog(null, e.getMessage(), "Uyarı Yönetimi"
                    , JOptionPane.WARNING_MESSAGE);
        }
    }

    // Uygulamayı başlatan ana metot
    public static void main(String[] args) {
        // Swing uygulaması başlatılır
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AkilliSehirUygulamasi().setVisible(true);
            }
        });
    }
}
