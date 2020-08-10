package game;

public class HealthPotion extends Consumable {

    public HealthPotion(String name, int restoreAmount) {
        super.name = name;
        super.type = "Health";
        super.restoreAmount = restoreAmount;
    }

    // uses the consumable item
    @Override
    public Boolean useConsumable() {
        System.out.println("You drink the " + super.name + ". You heal for " + super.restoreAmount);
        return true;
    }







}
