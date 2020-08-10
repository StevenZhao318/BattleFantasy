package ui;

import game.Battle;
import game.Bestiary;
import game.Player;

public class Main {

    private Player mainPlayer;
    private Bestiary bestiary;
    private Battle battle;
    private TitleScreen titleScreen;

    //Builds a new game
    public Main() {
        this.titleScreen = new TitleScreen();

        startGame();
        titleScreen.setUpTitleScreen();
    }

    public static void main(String[] args) {
        new Main();
    }

    public void startGame() {
        System.out.println("Welcome to FantasyBattle. Good luck and have fun!");
    }



}
