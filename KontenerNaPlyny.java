public class KontenerNaPlyny extends Kontener implements IHazardNotifier {
    private boolean niebezpieczny;

    KontenerNaPlyny(double masaLadunku, int wysokosc, int wagaWlasna, int glebokosc, double maksymalnaLadownosc, boolean niebezpieczny) {
        super(masaLadunku, wysokosc, wagaWlasna, glebokosc, maksymalnaLadownosc);
        this.niebezpieczny = niebezpieczny;
        numerSeryjny = "KON-L-" + id;
    }

    public boolean isNiebezpieczny() {
        return niebezpieczny;
    }

    public void setNiebezpieczny(boolean niebezpieczny) {
        this.niebezpieczny = niebezpieczny;
    }

    @Override
    public void zaladujLadunek(int masaLadunku) {
        if (niebezpieczny) {
            maksymalnaLadownosc *= 0.5;
        } else {
            maksymalnaLadownosc *= 0.9;
        }
        if (masaLadunku > maksymalnaLadownosc) {
            notifyHazard(numerSeryjny);
        } else {
            this.masaLadunku = masaLadunku;
        }
    }

    @Override
    public void notifyHazard(String numerSeryjny) {
        System.out.println("Hazard: " + numerSeryjny);
    }

    @Override
    public String toString() {
        return "KontenerNaGaz numerSeryjny= " + numerSeryjny + ", masaLadunku= " + masaLadunku + "kg, wagaWlasna= " +wagaWlasna+ "kg, wysokosc= "+ wysokosc+ "cm, glebokosc= "+glebokosc+ "cm, maksymalnaLadownosc= "+ maksymalnaLadownosc + "kg, niebezpieczny= " + niebezpieczny;
    }
}