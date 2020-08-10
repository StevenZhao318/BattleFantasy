package game;

import java.util.ArrayList;

public class ShieldType {
    private String type;
    private ArrayList<Shield> shields = new ArrayList<>();

    public ShieldType() {
        this.type = "normal";
    }

    public ShieldType(String type) {
        this.type = type;
    }

    public ArrayList<Shield> getShields() {
        return shields;
    }

    public void addShield(Shield shield) {
        this.shields.add(shield);
        if (!shield.getType().contains(this)) {
            shield.addShieldType(this);
        }

    }
}
