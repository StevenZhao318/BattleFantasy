package game;

import java.util.ArrayList;

public class Shield {
    String shieldName;
    int defence;
    private ArrayList<ShieldType> types = new ArrayList<>();

    public Shield() {
        this.shieldName = "Empty";
        this.defence = 0;
    }

    public Shield(String name, int defence) {
        this.shieldName = name;
        this.defence = defence;
    }

    public void addShieldType(ShieldType type) {
        this.types.add(type);
        if (!type.getShields().contains(this)) {
            type.addShield(this);
        }
    }

    public ArrayList<ShieldType> getType() {
        return types;
    }

}
