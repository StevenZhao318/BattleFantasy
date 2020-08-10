package test;

import game.HealthPotion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestHealthPotion {
    HealthPotion hp1;

    @BeforeEach
    void runBefore() {
        hp1 = new HealthPotion("Red Potion", 10);
    }

    @Test
    void testUseConsumable() {
        assertTrue(hp1.useConsumable());
    }

    @Test
    void testInfoItem() {
        assertEquals(hp1.infoItem(), "Item: Red Potion | Restores: 10");
    }

    @Test
    void testGetType() {
        assertEquals(hp1.getType(), "Health");
    }

    @Test
    void testGetName() {
        assertEquals(hp1.getName(), "Red Potion");
    }

    @Test
    void testGetRestoreAMount() {
        assertEquals(hp1.getRestoreAmount(), 10);
    }
}
