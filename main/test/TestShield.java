package test;

import game.Shield;
import game.ShieldType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestShield {
    Shield nullShield;
    Shield s2;
    ShieldType fire;
    ShieldType water;
    ShieldType normal;

    @BeforeEach
    void runBefore() {
        nullShield = new Shield();
        s2 = new Shield("wood", 2);
        normal = new ShieldType();
        fire = new ShieldType("Fire");
        water = new ShieldType("Water");
    }

    @Test
    void testAddShieldType() {
        s2.addShieldType(fire);
        s2.addShieldType(water);
        assertEquals(s2.getType().size(), 2);
        assertTrue(water.getShields().contains(s2));
    }

}
