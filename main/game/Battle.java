package game;

/*
 * Represents a Battle instance
 */

public class Battle {
    Player mainPlayer;
    Monster enemy;

    // Default Constructor for Battle instance
    public Battle() {}

    // Constructor for random startBattle
    // REQUIRES: non empty bestiary
    // EFFECTS: create random startBattle with player character and random monster
    public Battle(Player player, Bestiary bestiary) {
        this.mainPlayer = player;
        this.enemy = bestiary.randomEncounter();
        this.enemy.setCurrentHp(this.enemy.getHp()); //restore monster hp
        System.out.println("Battle start!");
    }

    // Constructor for custom startBattle
    // Effects: create random startBattle with player character and custom monster
    public Battle(Player player, Monster monster) {
        this.mainPlayer = player;
        this.enemy = monster;
    }

    public Player getPlayer() {
        return mainPlayer;
    }

    public Monster getEnemy() {
        return enemy;
    }

    // Attacks the monster
    // REQUIRES: valid monster and character
    // MODIFIES: this
    // EFFECT: decreases monster hp by player attack
    public String playerAttackDamage(Player player, Monster monster) {
        int playerDamage = (int) Math.ceil(Math.random() * player.getTotalAttack());
        String attackText = ("You attack the " + monster.getName() + " for " + playerDamage + " damage.");
        int hp = (monster.getCurrentHp() - playerDamage);
        if (hp <= 0) {
            monster.setCurrentHp(0);
        } else {
            monster.setCurrentHp(hp);
        }
        return attackText;
    }

    // Monster attacks player
    // REQUIRES: valid monster and character
    // MODIFIES: this
    // EFFECT: decreases player hp by monster attack
    public String enemyAttackDamage(Player player, Monster monster) {
        int enemyDamage = (int) Math.ceil(Math.random() * monster.getAttack());
        String attackText = ("Enemy " + monster.getName() + " attacks you for " + enemyDamage + " damage.");
        int hp = (player.getCurrentHp() - enemyDamage);
        if (hp <= 0) {
            player.setCurrentHp(0);
        } else {
            player.setCurrentHp(hp);
        }
        return attackText;
    }


    // Increase the exp of the player
    // REQUIRES: valid monster and non negative exp
    // MODIFIES: this
    // EFFECT: increases player total exp by exp and increases their level accordingly
    public void expGain(Player player, int exp) {
        player.setExp((player.getExp() + exp));
        if (player.getExp() > Math.pow(player.getLevel(), 3) + 15) {
            player.levelUp();
            System.out.println("Level up! you are now: Level " + player.getLevel());
            expGain(player, 0);
        }
    }


}
