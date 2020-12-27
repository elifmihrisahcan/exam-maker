
import java.util.*;

public class Main {

    static enum Secenek {
        YAPILMADI, BASLA, EKLE, SIL, LISTELE, CIKIS
    }

    static Scanner input = new Scanner(System.in);
    static SoruBankasi soruBankasi = new SoruBankasi(input);

    // main fonk.
    public static void main(String[] args) {
        Secenek secim = Secenek.YAPILMADI;
        do {
            ekranaSecimleriListele();
            secim = secimAl();
            secimiCalistir(secim);
        } while (secim != Secenek.CIKIS);
    }

    // seçimleri ekrana yazar
    public static void ekranaSecimleriListele() {
        System.out.println("+-----------------------+");
        System.out.println("| 1. Sorulara basla     |");
        System.out.println("| 2. Soru Ekle          |");
        System.out.println("| 3. Soru Sil           |");
        System.out.println("| 4. Sorulari Listele   |");
        System.out.println("| 5. Cikis              |");
        System.out.println("+-----------------------+");
        System.out.print("* Seciminiz: ");
    }

    // seçenekleri değişkenler atar
    private static Secenek secimAl() {
        Secenek secilen = Secenek.YAPILMADI;
        int secim = input.nextInt();
        switch (secim) {
            case 1:
                secilen = Secenek.BASLA;
                break;
            case 2:
                secilen = Secenek.EKLE;
                break;
            case 3:
                secilen = Secenek.SIL;
                break;
            case 4:
                secilen = Secenek.LISTELE;
                break;
            case 5:
                secilen = Secenek.CIKIS;
                break;
            default:
                break;
        }
        return secilen;
    }

    // listenelen seçimleri çalıştırır
    private static void secimiCalistir(Secenek secim) {
        switch (secim) {
            case BASLA:
                soruBankasi.sinavaBasla();
                break;
            case EKLE:
                soruBankasi.soruEkle();
                break;
            case SIL:
                soruBankasi.soruSil();
                break;
            case LISTELE:
                soruBankasi.listeListeleme();
                break;
            default:
                break;
        }
    }
}