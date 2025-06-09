import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        KontenerNaPlyny k = new KontenerNaPlyny(1.0, 10, 10, 10, 1000.0, false);
        KontenerNaGaz k2 = new KontenerNaGaz(5.0, 20, 50, 10, 1000.0, 1000);
        KontenerNaPlyny k3 = new KontenerNaPlyny(1.0, 10, 10, 10, 1000.0, true);
        KontenerChlodniczy k4 = new KontenerChlodniczy(5.0, 20, 50, 10, 1000.0, 38);
        System.out.println(k);
        System.out.println(k2);
        Statek statek1 = new Statek(10.0, 50, 10000, "Statek1");
        Statek statek2 = new Statek(10.0, 50, 10000, "Statek2");
        k.zaladujLadunek(100);
        statek1.zaladujKontener(k);
        List<Kontener> l1 = new ArrayList<>();
        l1.add(k2);
        l1.add(k3);
        statek1.zaladujKontenery(l1);
        statek1.usunKontener(k);
        k.oproznijLadunek();
        statek1.zastapKontenery("KON-L-3", k4);
        statek1.przeniesKontener(statek1, statek2, k2);
        statek1.getInfo();
        System.out.println();
        System.out.println();
        statek2.getInfo();

    }
}
