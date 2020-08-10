package game;

public class Monster {
    private int id;
    private String name;
    private int hp;
    private int currentHp;
    private int attack;
    private int defence;

    // default constructor for Monster
    public Monster() {
        int id = 0;
        this.name = "null";
        this.hp = 1;
        this.currentHp = this.hp;
        this.attack = 0;
        this.defence = 0;
    }

    // Custom contructor for Monster
    public Monster(int id, String name, int hp, int atk, int def) {
        setId(id);
        setName(name);
        setHp(hp);
        setCurrentHp(hp);
        setAttack(atk);
        setDefence(def);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    // Basic info of monster
    // REQUIRES: valid monster id and name fields
    // EFFECTS: return the id and name of the monster as String
    @Override
    public String toString() {
        return "Monster{" + "id = " + id + ", name = '" + name + '\'' + '}';
    }
}
