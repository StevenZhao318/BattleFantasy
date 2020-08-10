package ui;

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
 * The entirety of this playlist was watched, and many of his GUI code was referenced for this project
 */
public class TitleScreen implements ActionListener {

    private JFrame gameWindow;
    private Container container;
    private JPanel titlePanel;
    private JLabel titleLabel;
    private JPanel infoPanel;
    private JTextArea infoArea;
    private JPanel startPanel;
    private JButton startButton;
    private JPanel textInputPanel;
    private JTextField textInput;

    public static final Font TITLEFONT = new Font("Ariel", Font.BOLD, 90);
    public static final Font BASICFONT = new Font("Times New Roman", Font.PLAIN, 30);
    public static final Font INPUTFONT = new Font("Times New Roman", Font.BOLD, 30);

    GameScreen gameScreen;

    /**
     * Default constructor
    **/
    public TitleScreen() {}


    // REQUIRES: button clicked and myButton sent
    // MODIFIES: this
    // EFFECTS: Creates the game screen and removes title screen
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("myButton")) {
            titlePanel.setVisible(false);
            infoPanel.setVisible(false);
            startPanel.setVisible(false);
            gameScreen = new GameScreen(this.gameWindow, this.container, textInput.getText());
        }
    }

    // MODIFIES: this
    // EFFECTS: Create new title screen and add panels in it.
    public void setUpTitleScreen() {
        gameWindow = new JFrame();
        gameWindow.setSize(800,600);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.getContentPane().setBackground(Color.BLACK);
        gameWindow.setLayout(null); // prevents weird layout glitching
        gameWindow.setVisible(true);
        container = gameWindow.getContentPane();

        setUpTitlePanel();
        setUpInfoPanel();
        setUpStartPanel();
    }

    // MODIFIES: this
    // EFFECTS: create info panel and adds it to container
    public void setUpInfoPanel() {
        infoPanel = new JPanel();
        infoPanel.setBounds(200, 200, 400, 150);
        infoPanel.setBackground(Color.BLACK);
        infoArea = new JTextArea("Created by: Steven Zhao \n \n \nPlease input your name.");
        infoArea.setFont(BASICFONT);
        infoArea.setBackground(Color.BLACK);
        infoArea.setForeground(Color.YELLOW);

        infoPanel.add(infoArea);
        container.add(infoPanel);
    }

    // MODIFIES: this
    // creates user input field and start button and adds to container
    public void setUpStartPanel() {
        startPanel = new JPanel();
        startPanel.setBounds(275, 400, 250, 100);
        startPanel.setBackground(Color.BLACK);
        startPanel.setLayout(new GridLayout(2, 1));

        textInput = new JTextField();
        textInput.setHorizontalAlignment(JTextField.CENTER);
        textInput.setFont(INPUTFONT);
        startPanel.add(textInput);

        startButton = new JButton("Start Game");
        startButton.setForeground(Color.WHITE);
        startButton.setBackground(Color.BLACK);
        startButton.setFont(BASICFONT);
        startButton.setActionCommand("myButton");
        startButton.addActionListener(this);
        startPanel.add(startButton);

        container.add(startPanel);
    }

    // MODIFIES: this
    // EFFECTS: Creates title panel and adds to container
    public void setUpTitlePanel() {
        titlePanel = new JPanel();
        titlePanel.setBounds(100, 50, 600, 150);
        titlePanel.setBackground(Color.BLACK);
        titleLabel = new JLabel("FantasyBattle");
        titleLabel.setFont(TITLEFONT);
        titleLabel.setForeground(Color.YELLOW);

        titlePanel.add(titleLabel);
        container.add(titlePanel);
    }


}
