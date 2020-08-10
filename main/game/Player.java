package game;


public class Player {

    private String name;
    // Stats
    // skills
    private Weapon weapon;
    private Shield shield;
    private int hp;
    private int currentHp;
    private int attack;
    private int defence;
    private int level;
    private int totalAttack;
    private int totalDefence;
    private int exp;

    /**
     * default constructor for Player class
     */
    public Player() {
        this.name = "Bob";
        this.hp = 25;
        this.currentHp = hp;
        this.attack = 5;
        this.defence = 0;
        this.weapon = new Weapon();
        this.totalAttack = getAttack();
        this.level = 1;
    }

    public Player(String name) {
        this.name = name;
        this.hp = 25;
        this.currentHp = hp;
        this.attack = 5;
        this.defence = 0;
        this.weapon = new Weapon();
        this.totalAttack = getAttack();
        this.level = 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
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

    public int getTotalAttack() {
        return totalAttack;
    }

    public void setTotalAttack(int totalAttack) {
        this.totalAttack = totalAttack;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    // Level up player and increases stats
    // MODIFIES: this
    // Effects: increases the specified player fields by a int amount
    public void levelUp() {
        setLevel(getLevel() + 1);
        setHp(getHp() + 10);
        setAttack(getAttack() + 2);
        setDefence(getDefence() + 2);
        setTotalAttack(getTotalAttack() + 2);
    }

    // full heal for player
    // MODIFIES: this
    // EFFECTS: sets the current player hp equal to the base hp field
    public void fullHeal() {
        setCurrentHp(this.hp);
    }

    // give stats of player
    // REQUIRES: valid level, currentHP, hp, and attack fields of this
    // EFFECTS: returns the level, currentHP, hp, and attack fields as String.
    @Override
    public String toString() {
        return ("Stats: " + "Level = " + level
                + " | HP = " + currentHp + "/" + hp
                + " | Attack = " + attack);
    }
}
