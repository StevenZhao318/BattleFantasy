package game;

public abstract class Consumable {

    protected String name;
    protected String type;
    protected int restoreAmount;

    // uses the consumable item
    protected Boolean useConsumable() {
        return true;
    }

    // Give info about item
    public String infoItem() {
        return ("Item: " + this.name + " | Restores: " + this.restoreAmount);
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getRestoreAmount() {
        return restoreAmount;
    }
}
