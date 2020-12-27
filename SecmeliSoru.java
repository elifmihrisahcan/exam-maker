
import java.util.*;

/** Secmeli soru. */
public class SecmeliSoru extends Soru {
    String[] cevaplar = new String[4];
    char dogruCevap;
    
    /**
     * @return the cevaplar
     */
    public String[] getCevaplar() {
        return cevaplar;
    }

    /**
     * @param cevaplar the cevaplar to set
     */
    public void setCevaplar(String[] cevaplar) {
        this.cevaplar = cevaplar;
    }

    /**
     * @return the dogruCevap
     */
    public char getDogruCevap() {
        return dogruCevap;
    }

    /**
     * @param dogruCevap the dogruCevap to set
     */
    public void setDogruCevap(char dogruCevap) {
        this.dogruCevap = dogruCevap;
    }

    @Override
    public void soruOku(Scanner input) {
        super.soruOku(input);
        for (int i = 0; i < 4; i++) {
            System.out.print((char)('A' + i) + ": ");
            cevaplar[i] = input.next().trim();
        }
        do {
            System.out.print("doğru cevap (A/B/C/D): ");
            dogruCevap = input.next().trim().charAt(0);
        } while (dogruCevap < 'A' || dogruCevap > 'D');
    }

    @Override
    public void soruYaz() {
        super.soruYaz();
        for (int i = 0; i < getCevaplar().length; i++) {
            System.out.println((char)('A' + i) + ". " + getCevaplar()[i]);
        }
    }

    @Override
    public int soruSor(Scanner input) {
        soruYaz();
        char verilenCevap;
        do {
            System.out.println("Cevabınız: ");
            verilenCevap = input.next().trim().charAt(0);
        } while(verilenCevap < 'A' || verilenCevap > 'D');
        if (verilenCevap == getDogruCevap()) {
            System.out.println("verilen cevap dogru");
            return getPuan();
        } else {
            System.out.println("verilen cevap dogru değil");
            System.out.println("dogru cevap " + getDogruCevap());
            return 0;
        }
    }
}
