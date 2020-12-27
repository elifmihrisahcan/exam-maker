
import java.util.*;

// sadece bir soru üzerinde duruluyor burada 
public class Soru {
     String soru;
     int zorluk;
     int puan;

    public Soru() {}

    public Soru(String soru, String[] cevaplar, char dogruCevap, int zorluk, int puan) {
        this.soru = soru;
        this.zorluk = zorluk;
        this.puan = puan;
    }

    /**
     * @return the soru
     */
    public String getSoru() {
        return soru;
    }

    /**
     * @param soru the soru to set
     */
    public void setSoru(String soru) {
        this.soru = soru;
    }

    /**
     * @return the zorluk
     */
    public int getZorluk() {
        return zorluk;
    }

    /**
     * @param zorluk the zorluk to set
     */
    public void setZorluk(int zorluk) {
        this.zorluk = zorluk;
    }

    /**
     * @return the puan
     */
    public int getPuan() {
        return puan;
    }

    /**
     * @param puan the puan to set
     */
    public void setPuan(int puan) {
        this.puan = puan;
    }

    /** Soruyu ekrana yaz. */
    public void soruYaz() {
        System.out.println(" Soru: " + getSoru());
    }

    /** Soruyu ekrandan oku. */
    public void soruOku(Scanner input) {
        System.out.print("soru: ");
        String soru = input.next().trim();
        setSoru(soru);

        System.out.print("zorluk (1/2/3): ");
        int zorluk = input.nextInt();
        setZorluk(zorluk);

        System.out.print("puan: ");
        int puan = input.nextInt();
        setPuan(puan);
    }

    /** Soruyu sor. */
    public int soruSor(Scanner input) { return 0; }
}
