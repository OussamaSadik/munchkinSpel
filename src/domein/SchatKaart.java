package domein;


public class SchatKaart extends Kaart {

    private int waardeVerkoop;
    private int bonus;
    private String naam;


    public SchatKaart(){

    }
    public SchatKaart(int bonus, String naam, int waardeVerkoop){
        setBonus(bonus);
        setNaam(naam);
        setWaardeVerkoop(waardeVerkoop);
    }

    public SchatKaart(int bonus){
        setBonus(bonus);
    }


    public int getWaardeVerkoop() {
        return waardeVerkoop;
    }

    @Override
    public String getNaam() {
        return naam;
    }

    @Override
    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setWaardeVerkoop(int waardeVerkoop) {
        this.waardeVerkoop = waardeVerkoop;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
