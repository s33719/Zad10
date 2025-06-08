import java.util.List;
import java.util.ArrayList;
public class Statek {

    private List<Kontener> kontenery;
    private String nazwa;
    private double predkoscMax;
    private int maxKontenery;
    private int maxWaga;

    public Statek(double predkoscMax, int maxKontenery, int maxWaga, String nazwa) {
        this.predkoscMax = predkoscMax;
        this.maxKontenery = maxKontenery;
        this.maxWaga = maxWaga;
        this.kontenery = new ArrayList<>();
        this.nazwa = nazwa;
    }

    public void zastapKontenery(String numerSeryjny, Kontener nowy){
        for(Kontener k : kontenery){
            if(k.getNumerSeryjny().equals(numerSeryjny)){
                usunKontener(k);
                zaladujKontener(nowy);
            }
        }
    }

    public void przeniesKontener(Statek zrodlo, Statek cel, Kontener k){
        for(Kontener k1 : zrodlo.kontenery){
            if(k1.getNumerSeryjny().equals(k.getNumerSeryjny())){
                if(cel.zaladujKontener(k)){
                    zrodlo.usunKontener(k);
                }
            }
        }
    }

    public boolean zaladujKontener(Kontener k) {
        if(kontenery.size() >= maxKontenery)
            return false;
        if(getLacznaWaga(kontenery)+k.getWagaWlasna()+k.getMasaLadunku() > maxWaga)
            return false;
        kontenery.add(k);
        return true;
    }

    private double getLacznaWaga(List<Kontener> kontenery) {
        double lacznie = 0.0;
        for(Kontener k : kontenery) {
            lacznie += k.getWagaWlasna()+k.getMasaLadunku();
        }
        return lacznie;
    }

    public void zaladujKontenery(List<Kontener> k) {
        for(Kontener k1 : k) {
            boolean sukces = zaladujKontener(k1);
            if(!sukces){
                System.out.println("Nie udało się załadować kontnera ID: " + k1.getNumerSeryjny());
            }
        }
    }

    public void usunKontener(Kontener k) {
        if(kontenery.contains(k))
            kontenery.remove(k);
        else
            System.out.println("Nie ma takiego kontenera");
    }
    public void getInfo() {
        System.out.println("=== Informacje o statku ===");
        System.out.println("Prędkość maksymalna: " + predkoscMax + " węzłów");
        System.out.println("Maksymalna liczba kontenerów: " + maxKontenery);
        System.out.println("Maksymalna waga ładunku: " + maxWaga + " kg");
        System.out.println("Aktualna liczba kontenerów: " + kontenery.size());
        System.out.println("Aktualna łączna waga: " + getLacznaWaga(kontenery) + " kg");

        System.out.println("\n--- Lista kontenerów ---");
        for (Kontener k : kontenery) {
            System.out.println(k);
        }
    }
}