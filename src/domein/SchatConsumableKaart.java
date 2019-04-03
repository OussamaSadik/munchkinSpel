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
public class SchatConsumableKaart extends SchatKaart {

    private boolean bonusVoorBeideKanten;
    private String instantKillMonster;
    private int freeLevels;

    public SchatConsumableKaart(String naam, int bonus, boolean bonusVoorBeideKanten, String instantKillMonster, int freeLevels, int waardeVerkoop) {
        super(bonus,naam, waardeVerkoop);
        setBonusVoorBeideKanten(bonusVoorBeideKanten);
        setInstantKillMonster(instantKillMonster);
        setFreeLevels(freeLevels);
    }

    public boolean isBonusVoorBeideKanten() {
        return bonusVoorBeideKanten;
    }

    public void setBonusVoorBeideKanten(boolean bonusVoorBeideKanten) {
        this.bonusVoorBeideKanten = bonusVoorBeideKanten;
    }

    public String getInstantKillMonster() {
        return instantKillMonster;
    }

    public void setInstantKillMonster(String instantKillMonster) {
        this.instantKillMonster = instantKillMonster;
    }

    public int getFreeLevels() {
        return freeLevels;
    }

    public void setFreeLevels(int freeLevels) {
        this.freeLevels = freeLevels;
    }


    @Override
    public String toString() {
        return "SchatConsumableKaart{" + " naam = " + getNaam() + " bonus = " + getBonus() + " waarde bij verkoop = " + getWaardeVerkoop() +
                "bonusVoorBeideKanten=" + bonusVoorBeideKanten +
                ", instantKillMonster='" + instantKillMonster + '\'' +
                ", freeLevels=" + freeLevels +
                '}' + '\n';
    }
}
