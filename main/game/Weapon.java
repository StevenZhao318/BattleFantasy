package game;

public class Weapon {

    int id;
    String weaponName;
    int damage;

    public Weapon() {
        int id = 0;
        this.weaponName = "Fists";
        this.damage = 1;
    }

    public Weapon(int id, String name, int dmg) {
        setId(id);
        setWeaponName(name);
        setDamage(dmg);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public int getDamage() {
        return damage;
    }

    // REQUIRES: damage value over 0
    // MODIFIES: this
    // EFFECTS: sets weapon damage
    public void setDamage(int damage) {
        if (damage >= 0) {
            this.damage = damage;
        } else {
            System.out.println("invalid input");
        }
    }
}
