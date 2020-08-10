package game;

import java.util.ArrayList;
import java.util.Observable;

public class Bestiary extends Observable {

    private Monster goblin = new Monster(1, "Goblin", 10, 1, 0);
    private Monster greenSlime = new Monster(2, "Green Slime", 10, 1, 0);
    private Monster wolf = new Monster(3, "Wolf", 6, 2, 0);
    private Monster skeleton = new Monster(4, "Skeleton", 8, 1, 0);
    private Monster zombie = new Monster(5, "Zombie", 20, 1, 0);
    private Monster ghoul = new Monster(6, "Ghoul", 28, 2, 1);
    private Monster troll = new Monster(7, "Troll", 40, 4, 5);
    private Monster vampire = new Monster(8, "Vampire", 100, 5, 3);

    private ArrayList<Monster> monsters = new ArrayList<Monster>();

    // Creates the Bestiary for game
    // MODIFIES: this
    // EFFECT: adds new MonsterUpdater to observe this class
    public Bestiary() {
        addObserver(new MonsterUpdater());
        createBestiary();
    }

    // Get list of monsters in Bestiary
    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    // REQUIRES: not null and not repeated monster
    // MODIFIES: this
    // EFFECT: adds monster if it is not null and is not previously found in bestiary
    public void addMonster(Monster m) {
        try {
            monsterAddingCheck(m);
        } catch (ImpossibleMonsterException e) {
            System.out.println("Can not add a null object to bestiary");
        } catch (ImpossibleIDException e) {
            System.out.println("Monster ID is already in the bestiary");
        }
        if ((m != null) && idCheck(m)) {
            setChanged();
            notifyObservers(m);
            monsters.add(m);
        } else {
            System.out.println("Error in adding new monster: " + m.getName());
        }
    }


    // EFFECT: throws exceptions if monster is null or if monster id already exists in bestiary
    public void monsterAddingCheck(Monster m) throws ImpossibleMonsterException, ImpossibleIDException {
        if (m == null) {
            throw new ImpossibleMonsterException();
        } else if (!idCheck(m)) {
            throw new ImpossibleIDException();
        } else {
            //System.out.println(m.getName() + " can be added without problems");
        }


    }

    // checks the monster id for repeated
    // EFFECT: return true if monster id is not previously found in list
    public boolean idCheck(Monster monster) {
        for (Monster m : monsters) {
            if (m.getId() == monster.getId()) {
                return false;
            }
        }
        return true;
    }

    // counts number of monsters in bestiary
    public String monsterCount() {
        return "Bestiary currently contains " + monsters.size() + " monsters";
    }

    // creates the bestiary
    // MODIFIES: this
    // EFFECTS: adds all monsters into the monster list
    public void createBestiary() {
        addMonster(goblin);
        addMonster(greenSlime);
        addMonster(wolf);
        addMonster(skeleton);
        addMonster(zombie);
        addMonster(ghoul);
        addMonster(troll);
        addMonster(vampire);
        //addMonster(dog);

    }

    // encounter a random monster
    // EFFECTS: returns a random monster found in list of monsters
    public Monster randomEncounter() {
        int index = (int) (Math.random() * monsters.size());
        Monster m = returnEncounter(index);
        return m;
//        Monster m = monsters.get(index);
//        System.out.println("A " + m.getName() + " Appeared! - ID: " + m.getId());
//        return m;
    }

    public Monster customEncouter(int id) {
        Monster m = returnEncounter(id);
        return m;
//        Monster m = monsters.get(id);
//        System.out.println("A " + m.getName() + " Appeared! - ID: " + m.getId());
//        return m;
    }

    public Monster returnEncounter(int id) {
        Monster m = monsters.get(id);
        System.out.println("A " + m.getName() + " Appeared! - ID: " + m.getId());
        return m;
    }

    // prints details on monster
    // EFFECT: prints details of given monster
    public void infoMonster(Monster m) {
        System.out.println(m.getId() + ": " + m.getName()
                + " | Hp: " + m.getHp() + " Atk: " + m.getAttack() + " Def: " + m.getDefence());
    }

    // REQUIRES: a non empty list of monsters in bestiary
    // EFFECT: prints the details of all monsters in bestiary
    public Boolean printAllMonsters() {
        for (Monster m : monsters) {
            infoMonster(m);
        }
        return true;
    }



}