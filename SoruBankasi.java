
import java.io.FileOutputStream;
import java.util.*;
import java.io.ObjectOutputStream;


public class SoruBankasi {
    static ArrayList<Soru> sorular = new ArrayList<>();

    private Scanner input;

    SoruBankasi(Scanner input) {
        this.input = input;
    }

    // sinava baslama metodu
    void sinavaBasla() {
        Random rand = new Random();
        int note = 0, toplam = 0;
        while (toplam < 100) {
            Soru soru = sorular.get(rand.nextInt(sorular.size()));
            toplam = toplam + soru.getPuan();
            note = note + soru.soruSor(input);
        }
        System.out.println("sınav bitmiştir. notunuz: " + note);
    }

    // listelem seçeneklerini listeleme metodu
    void listeListeleme() {
        System.out.println("listeleme seklini giriniz");
        System.out.println("sorulari listelemek icin 1");
        System.out.println("bir kritere göre listeleme icin 2");
        int listeIcınAl = input.nextInt();
        if (listeIcınAl == 1) {
            soruListele();
        } else {
            sIcindeListele();
        }
    }

    // soruları listeleme metodu
    void soruListele() {
        int i = 1;
        System.out.println("\n------------sorular---------");
        for (Soru soru : sorular) {
            System.out.print(i + "->");
            soru.soruYaz();
            System.out.println("");
            i++;
        }
        System.out.println("\n----------------------------\n\n");
    }

    // sorunun içinde arama metodu duzeltilecek
    void sIcindeListele() {
        System.out.println("lutfen hangi katagoride seçim yapacaksanız giriniz");
        System.out.println("1. Soru metni içinde arama");
        System.out.println("2. Soru şıklarının metinleri içinde");
        System.out.println("3. Doğru şıkları uzerinden arama ");
        System.out.println("4. Puan uzerinden arama");
        System.out.println("5. Zorluk derecesinden arama");
        int ara = input.nextInt();

        switch (ara) {
            case (1):
                metinIci();
                break;
            case (2):
                sikMetinIci();
                break;
            case (3):
                break;
            case (4):
                break;
            case (5):
                break;
            default:
                break;
        }

    }

    // metin içinde arama yapma metodu
    private void metinIci() {
        System.out.println("lutfen aramak istediginiz cumleyi giriniz");

        String metin = input.nextLine().trim();

        System.out.println("girilen kelime ile ilgili sorular");
        for (int i = 0; i < sorular.size(); i++) {
            if (sorular.get(i).getSoru().contains(metin)) {
                System.out.println((i+1) + ". " + sorular.get(i).getSoru());
            }
        }
        System.out.println("sorgulama bitti");
    }

    // sik metni icinde arama yapma metodu eklenecek
    private void sikMetinIci() {
        System.out.println("lütfen cevaplarda aramak istediginiz cumleyi giriniz ");
        String cevap = input.nextLine().trim();

        System.out.println("girilen kelimeyi cevap olarak iceren sorular");
        for (int i = 0; i < sorular.size(); i++) {
        }
        System.out.println("sorgulama bitti");
    }

    // soru ekleme metodu
    void soruEkle() {
        System.out.println("1- Test sorusu\n2- Klasik soru\n3- Dogru Yanlis sorusu\n");
        System.out.print("Seciminiz: ");
        int soruTipi = input.nextInt();
        Soru soru = null;
		if(soruTipi == 1) {
            soru = new SecmeliSoru();
        }
        else if(soruTipi == 2) {
            soru = new KlasikSoru();
        }
        else if (soruTipi == 3) {
            soru = new DogruYanlisSoru();
        }
        if (soru != null) {
            soru.soruOku(input);
            sorular.add(soru);
        }
    }
    

    // soru silme metodu eklendi
    void soruSil() {
        System.out.print("Silinecek sorunun numarasını giriniz: ");
        int index = input.nextInt() - 1;
        if (index < 0 || index >= sorular.size()) {
            System.out.println("Soru silinemedi!");
        } else {
            sorular.remove(index);
            System.out.println("Soru silindi \n\n\n");
        }
    }
}
