public class KontenerNaGaz extends Kontener implements IHazardNotifier{
    private int cisnienie;
    KontenerNaGaz(double masaLadunku, int wysokosc, int wagaWlasna, int glebokosc, double maksymalnaLadownosc, int cisnienie) {
        super(masaLadunku, wysokosc, wagaWlasna, glebokosc, maksymalnaLadownosc);
        this.cisnienie = cisnienie;
        numerSeryjny = "KON-G-"+id;
    }

    @Override
    protected void oproznijLadunek(){
        masaLadunku *= 0.05;
    }

    @Override
    public void notifyHazard(String containerNumber) {
        System.out.println("Hazard: " + numerSeryjny);
    }

    @Override
    public String toString() {
        return "KontenerNaGaz numerSeryjny= " + numerSeryjny + ", masaLadunku= " + masaLadunku + "kg, wagaWlasna= " +wagaWlasna+ "kg, wysokosc= "+ wysokosc+ "cm, glebokosc= "+glebokosc+ "cm, maksymalnaLadownosc= "+ maksymalnaLadownosc + "kg, cisnienie= "+ cisnienie+ "Pa";
    }
}