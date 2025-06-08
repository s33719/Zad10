public class Kontener {
    protected double masaLadunku;
    protected int wysokosc;
    protected int wagaWlasna;
    protected int glebokosc;
    protected String numerSeryjny;
    protected double maksymalnaLadownosc;
    protected static int id;

    public Kontener(double masaLadunku, int wysokosc, int wagaWlasna, int glebokosc, double maksymalnaLadownosc) {
        this.masaLadunku = masaLadunku;
        this.wysokosc = wysokosc;
        this.wagaWlasna = wagaWlasna;
        this.glebokosc = glebokosc;
        this.maksymalnaLadownosc = maksymalnaLadownosc;
        id++;
    }

    public double getMasaLadunku() {
        return masaLadunku;
    }

    public void setMasaLadunku(int masaLadunku) {
        this.masaLadunku = masaLadunku;
    }

    public int getWysokosc() {
        return wysokosc;
    }

    public void setWysokosc(int wysokosc) {
        this.wysokosc = wysokosc;
    }

    public int getWagaWlasna() {
        return wagaWlasna;
    }

    public void setWagaWlasna(int wagaWlasna) {
        this.wagaWlasna = wagaWlasna;
    }

    public int getGlebokosc() {
        return glebokosc;
    }

    public void setGlebokosc(int glebokosc) {
        this.glebokosc = glebokosc;
    }

    public String getNumerSeryjny() {
        return numerSeryjny;
    }

    public void setNumerSeryjny(String numerSeryjny) {
        this.numerSeryjny = numerSeryjny;
    }

    public double getMaksymalnaLadownosc() {
        return maksymalnaLadownosc;
    }

    public void setMaksymalnaLadownosc(int maksymalnaLadownosc) {
        this.maksymalnaLadownosc = maksymalnaLadownosc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    protected void oproznijLadunek(){
        masaLadunku = 0;
    }
    protected void zaladujLadunek(int ladunek){
        try{
            if(ladunek > maksymalnaLadownosc)
                throw new Exception();
            else{
                masaLadunku = ladunek;
            }
        }catch(Exception OverfillException){
            System.out.println("OverfillException");
        }
    }
}