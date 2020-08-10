package test;

import game.Player;
import game.Shield;
import game.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPlayer {
    private Player defaultPlayer;
    private Player customPlayer;
    private Weapon w0;
    private Weapon w1;
    private Shield s0;
    private Shield s1;

    @BeforeEach
    void runBefore() {
        w0 = new Weapon();
        w1 = new Weapon(2, "Sword", 5);
        s0 = new Shield();
        s1 = new Shield("Wooden Shield", 2);
        defaultPlayer = new Player();
        customPlayer = new Player("bob");
    }

    @Test
    void testGetSetName() {
        assertEquals(defaultPlayer.getName(), "Bob");
        defaultPlayer.setName("Steven");
        assertEquals(defaultPlayer.getName(), "Steven");
    }

    @Test
    void testSetWeapon() {
        defaultPlayer.setWeapon(w1);
        assertEquals(defaultPlayer.getWeapon(), w1);
    }

    @Test
    void testLevelUp() {
        defaultPlayer.levelUp();
        assertEquals(defaultPlayer.getLevel(), 2);
        assertEquals(defaultPlayer.getHp(), 35);
        assertEquals(defaultPlayer.getAttack(), 7);
        assertEquals(defaultPlayer.getDefence(), 2);
        assertEquals(defaultPlayer.getTotalAttack(), 7);
    }

    @Test
    void testFullHeal() {
        defaultPlayer.setCurrentHp(2);
        assertEquals(defaultPlayer.getCurrentHp(), 2);
        defaultPlayer.fullHeal();
        assertEquals(defaultPlayer.getCurrentHp(), 25);
    }

    @Test
    void testToString() {
        assertEquals(defaultPlayer.toString(),
                "Stats: Level = 1 | HP = 25/25 | Attack = 5");
    }



}
