package test;

import game.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestBestiary {
    private static final Bestiary BESTIARY = new Bestiary();
    private Monster dog = new Monster(3, "Dog", 10, 2, 1);
    private Monster blank = new Monster();
    private Monster dragon = new Monster(100, "Dragon", 100, 10, 10);

    @BeforeEach
    void runBefore() {

    }

    @Test
    void testAddMonster() {
        try {
            BESTIARY.monsterAddingCheck(dog);
            fail("ID is repeated in bestiary.");
        } catch (ImpossibleMonsterException ee) {
            fail("should not be null");
        } catch (ImpossibleIDException e) {
            System.out.println("caught the repeated ID");
        }

        try {
            BESTIARY.monsterAddingCheck(dragon);
        } catch (ImpossibleMonsterException e) {
            fail("Monster is clearly not null");
        } catch (ImpossibleIDException e) {
            fail("Monster is new and not repeated in Bestiary");
        }
    }


    @Test
    void testInfoMonster() {
        BESTIARY.infoMonster(dog);
        assertEquals("3: Dog | Hp: 10 Atk: 2 Def: 1", "3: Dog | Hp: 10 Atk: 2 Def: 1");
    }

    @Test
    void testRandomEncounter() {
        assertNotNull(BESTIARY.randomEncounter());
    }

    @Test
    void testCustomEncounter() {
        assertEquals(BESTIARY.customEncouter(0), BESTIARY.getMonsters().get(0));
    }

    @Test
    void testMonsterCount() {
        assertEquals(BESTIARY.monsterCount(),
                "Bestiary currently contains " + BESTIARY.getMonsters().size() + " monsters");
    }

    @Test
    void testPrintMonsters() {
        assertTrue(BESTIARY.printAllMonsters());
    }

}
