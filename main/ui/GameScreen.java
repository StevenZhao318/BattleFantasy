package ui;

import game.Battle;
import game.Bestiary;
import game.Monster;
import game.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * NOTE***
 * A Large portion of the following code design was inspired by following RyiSnow's Video tutorial on how
 * to make a simple adventure game.
 * The GUI design and main functionality are derived from his code, with additional functionality of my own.
 * Various videos were used as reference with the full playlist being found as provided
 *
 * https://www.youtube.com/playlist?list=PL_QPQmz5C6WUMB0xEMZosWbyQo_Kil0Fb
 * The entirety of this playlist was watched, and many of his GUI code was used for this project
 */

public class GameScreen implements ActionListener {

    public static final Font TEXTFONT = new Font("Times New Roman", Font.PLAIN, 30);
    public static final Font STATUSFONT = new Font("Ariel", Font.BOLD, 30);
    private Player mainPlayer;
    private Bestiary bestiary;
    private Monster enemy;
    private Battle battle = new Battle();

    String gameLocation = "Town";
    JFrame gameWindow;
    Container container;
    JPanel gameTextPanel;
    JTextArea gameTextArea;

    JPanel choicePanel;
    JPanel statusPanel;
    JLabel statusLabel;

    JButton choiceButton1;
    JButton choiceButton2;

    /**
     * Default constructor for GameScreen
     */
    public GameScreen(JFrame jf, Container con, String userInput) {
        this.gameWindow = jf;
        this.container = con;
        this.mainPlayer = new Player(userInput);
        this.bestiary = new Bestiary();
        createGameScreen();
    }


    // REQUIRES: Valid gameWindow and container
    // MODIFIES: this
    // EFFECTS: Creates the game panels
    public void createGameScreen() {
        gameTextPanel = new JPanel();
        gameTextPanel.setBounds(100, 100, 600, 250);
        gameTextPanel.setBackground(Color.BLACK);

        gameTextArea = new JTextArea("Welcome to the town of Salem.");
        gameTextArea.setBounds(100, 100, 600, 250);
        gameTextArea.setBackground(Color.BLACK);
        gameTextArea.setForeground(Color.WHITE);
        gameTextArea.setFont(TEXTFONT);
        gameTextArea.setLineWrap(true);
        gameTextArea.setWrapStyleWord(true);

        gameTextPanel.add(gameTextArea);
        container.add(gameTextPanel);

        setUpChoicePanel();
        setUpStatusPanel();
        goToTown();
    }

    // REQUIRES: Valid container
    // MODIFIES: this
    // EFFECTS: creates choice panel and call method to create choice buttons
    public void setUpChoicePanel() {
        choicePanel = new JPanel();
        choicePanel.setBounds(300, 400, 200, 100);
        choicePanel.setBackground(Color.BLACK);
        choicePanel.setLayout(new GridLayout(2, 1));
        container.add(choicePanel);

        setUpChoiceButtons();
    }

    // REQUIRES: Valid choicePanel
    // MODIFIES: this
    // EFFECTS: adds 2 choice buttons to choicePanel
    public void setUpChoiceButtons() {
        choiceButton1 = new JButton("");
        choiceButton1.setBackground(Color.black);
        choiceButton1.setForeground(Color.YELLOW);
        choiceButton1.setFont(TEXTFONT);
        choiceButton1.setActionCommand("choiceButton1");
        choiceButton1.addActionListener(this);
        choicePanel.add(choiceButton1);

        choiceButton2 = new JButton("");
        choiceButton2.setBackground(Color.black);
        choiceButton2.setForeground(Color.YELLOW);
        choiceButton2.setFont(TEXTFONT);
        choiceButton2.setActionCommand("choiceButton2");
        choiceButton2.addActionListener(this);
        choicePanel.add(choiceButton2);
    }

    // REQUIRES: Valid container
    // MODIFIES: this
    // EFFECTS: creates status bar and place it in statusPanel then in container
    public void setUpStatusPanel() {
        statusPanel = new JPanel();
        statusPanel.setBounds(100, 15, 600, 50);
        statusPanel.setBackground(Color.GRAY);
        container.add(statusPanel);

        statusLabel = new JLabel(mainPlayer.toString());
        statusLabel.setFont(STATUSFONT);
        statusLabel.setForeground(Color.YELLOW);
        statusPanel.add(statusLabel);
    }

    // REQUIRES: Instantiated choiceButton(s), and gameTextArea
    // MODIFIES: this
    // EFFECTS: goes to the screen of town with applicable choices
    public void goToTown() {
        gameLocation = "Town";
        gameTextArea.setText("Hello " + mainPlayer.getName() + "\nWelcome to the town of Salem."
                + "\nSelect battle to fight a random monster.");
        choiceButton1.setText("Rest at Inn");
        choiceButton2.setText("Battle");
        choiceButton2.setVisible(true);
        statusLabel.setText(mainPlayer.toString());
    }

    // REQUIRES: Instantiated choiceButton(s), and gameTextArea
    // MODIFIES: this
    // EFFECTS: goes to the screen of inn with applicable choices, and heals player
    public void restAtInn() {
        gameLocation = "Inn";
        gameTextArea.setText("You arrive at the inn and take a well deserved rest. Your HP is fully restored.");
        mainPlayer.fullHeal();
        statusLabel.setText(mainPlayer.toString());
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton2.setVisible(false);
    }

    // REQUIRES: Instantiated choiceButton(s), and gameTextArea
    // MODIFIES: this
    // EFFECTS: goes to the screen of battle with applicable choices
    public void battle() {
        gameLocation = "Battle";
        this.enemy = bestiary.randomEncounter();
        this.enemy.setCurrentHp(this.enemy.getHp()); //restore monster hp
        gameTextArea.setText("You have encountered a " + enemy.getName());
        choiceButton1.setText("Fight");
        choiceButton2.setText("Run Away");
    }

