import java.util.Objects;

public class KontenerChlodniczy extends Kontener implements IHazardNotifier{
    private double temperatura;
    private String produkt;
    public KontenerChlodniczy(double masaLadunku, int wysokosc, int wagaWlasna, int glebokosc, double maksymalnaLadownosc, double temperatura) {
        super(masaLadunku, wysokosc, wagaWlasna, glebokosc, maksymalnaLadownosc);
        this.temperatura = temperatura;
    }

    private double getMinTemp(String produkt){
        switch(produkt){
            case "Bananas": return 13.3;
            case "Chocolate": return 18;
            case "Fish": return 2;
            case "Meat": return -15;
            case "Ice cream": return -18;
            case "Frozen pizza": return -30;
            case "Cheese": return 7.2;
            case "Sasuages": return 5;
            case "Butter": return 20.5;
            case "Eggs": return 19;
            default:
                throw new IllegalArgumentException("Nieznany produkt: " + produkt);
        }
    }

    public void zaladujLadunek(int masa, String produkt){
        this.produkt = produkt;
        double minTemp = getMinTemp(produkt);
        if(this.produkt == null || this.produkt.equals(produkt)) {
            if (temperatura > minTemp) {
                throw new IllegalArgumentException("Zbyt niska temperatura kontenera dla profuktu: " + produkt);
            } else {
                try {
                    if (masa > maksymalnaLadownosc)
                        throw new Exception();
                    else {
                        masaLadunku = masa;
                    }
                } catch (Exception OverfillException) {
                    System.out.println("OverfillException");
                }
            }
        }else{
            throw new IllegalArgumentException("Inny ladunek jest juz zaladowany");
        }
    }

    @Override
    public void notifyHazard(String containerNumber) {

    }

    @Override
    public String toString() {
        return "KontenerNaGaz numerSeryjny= " + numerSeryjny + ", masaLadunku= " + masaLadunku + "kg, wagaWlasna= " +wagaWlasna+ "kg, wysokosc= "+ wysokosc+ "cm, glebokosc= "+glebokosc+ "cm, maksymalnaLadownosc= "+ maksymalnaLadownosc + "kg,temperatura = " + temperatura + "°C, produkt = " + produkt;
    }


}
