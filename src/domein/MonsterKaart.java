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
    
    private final int level;
    private final String badStuff;
    private final int beloningInSchat;
    private final int beloningInLevel;
    private final boolean runAwayMogelijk;
    private final int extraLevel;
    private final String voorwaardeExtraLevel;
    private final boolean runAwayVanafBepaaldeLevel;
    private final int runAwayVanafBepaaldeLevelInt;
    private final int verlorenLevelsBijRunAway;

    public int getLevel() {
        return level;
    }

    public String getBadStuff() {
        return badStuff;
    }

    public int getBeloningInSchat() {
        return beloningInSchat;
    }

    public int getBeloningInLevel() {
        return beloningInLevel;
    }

    public boolean isRunAwayMogelijk() {
        return runAwayMogelijk;
    }

    public int getExtraLevel() {
        return extraLevel;
    }

    public String getVoorwaardeExtraLevel() {
        return voorwaardeExtraLevel;
    }

    public boolean isRunAwayVanafBepaaldeLevel() {
        return runAwayVanafBepaaldeLevel;
    }

    public int getRunAwayVanafBepaaldeLevelInt() {
        return runAwayVanafBepaaldeLevelInt;
    }

    public int getVerlorenLevelsBijRunAway() {
        return verlorenLevelsBijRunAway;
    }

    public MonsterKaart(int level, String badStuff, int beloningInSchat, int beloningInLevel, boolean runAwayMogelijk, int extraLevel, String voorwaardeExtraLevel, boolean runAwayVanafBepaaldeLevel, int runAwayVanafBepaaldeLevelInt, int verlorenLevelsBijRunAway, String naam, Image afbeelding, int runAwayExtra) {
        super(naam, afbeelding, runAwayExtra);
        this.level = level;
        this.badStuff = badStuff;
        this.beloningInSchat = beloningInSchat;
        this.beloningInLevel = beloningInLevel;
        this.runAwayMogelijk = runAwayMogelijk;
        this.extraLevel = extraLevel;
        this.voorwaardeExtraLevel = voorwaardeExtraLevel;
        this.runAwayVanafBepaaldeLevel = runAwayVanafBepaaldeLevel;
        this.runAwayVanafBepaaldeLevelInt = runAwayVanafBepaaldeLevelInt;
        this.verlorenLevelsBijRunAway = verlorenLevelsBijRunAway;
    }
}
