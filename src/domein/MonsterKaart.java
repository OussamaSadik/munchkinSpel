/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import javafx.scene.image.Image;

/**
 *
 * @author nikol
 */
public class MonsterKaart extends KerkerKaart {
    
    private  int level;
    private  String badStuff;
    private  int treasuresRewards;
    private  int levelsRewards;
    private  int extraLevel;
    private  String extraLevelVW;
    private  int runAwayVanafLevel;
    private  int verlorenLevelsBijRunAway;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getBadStuff() {
        return badStuff;
    }

    public void setBadStuff(String badStuff) {
        this.badStuff = badStuff;
    }

    public int getTreasuresRewards() {
        return treasuresRewards;
    }

    public void setTreasuresRewards(int treasuresRewards) {
        this.treasuresRewards = treasuresRewards;
    }

    public int getLevelsRewards() {
        return levelsRewards;
    }

    public void setLevelsRewards(int levelsRewards) {
        this.levelsRewards = levelsRewards;
    }

    public int getExtraLevel() {
        return extraLevel;
    }

    public void setExtraLevel(int extraLevel) {
        this.extraLevel = extraLevel;
    }

    public String getExtraLevelVW() {
        return extraLevelVW;
    }

    public void setExtraLevelVW(String extraLevelVW) {
        this.extraLevelVW = extraLevelVW;
    }

    public int getRunAwayVanafLevel() {
        return runAwayVanafLevel;
    }

    public void setRunAwayVanafLevel(int runAwayVanafLevel) {
        this.runAwayVanafLevel = runAwayVanafLevel;
    }

    public int getVerlorenLevelsBijRunAway() {
        return verlorenLevelsBijRunAway;
    }

    public void setVerlorenLevelsBijRunAway(int verlorenLevelsBijRunAway) {
        this.verlorenLevelsBijRunAway = verlorenLevelsBijRunAway;
    }

    public MonsterKaart(String naam, int runAwayExtra, String badStuff, int extraLevel, String extraLevelVW, int level, int levelsRewards, int runAwayVanafLevel, int treasuresRewards, int verlorenLevelsBijRunAway) {
        super(naam, runAwayExtra);
        setBadStuff(badStuff);
        setExtraLevel(extraLevel);
        setExtraLevelVW(extraLevelVW);
        setLevel(level);
        setLevelsRewards(levelsRewards);
        setRunAwayVanafLevel(runAwayVanafLevel);
        setTreasuresRewards(treasuresRewards);
        setVerlorenLevelsBijRunAway(verlorenLevelsBijRunAway);

    }

    @Override
    public String toString() {
        return "MonsterKaart" +
                " naam = " + super.getNaam() +
                " level = " + level +
                " badStuff = " + badStuff + '\'' +
                " treasuresRewards = " + treasuresRewards +
                " levelsRewards = " + levelsRewards +
                " extraLevel = " + extraLevel +
                " extraLevelVW =" + extraLevelVW + '\'' +
                " runAwayVanafLevel = " + runAwayVanafLevel +
                " verlorenLevelsBijRunAway=" + verlorenLevelsBijRunAway  + "\n"
                ;
    }
}
