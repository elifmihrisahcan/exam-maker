
import java.util.*;

public class KlasikSoru extends Soru {
    

    String dogruCevap;
    
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
    public String getDogruCevap() {
        return dogruCevap;
    }

    /**
     * @param dogruCevap the dogruCevap to set
     */
    public void setDogruCevap(String dogruCevap) {
        this.dogruCevap = dogruCevap;
    }

    @Override
    public void soruOku(Scanner input) {
        super.soruOku(input);
            System.out.print("Cevap: ");
            dogruCevap = input.next();
    }

    @Override
    public void soruYaz() {
        super.soruYaz();
        
    }

    @Override
    public int soruSor(Scanner input) {
        soruYaz();
        String verilenCevap;
            System.out.print("Cevabınız: ");
            verilenCevap = input.next();

            int a = getDogruCevap().compareTo(verilenCevap);

        if (a == 0 ) {
            System.out.println("verilen cevap dogru");
            return getPuan();
        } else {
            System.out.println("verilen cevap dogru değil");
            System.out.println("dogru cevap: " + getDogruCevap());
            return 0;
        }
    }
}