    // REQUIRES: Instantiated choiceButton(s), and gameTextArea
    // MODIFIES: this
    // EFFECTS: goes to the screen of fight with applicable choices
    public void fight() {
        gameLocation = "Fight";
        gameTextArea.setText("The enemy " + enemy.getName() + " has " + enemy.getCurrentHp() + " HP.");
        choiceButton1.setText("Attack");
        choiceButton2.setVisible(true);
        choiceButton2.setText("Run Away");
        statusLabel.setText("Player HP = " + mainPlayer.getCurrentHp() + "/" + mainPlayer.getHp());
    }

    // REQUIRES: Instantiated choiceButton(s), and gameTextArea
    // MODIFIES: this
    // EFFECTS: goes to the screen of after Player action with applicable choices,
    // calculates damage done
    public void playerTurn() {
        gameLocation = "PlayerTurn";
        String attackText = battle.playerAttackDamage(mainPlayer, enemy);
        gameTextArea.setText(attackText);
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton2.setVisible(false);
    }

    // REQUIRES: Instantiated choiceButton(s), and gameTextArea
    // MODIFIES: this
    // EFFECTS: goes to the screen of after enemy action with applicable choices,
    // calculates damage done, and updates hp
    public void monsterTurn() {
        gameLocation = "MonsterTurn";

        String attackText = battle.enemyAttackDamage(mainPlayer, enemy);
        statusLabel.setText("Player HP = " + mainPlayer.getCurrentHp() + "/" + mainPlayer.getHp());
        gameTextArea.setText(attackText);
        choiceButton1.setText("Continue");
        choiceButton2.setText("");
        choiceButton2.setVisible(false);
    }

    // REQUIRES: Instantiated choiceButton(s), and gameTextArea
    // MODIFIES: this
    // EFFECTS: goes to the screen of a victory in battle
    public void victoryScreen() {
        gameLocation = "Victory";
        gameTextArea.setText("You defeated the " + enemy.getName() + " and are victorious!");
        choiceButton1.setText("Continue");
    }

    // REQUIRES: Instantiated choiceButton(s), and gameTextArea
    // MODIFIES: this
    // EFFECTS: goes to the screen of a defeat in battle, and sets hp to 1 before returning to town
    public void defeatScreen() {
        gameLocation = "Defeat";
        gameTextArea.setText("Oh dear, you are defeated... \n"
                + "You hear people running towards you but faint...  \n"
                + "You find yourself back in town.");
        choiceButton1.setText("Continue");
        mainPlayer.setCurrentHp(1);
    }

    // REQUIRES: an valid actionEvent (button clicked) and location set as String
    // EFFECTS: called the method
    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameLocation.equals("Town")) {
            townChoices(e);
        } else if (gameLocation.equals("Inn")) {
            backToTownChoice(e);
        } else if (gameLocation.equals("Battle")) {
            battleChoice(e);
        } else if (gameLocation.equals("Fight")) {
            fightChoice(e);
        } else if (gameLocation.equals("PlayerTurn")) {
            continuePlayerAttack(e);
        } else if (gameLocation.equals("MonsterTurn")) {
            continueMonsterAttack(e);
        } else if (gameLocation.equals("Victory")) {
            backToTownChoice(e);
        } else if (gameLocation.equals("Defeat")) {
            backToTownChoice(e);
        }
    }

    // REQUIRES: an valid actionEvent (button clicked)
    // EFFECTS: calls the method that goes to the screen that corresponds to the button clicked
    public void continueMonsterAttack(ActionEvent e) {
        if (e.getActionCommand().equals("choiceButton1")) {
            if (mainPlayer.getCurrentHp() <= 0) {
                defeatScreen();
            } else {
                fight();
            }
        }
    }

    // REQUIRES: an valid actionEvent (button clicked)
    // EFFECTS: calls the method that goes to the screen that corresponds to the button clicked
    public void continuePlayerAttack(ActionEvent e) {
        if (e.getActionCommand().equals("choiceButton1")) {
            if (enemy.getCurrentHp() <= 0) {
                victoryScreen();
            } else {
                monsterTurn();
            }
        }
    }

    // REQUIRES: an valid actionEvent (button clicked)
    // EFFECTS: calls the method that goes to the screen that corresponds to the button clicked
    public void fightChoice(ActionEvent e) {
        if (e.getActionCommand().equals("choiceButton1")) {
            playerTurn();
        } else if (e.getActionCommand().equals("choiceButton2")) {
            goToTown();
        }
    }

    // REQUIRES: an valid actionEvent (button clicked)
    // EFFECTS: calls the method that goes to the screen that corresponds to the button clicked
    public void battleChoice(ActionEvent e) {
        if (e.getActionCommand().equals("choiceButton1")) {
            fight();
        } else if (e.getActionCommand().equals("choiceButton2")) {
            goToTown();
        }
    }

    // REQUIRES: an valid actionEvent (button clicked)
    // EFFECTS: calls the method that goes to the screen that corresponds to the button clicked
    public void backToTownChoice(ActionEvent e) {
        if (e.getActionCommand().equals("choiceButton1")) {
            goToTown();
        }
    }

    // REQUIRES: an valid actionEvent (button clicked)
    // EFFECTS: calls the method that goes to the screen that corresponds to the button clicked
    public void townChoices(ActionEvent e) {
        if (e.getActionCommand().equals("choiceButton1")) {
            restAtInn();
        } else if (e.getActionCommand().equals("choiceButton2")) {
            battle();
        }
    }

}

