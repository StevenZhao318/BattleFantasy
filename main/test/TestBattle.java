package test;

import game.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
Unit tests for the Battle Class
 */
public class TestBattle {
    private static final Bestiary BESTIARY = new Bestiary();
    private static final Player PLAYER = new Player();
    private static final Monster MONSTER = new Monster(1, "Test Monster", 10, 1, 0);
    private static final Monster WEAKMONSTER = new Monster(2, "1HpMonster", 1, 1, 0);
    private static final Player WEAKPlAYER = new Player();
    private Battle battle;
    private Battle easyBattle;
    private Battle randomBattle;

    @BeforeEach
    void runBefore() {
        this.battle = new Battle(PLAYER, MONSTER);
        this.randomBattle = new Battle(PLAYER, BESTIARY);
        WEAKPlAYER.setTotalAttack(1);
        this.easyBattle = new Battle(WEAKPlAYER, WEAKMONSTER);
    }

    @Test
    void testGetPlayer() {
        assertEquals(battle.getPlayer(), PLAYER);
    }

    @Test
    void testGetEnemy() {
        assertEquals(battle.getEnemy(), MONSTER);
    }


    @Test
    void testDamageDealt() {
        assertEquals(WEAKMONSTER.getHp(), 1);
        assertEquals(easyBattle.playerAttackDamage(WEAKPlAYER, WEAKMONSTER), "You attack the 1HpMonster for 1 damage.");
        assertEquals(WEAKMONSTER.getCurrentHp(), 0);

        WEAKMONSTER.setCurrentHp(10);
        assertEquals(easyBattle.playerAttackDamage(WEAKPlAYER, WEAKMONSTER), "You attack the 1HpMonster for 1 damage.");
        assertEquals(WEAKMONSTER.getCurrentHp(), 9);
    }

    @Test
    void testDamageTaken() {
        assertEquals(WEAKPlAYER.getHp(), 25);
        assertEquals(easyBattle.enemyAttackDamage(WEAKPlAYER, WEAKMONSTER),
                "Enemy 1HpMonster attacks you for 1 damage.");
        assertEquals(WEAKPlAYER.getCurrentHp(), 24);

        WEAKPlAYER.setCurrentHp(1);
        assertEquals(easyBattle.enemyAttackDamage(WEAKPlAYER, WEAKMONSTER),
                "Enemy 1HpMonster attacks you for 1 damage.");
        assertEquals(WEAKPlAYER.getCurrentHp(), 0);
    }

    @Test
    void testExpGain() {
        battle.expGain(PLAYER, 1000);
        assertEquals(PLAYER.getExp(), 1000);
        assertEquals(PLAYER.getLevel(), 10);
    }

}
