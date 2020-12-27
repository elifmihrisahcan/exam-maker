
import java.util.*;

public class DogruYanlisSoru extends Soru { 

    String[] cevaplar = new String[2];
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
        do {
            System.out.print("(D/Y): ");
            dogruCevap = input.next().trim().charAt(0);
        } while (dogruCevap == 'D' || dogruCevap == 'Y');

        
    }

    @Override
    public void soruYaz() {
        super.soruYaz();
        System.out.println(" D / Y ");
        
    }

    @Override
    public int soruSor(Scanner input) {
        soruYaz();
        char verilenCevap;
        do {
            System.out.print("Cevabınız: ");
            verilenCevap = input.next().trim().charAt(0);
        } while (dogruCevap == 'D' || dogruCevap == 'Y');
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
