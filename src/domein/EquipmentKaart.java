/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

/**
 *
 * @author nikol
 */
public class EquipmentKaart extends SchatKaart {
    private String soort;
    private String kanGebruiktWordenDoor;
    private String extraBonusVW;
    private int extraBonus;


    public EquipmentKaart(String soort, String kanGebruiktWordenDoor, String extrabonusVW, int extraBonus, int bonus, String naam, int waardeVerkoop) {
        super(bonus, naam, waardeVerkoop);
        setExtraBonus(extraBonus);
        setExtraBonusVW(extrabonusVW);
        setKanGebruiktWordenDoor(kanGebruiktWordenDoor);
        setSoort(soort);
    }

    public String getSoort() {
        return soort;
    }

    public void setSoort(String soort) {
        this.soort = soort;
    }

    public String getKanGebruiktWordenDoor() {
        return kanGebruiktWordenDoor;
    }

    public void setKanGebruiktWordenDoor(String kanGebruiktWordenDoor) {
        this.kanGebruiktWordenDoor = kanGebruiktWordenDoor;
    }

    public String getExtraBonusVW() {
        return extraBonusVW;
    }

    public void setExtraBonusVW(String extraBonusVW) {
        this.extraBonusVW = extraBonusVW;
    }

    public int getExtraBonus() {
        return extraBonus;
    }

    public void setExtraBonus(int extraBonus) {
        this.extraBonus = extraBonus;
    }

    @Override
    public String toString() {
        return "EquipmentKaart{" + " naam = " + getNaam() + " bonus = " + getBonus() + " waarde bij verkoop = " + getWaardeVerkoop() +
                " soort='" + soort + '\'' +
                ", kanGebruiktWordenDoor='" + kanGebruiktWordenDoor + '\'' +
                " extra bonus = " + extraBonus  + " extra bonus voorwaarde " + extraBonusVW + '\n';
    }
}
