package Adeventure.game;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {
	
	JFrame window;
	Container con;
	JPanel title , startButton, mainTextPanel, choicePanel , playerPanel;
	JLabel label, healthLabel, healthLabelNum, wLabel, wLabelName;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
	JButton start,choice1, choice2, choice3, choice4;
	JTextArea mainTextArea;
	int hp , monsterHealth, silverRing;
	String weapon, position;
	
	TitleScreenHandler tshandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();

	public static void main(String[] args) {
		
		new Game();

	}
	
	
	public Game() {
		
		window = new JFrame();
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		window.setVisible(true);
		
		con = window.getContentPane();
		
		title = new JPanel();
		title.setBounds(100, 100, 600, 150);
		title.setBackground(Color.black);
		label = new JLabel("Adventure");
		label.setForeground(Color.white);
		label.setFont(titleFont);
		
		startButton = new JPanel();
		startButton.setBounds(300, 400, 200, 100);
		startButton.setBackground(Color.black);
		
		start = new JButton("Start");
		start.setBackground(Color.black);
		start.setForeground(Color.white);
		start.setFont(normalFont);
		start.addActionListener(tshandler);
		start.setFocusPainted(false);
		
		title.add(label);
		startButton.add(start);
		
		con.add(title);
		con.add(startButton);
			
	}
	
	public void createGameScreen() {
		
		title.setVisible(false);
		startButton.setVisible(false);
		
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100,100,600,250);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);
		
		mainTextArea = new JTextArea("This is the main text area");
		mainTextArea.setBounds(100,100,600,250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);
		
		choicePanel = new JPanel();
		choicePanel.setBounds(250,350,300, 150);
		choicePanel.setBackground(Color.black);
		choicePanel.setLayout(new GridLayout(4,1));
		con.add(choicePanel);
		
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		choicePanel.add(choice1);
		
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choicePanel.add(choice2);
		
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choicePanel.add(choice3);
		
		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		choicePanel.add(choice4);
		
		playerPanel = new JPanel();
		playerPanel.setBounds(100,15,600,50);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(1,4));
		con.add(playerPanel);
		healthLabel = new JLabel("HP: ");
		healthLabel.setFont(normalFont);
		healthLabel.setForeground(Color.white);
		playerPanel.add(healthLabel);
		healthLabelNum = new JLabel();
		healthLabelNum.setFont(normalFont);
		healthLabelNum.setForeground(Color.white);
		playerPanel.add(healthLabelNum);
		wLabel = new JLabel("Weapon: ");
		wLabel.setFont(normalFont);
		wLabel.setForeground(Color.white);
		playerPanel.add(wLabel);
		wLabelName = new JLabel();
		wLabelName.setFont(normalFont);
		wLabelName.setForeground(Color.white);
		playerPanel.add(wLabelName);
		
		playerSetup();
			
	}
	
	public void playerSetup() {
		hp = 15;
		monsterHealth = 20;
		weapon = "Knife";
		wLabelName.setText(weapon);
		healthLabelNum.setText("" + hp);
		
		townGate();
		
		
	}
	
	public void townGate() {
		
		position = "townGate";
		mainTextArea.setText("You are at the gate of the town.\nA guard is standing in front of you. \n\nWhat do you do?");
		
		choice1.setText("Talk to the guard");
		choice2.setText("Attack the guard");
		choice3.setText("Leave");
		choice4.setText("");
	}
	
	public void talkGuard() {
		position = "talkGuard";
		mainTextArea.setText("Guard: Hello stranger. I have never seen your face. \nI'm sorry, but we cannot let a stranger into our town.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void attackGuard() {
		position = "attackGuard";
		mainTextArea.setText("Guard: Hey don't be stupid!\n\nThe gurard fought back and hit you hard. \n (You recieve 3 damage) ");
		hp = hp-3;
		healthLabelNum.setText("" + hp);
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void crossRoad() {
		position = "crossRoad";
		mainTextArea.setText("You are at a crossroad.\nIf you go south you will go back to the town");
		choice1.setText("Go North");
		choice2.setText("Go East");
		choice3.setText("Go South");
		choice4.setText("Go West");
	}
	
	public void north() {
		position = "north";
		mainTextArea.setText("There is a river. You drink the water and rest at the riverside. (Your HP is recovered by 2)");
		hp = hp+ 2;
		healthLabelNum.setText("" + hp);
		choice1.setText("Go South");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	public void east() {
		position = "east";
		mainTextArea.setText("You walked into a forest and found a Long Sword!\n\n(You obainted a long Sword)");
		weapon = "Long Sword";
		wLabelName.setText(weapon);
		choice1.setText("Go West");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	
		
	}
	public void west() {
		position = "west";
		mainTextArea.setText("You encouter a goblin!");
		choice1.setText("Fight");
		choice2.setText("Run");
		choice3.setText("");
		choice4.setText("");
		
		
	}
	public void fight() {
		position = "fight";
		mainTextArea.setText("Monster Health: " + monsterHealth + "\n\nWhat do you do?" );
		choice1.setText("Attack");
		choice2.setText("Run");
		choice3.setText("");
		choice4.setText("");
		
	}
	public void attack() {
		position = "attack";
		
		int playerDamage = 0;
		
		if(weapon.equals("Knife")) {
		playerDamage = new java.util.Random().nextInt(3);
		}
		else if(weapon.equals("Long Sword")) {
		playerDamage = new java.util.Random().nextInt(12);
		}
		mainTextArea.setText("You attacked the monster and gave " + playerDamage + " damage!");
		monsterHealth = monsterHealth - playerDamage;
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void monsterAttack() {
		position = "monsterAttack";
		
		int monsterDamage = 0;
		
		monsterDamage = new java.util.Random().nextInt(6);
		
		mainTextArea.setText("The monster attacked you and gave " + monsterDamage + " damage!");
		 hp = hp - monsterDamage;
		 healthLabelNum.setText("" + hp);
		 
		 choice1.setText(">");
		 choice2.setText("");
		 choice3.setText("");
		 choice4.setText("");
		
	}
	
	public void win() {
		position = "win";
		
		mainTextArea.setText("You defeated the monster!\nThe monster dropped a ring!\n\n(You obtained a Silver Ring)");
		silverRing = 1;
		choice1.setText("Go East");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
		
		
		
		
	}
	public void lose() {
		position = "lose";
		
		 mainTextArea.setText("YOu are dead!\n\n<GAME OVER>");
		 choice1.setText("");
		 choice2.setText("");
		 choice3.setText("");
		 choice4.setText("");
		 choice1.setVisible(false);
		 choice2.setVisible(false);
		 choice3.setVisible(false);
		 choice4.setVisible(false);
		
	}
	public void ending() {
		position = "ending";
		
		mainTextArea.setText("Guard: Oh you killed that goblin?!\nThank you so much. You are true hero!\nWelcome to our town!\n\n<THE END>");
		
		 choice1.setText("");
		 choice2.setText("");
		 choice3.setText("");
		 choice4.setText("");
		 choice1.setVisible(false);
		 choice2.setVisible(false);
		 choice3.setVisible(false);
		 choice4.setVisible(false);
	}
	public class TitleScreenHandler implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			createGameScreen();
		}
	}
	
	public class ChoiceHandler implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			
			String yourChoice = event.getActionCommand();
			
			switch(position) {
			case "townGate":
				switch(yourChoice) {
				case "c1":
					if(silverRing == 1) {
						ending();
					}else {
						talkGuard(); 
					}
					break;
				case "c2" : attackGuard(); break;
				case "c3" :  crossRoad(); break;
				}
				break;
			case "talkGuard":
				switch(yourChoice) {
				case "c1" : townGate(); break;
				}
				break;
			case "attackGuard" :
				switch(yourChoice) {
				case "c1" :townGate(); break;
				}
				break;
			case "crossRoad":
				switch(yourChoice) {
				case "c1" : north();  break;
				case "c2" : east(); break;
				case "c3" : townGate(); break;
				case "c4" :	west(); break;
				}
				break;
			case "north" : 
				switch(yourChoice) {
				case "c1" : crossRoad(); break;
				}
				break;
			case "east" :
				switch(yourChoice) {
				case "c1" : crossRoad();break;
				}
				break;
			case "west" :
				switch(yourChoice) {
				case "c1" : fight(); break;
				case "c2" : crossRoad(); break;
				}
				break;
			case "fight":
				switch(yourChoice) {
				case "c1" : attack(); break;
				case "c2" : crossRoad(); break;
				}
				break;
			case "attack" :
				switch(yourChoice) {
				case "c1" :
					if(monsterHealth <1) {
						win();
					}
					else {
						monsterAttack();
					}
					break;
					
				}
				break;
			case "monsterAttack" :
				switch(yourChoice) {
				case "c1" :
					if(hp < 1) {
						lose();
					}
					else {
						fight();
					}
					 break;
				}
				break;
				
			case "win" :
				switch(yourChoice) {
				case "c1" : crossRoad();
				}
			}
			
		}
	}
}
