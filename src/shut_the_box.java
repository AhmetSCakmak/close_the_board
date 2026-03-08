import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.math.*;
import javax.swing.ImageIcon;

class shut_the_box
{
	private static int width = 900;
	private static int height = 800;
	private static JButton roll;
	private static JButton one;
	private static JButton two;
	private static JButton three;
	private static JButton four;
	private static JButton five;
	private static JButton six;
	private static JButton seven;
	private static JButton eight;
	private static JButton nine;
	private static JButton ten;
	private static JButton eleven;
	private static JButton twelve;
	private static JLabel labelDice1;
	private static JLabel labelDice2;
	private static JLabel labelOne;
	private static JLabel labelTwo;
	private static JLabel labelThree;
	private static JLabel labelFour;
	private static JLabel labelFive;
	private static JLabel labelSix;
	private static JLabel labelSeven;
	private static JLabel labelEight;
	private static JLabel labelNine;
	private static JLabel labelTen;
	private static JLabel labelEleven;
	private static JLabel labelTwelve;
	private static JLabel empty;
  private static JLabel gameScore;
	private static JDialog popUpDialog;
	private static int score;
	private static JFrame f;
  private static boolean[] closedThisTurn;
  private static ImageIcon pngZero;
  private static ImageIcon pngOne;
  private static ImageIcon pngTwo;
  private static ImageIcon pngThree;
  private static ImageIcon pngFour;
  private static ImageIcon pngFive;
  private static ImageIcon pngSix;
  private static ImageIcon pngSeven;
  private static ImageIcon pngEight;
  private static ImageIcon pngNine;
  private static ImageIcon pngTen;
  private static ImageIcon pngEleven;
  private static ImageIcon pngTwelve;
	
	public static void main(String[] args)
	{
    pngZero = new ImageIcon("../images/0.png");
    pngOne = new ImageIcon("../images/1.png");
    pngTwo = new ImageIcon("../images/2.png");
    pngThree = new ImageIcon("../images/3.png");
    pngFour = new ImageIcon("../images/4.png");
    pngFive = new ImageIcon("../images/5.png");
    pngSix = new ImageIcon("../images/6.png");
    pngSeven = new ImageIcon("../images/7.png");
    pngEight = new ImageIcon("../images/8.png");
    pngNine = new ImageIcon("../images/9.png");
    pngTen = new ImageIcon("../images/10.png");
    pngEleven = new ImageIcon("../images/11.png");
    pngTwelve = new ImageIcon("../images/12.png");

    closedThisTurn = new boolean[12];
		for (int i = 0; i < 12; i++)
		{
      closedThisTurn[i] = false;
		}
		f = new JFrame();
		f.setPreferredSize(new Dimension(width, height));
		f.setMinimumSize(new Dimension(width, height));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		JMenuItem reset = new JMenuItem("Reset");
		reset.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.ActionEvent.ALT_MASK));
		JMenuItem fileExit = new JMenuItem("Exit");	
		fileExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.ActionEvent.ALT_MASK));
		
		MenuItemActionListener resetActionListener = new MenuItemActionListener(reset);
		MenuItemActionListener fileExitMenuItemActionListener = new MenuItemActionListener(fileExit);
		reset.addActionListener(resetActionListener);
		fileExit.addActionListener(fileExitMenuItemActionListener);
		menuBar.add(menu);
		menu.add(reset);
		menu.add(fileExit);
		
		JPanel leftButtonPanel = new JPanel();
		leftButtonPanel.setBorder(new javax.swing.border.LineBorder(new Color(0, 0, 0, 255), 2));
		GridBagLayout gridBagLayoutLeft = new GridBagLayout();
		GridBagConstraints buttonPanelConstraintsLeft = new GridBagConstraints();
		leftButtonPanel.setLayout(gridBagLayoutLeft);
		leftButtonPanel.setPreferredSize(new Dimension(430, 600));
		leftButtonPanel.setMinimumSize(new Dimension(430, 600));
		
		JPanel rightButtonPanel = new JPanel();
		rightButtonPanel.setBorder(new javax.swing.border.LineBorder(new Color(0, 0, 0, 255), 2));
		GridBagLayout gridBagLayoutRight = new GridBagLayout();
		GridBagConstraints buttonPanelConstraintsRight = new GridBagConstraints();
		rightButtonPanel.setLayout(gridBagLayoutRight);
		rightButtonPanel.setPreferredSize(new Dimension(430, 600));
		rightButtonPanel.setMinimumSize(new Dimension(430, 600));
		
		buttonPanelConstraintsLeft.fill = GridBagConstraints.NONE;
		buttonPanelConstraintsLeft.anchor = GridBagConstraints.LINE_START;
		buttonPanelConstraintsLeft.weightx = 1;
		buttonPanelConstraintsLeft.weighty = 1;
		
		buttonPanelConstraintsRight.fill = GridBagConstraints.NONE;
		buttonPanelConstraintsRight.anchor = GridBagConstraints.LINE_START;
		buttonPanelConstraintsRight.weightx = 1;
		buttonPanelConstraintsRight.weighty = 1;
		
		JPanel mainButtonPanel = new JPanel();
		mainButtonPanel.setBorder(new javax.swing.border.LineBorder(new Color(0, 0, 0, 255), 2));
		BoxLayout boxLayout = new BoxLayout(mainButtonPanel, BoxLayout.X_AXIS);
		mainButtonPanel.setLayout(boxLayout);
		
		mainButtonPanel.add(leftButtonPanel);
		mainButtonPanel.add(rightButtonPanel);
		
		JPanel dicePanel = new JPanel();
		dicePanel.setBorder(new javax.swing.border.LineBorder(new Color(0, 0, 0, 255), 2));
		GridBagLayout gridBagLayoutDice = new GridBagLayout();
		GridBagConstraints panelConstraintsDice = new GridBagConstraints();
		dicePanel.setLayout(gridBagLayoutDice);
		dicePanel.setPreferredSize(new Dimension(880, 200));
		dicePanel.setMinimumSize(new Dimension(880, 200));
		panelConstraintsDice.fill = GridBagConstraints.NONE;
		panelConstraintsDice.weightx = 1;
		panelConstraintsDice.weighty = 1;
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(new javax.swing.border.LineBorder(new Color(0, 0, 0, 255), 2));
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(menuBar, BorderLayout.NORTH);
		mainPanel.add(mainButtonPanel, BorderLayout.CENTER);
		mainPanel.add(dicePanel, BorderLayout.SOUTH);
		
		one = new JButton("One", pngOne);
		two = new JButton("Two", pngTwo);
		three = new JButton("Three", pngThree);
		four = new JButton("Four", pngFour);
		five = new JButton("Five", pngFive);
		six = new JButton("Six", pngSix);
		seven = new JButton("Seven", pngSeven);
    eight = new JButton("Eight", pngEight);
    nine = new JButton("Nine", pngNine);
    ten = new JButton("Ten", pngTen);
    eleven = new JButton("Eleven", pngEleven);
    twelve = new JButton("Twelve", pngTwelve);

		ButtonActionListener oneAL = new ButtonActionListener(one);
		ButtonActionListener twoAL = new ButtonActionListener(two);
		ButtonActionListener threeAL = new ButtonActionListener(three);
		ButtonActionListener fourAL = new ButtonActionListener(four);
		ButtonActionListener fiveAL = new ButtonActionListener(five);
		ButtonActionListener sixAL = new ButtonActionListener(six);
		ButtonActionListener sevenAL = new ButtonActionListener(seven);
		ButtonActionListener eightAL = new ButtonActionListener(eight);
		ButtonActionListener nineAL = new ButtonActionListener(nine);
		ButtonActionListener tenAL = new ButtonActionListener(ten);
		ButtonActionListener elevenAL = new ButtonActionListener(eleven);
		ButtonActionListener twelveAL = new ButtonActionListener(twelve);
		
		one.addActionListener(oneAL);
		two.addActionListener(twoAL);
		three.addActionListener(threeAL);
		four.addActionListener(fourAL);
		five.addActionListener(fiveAL);
		six.addActionListener(sixAL);
		seven.addActionListener(sevenAL);
		eight.addActionListener(eightAL);
		nine.addActionListener(nineAL);
		ten.addActionListener(tenAL);
		eleven.addActionListener(elevenAL);
		twelve.addActionListener(twelveAL);

		one.setEnabled(false);	
		two.setEnabled(false);	
		three.setEnabled(false);	
		four.setEnabled(false);	
		five.setEnabled(false);	
		six.setEnabled(false);	
		seven.setEnabled(false);	
		eight.setEnabled(false);	
		nine.setEnabled(false);	
		ten.setEnabled(false);	
		eleven.setEnabled(false);	
		twelve.setEnabled(false);	
		
		labelOne = new JLabel("Open");
		labelTwo = new JLabel("Open");
		labelThree = new JLabel("Open");
		labelFour = new JLabel("Open");
		labelFive = new JLabel("Open");
		labelSix = new JLabel("Open");
		labelSeven = new JLabel("Open");
		labelEight = new JLabel("Open");
		labelNine = new JLabel("Open");
		labelTen = new JLabel("Open");
		labelEleven = new JLabel("Open");
		labelTwelve = new JLabel("Open");
		
		buttonPanelConstraintsLeft.gridx = 0;
		buttonPanelConstraintsLeft.gridy = 0;
		buttonPanelConstraintsLeft.gridwidth = 1;
		gridBagLayoutLeft.setConstraints(one, buttonPanelConstraintsLeft);
		
		buttonPanelConstraintsLeft.gridx = 1;
		buttonPanelConstraintsLeft.gridy = 0;
		buttonPanelConstraintsLeft.gridwidth = GridBagConstraints.REMAINDER;
		gridBagLayoutLeft.setConstraints(labelOne, buttonPanelConstraintsLeft);
		
		buttonPanelConstraintsLeft.gridx = 0;
		buttonPanelConstraintsLeft.gridy = 1;
		buttonPanelConstraintsLeft.gridwidth = 1;
		gridBagLayoutLeft.setConstraints(two, buttonPanelConstraintsLeft);
		
		buttonPanelConstraintsLeft.gridx = 1;
		buttonPanelConstraintsLeft.gridy = 1;
		buttonPanelConstraintsLeft.gridwidth = GridBagConstraints.REMAINDER;
		gridBagLayoutLeft.setConstraints(labelTwo, buttonPanelConstraintsLeft);
		
		buttonPanelConstraintsLeft.gridx = 0;
		buttonPanelConstraintsLeft.gridy = 2;
		buttonPanelConstraintsLeft.gridwidth = 1;
		gridBagLayoutLeft.setConstraints(three, buttonPanelConstraintsLeft);
		
		buttonPanelConstraintsLeft.gridx = 1;
		buttonPanelConstraintsLeft.gridy = 2;
		buttonPanelConstraintsLeft.gridwidth = GridBagConstraints.REMAINDER;
		gridBagLayoutLeft.setConstraints(labelThree, buttonPanelConstraintsLeft);
		
		buttonPanelConstraintsLeft.gridx = 0;
		buttonPanelConstraintsLeft.gridy = 3;
		buttonPanelConstraintsLeft.gridwidth = 1;
		gridBagLayoutLeft.setConstraints(four, buttonPanelConstraintsLeft);
		
		buttonPanelConstraintsLeft.gridx = 1;
		buttonPanelConstraintsLeft.gridy = 3;
		buttonPanelConstraintsLeft.gridwidth = GridBagConstraints.REMAINDER;
		gridBagLayoutLeft.setConstraints(labelFour, buttonPanelConstraintsLeft);
		
		buttonPanelConstraintsLeft.gridx = 0;
		buttonPanelConstraintsLeft.gridy = 4;
		buttonPanelConstraintsLeft.gridwidth = 1;
		gridBagLayoutLeft.setConstraints(five, buttonPanelConstraintsLeft);
		
		buttonPanelConstraintsLeft.gridx = 1;
		buttonPanelConstraintsLeft.gridy = 4;
		buttonPanelConstraintsLeft.gridwidth = GridBagConstraints.REMAINDER;
		gridBagLayoutLeft.setConstraints(labelFive, buttonPanelConstraintsLeft);
		
		buttonPanelConstraintsLeft.gridx = 0;
		buttonPanelConstraintsLeft.gridy = 5;
		buttonPanelConstraintsLeft.gridwidth = 1;
		gridBagLayoutLeft.setConstraints(six, buttonPanelConstraintsLeft);
		
		buttonPanelConstraintsLeft.gridx = 1;
		buttonPanelConstraintsLeft.gridy = 5;
		buttonPanelConstraintsLeft.gridwidth = GridBagConstraints.REMAINDER;
		gridBagLayoutLeft.setConstraints(labelSix, buttonPanelConstraintsLeft);
		
		leftButtonPanel.add(one);
		leftButtonPanel.add(labelOne);
		leftButtonPanel.add(two);
		leftButtonPanel.add(labelTwo);
		leftButtonPanel.add(three);
		leftButtonPanel.add(labelThree);
		leftButtonPanel.add(four);
		leftButtonPanel.add(labelFour);
		leftButtonPanel.add(five);
		leftButtonPanel.add(labelFive);
		leftButtonPanel.add(six);
		leftButtonPanel.add(labelSix);
		
		buttonPanelConstraintsRight.gridx = 0;
		buttonPanelConstraintsRight.gridy = 0;
		buttonPanelConstraintsRight.gridwidth = 1;
		gridBagLayoutRight.setConstraints(seven, buttonPanelConstraintsRight);
		
		buttonPanelConstraintsRight.gridx = 1;
		buttonPanelConstraintsRight.gridy = 0;
		buttonPanelConstraintsRight.gridwidth = GridBagConstraints.REMAINDER;
		gridBagLayoutRight.setConstraints(labelSeven, buttonPanelConstraintsRight);
		
		buttonPanelConstraintsRight.gridx = 0;
		buttonPanelConstraintsRight.gridy = 1;
		buttonPanelConstraintsRight.gridwidth = 1;
		gridBagLayoutRight.setConstraints(eight, buttonPanelConstraintsRight);
		
		buttonPanelConstraintsRight.gridx = 1;
		buttonPanelConstraintsRight.gridy = 1;
		buttonPanelConstraintsRight.gridwidth = GridBagConstraints.REMAINDER;
		gridBagLayoutRight.setConstraints(labelEight, buttonPanelConstraintsRight);
		
		buttonPanelConstraintsRight.gridx = 0;
		buttonPanelConstraintsRight.gridy = 2;
		buttonPanelConstraintsRight.gridwidth = 1;
		gridBagLayoutRight.setConstraints(nine, buttonPanelConstraintsRight);
		
		buttonPanelConstraintsRight.gridx = 1;
		buttonPanelConstraintsRight.gridy = 2;
		buttonPanelConstraintsRight.gridwidth = GridBagConstraints.REMAINDER;
		gridBagLayoutRight.setConstraints(labelNine, buttonPanelConstraintsRight);
		
		buttonPanelConstraintsRight.gridx = 0;
		buttonPanelConstraintsRight.gridy = 3;
		buttonPanelConstraintsRight.gridwidth = 1;
		gridBagLayoutRight.setConstraints(ten, buttonPanelConstraintsRight);
		
		buttonPanelConstraintsRight.gridx = 1;
		buttonPanelConstraintsRight.gridy = 3;
		buttonPanelConstraintsRight.gridwidth = GridBagConstraints.REMAINDER;
		gridBagLayoutRight.setConstraints(labelTen, buttonPanelConstraintsRight);
		
		buttonPanelConstraintsRight.gridx = 0;
		buttonPanelConstraintsRight.gridy = 4;
		buttonPanelConstraintsRight.gridwidth = 1;
		gridBagLayoutRight.setConstraints(eleven, buttonPanelConstraintsRight);
		
		buttonPanelConstraintsRight.gridx = 1;
		buttonPanelConstraintsRight.gridy = 4;
		buttonPanelConstraintsRight.gridwidth = GridBagConstraints.REMAINDER;
		gridBagLayoutRight.setConstraints(labelEleven, buttonPanelConstraintsRight);
		
		buttonPanelConstraintsRight.gridx = 0;
		buttonPanelConstraintsRight.gridy = 5;
		buttonPanelConstraintsRight.gridwidth = 1;
		gridBagLayoutRight.setConstraints(twelve, buttonPanelConstraintsRight);
		
		buttonPanelConstraintsRight.gridx = 1;
		buttonPanelConstraintsRight.gridy = 5;
		buttonPanelConstraintsRight.gridwidth = GridBagConstraints.REMAINDER;
		gridBagLayoutRight.setConstraints(labelTwelve, buttonPanelConstraintsRight);
		
		rightButtonPanel.add(seven);
		rightButtonPanel.add(labelSeven);
		rightButtonPanel.add(eight);
		rightButtonPanel.add(labelEight);
		rightButtonPanel.add(nine);
		rightButtonPanel.add(labelNine);
		rightButtonPanel.add(ten);
		rightButtonPanel.add(labelTen);
		rightButtonPanel.add(eleven);
		rightButtonPanel.add(labelEleven);
		rightButtonPanel.add(twelve);
		rightButtonPanel.add(labelTwelve);
		
		roll = new JButton("Play");
		ButtonActionListener rollAL = new ButtonActionListener(roll);
		roll.addActionListener(rollAL);
		roll.setEnabled(true);
		
		labelDice1 = new JLabel();
		labelDice2 = new JLabel();
 		empty = new JLabel();
		
		panelConstraintsDice.gridx = 1;
		panelConstraintsDice.gridy = 0;
		panelConstraintsDice.gridwidth = 1;
		gridBagLayoutDice.setConstraints(empty, panelConstraintsDice);

		panelConstraintsDice.gridx = 0;
		panelConstraintsDice.gridy = 2;
		panelConstraintsDice.gridwidth = 1;
		gridBagLayoutDice.setConstraints(labelDice1, panelConstraintsDice);
		
		panelConstraintsDice.gridx = 2;
		panelConstraintsDice.gridy = 2;
		panelConstraintsDice.gridwidth = 1;
		gridBagLayoutDice.setConstraints(labelDice2, panelConstraintsDice);
		
		panelConstraintsDice.gridx = 0;
		panelConstraintsDice.gridy = 4;
		panelConstraintsDice.gridwidth = GridBagConstraints.REMAINDER;
		roll.setPreferredSize(new Dimension(600,25));
		gridBagLayoutDice.setConstraints(roll, panelConstraintsDice);

		
    dicePanel.add(empty);
		dicePanel.add(labelDice1);
		dicePanel.add(labelDice2);
		dicePanel.add(roll);
		
		f.setContentPane(mainPanel);
		f.validate();
		f.setVisible(true);
		
	}
	
	private static int diceRoll()
	{
		int dice = (int)(Math.random()*6+1);
		return dice;
	}
	
  private static void closeOne(){
    if(score >= 1){
      score -= 1;
      labelOne.setText("Selected");
      closedThisTurn[0] = true;
    }
  }

  private static void closeTwo(){
    if(score >= 2){
      score -= 2;
      labelTwo.setText("Selected");
      closedThisTurn[1] = true;
    }
  }

  private static void closeThree(){
    if(score >= 3){
      score -= 3;
      labelThree.setText("Selected");
      closedThisTurn[2] = true;
    }
  }

  private static void closeFour(){
    if(score >= 4){
      score -= 4 ;
      labelFour.setText("Selected");
      closedThisTurn[3] = true;
    }
  }

  private static void closeFive(){
    if(score >= 5){
      score -= 5 ;
      labelFive.setText("Selected");
      closedThisTurn[4] = true;
    }
  }

  private static void closeSix(){
    if(score >= 6){
      score -= 6;
      labelSix.setText("Selected");
      closedThisTurn[5] = true;
    }
  }

  private static void closeSeven(){
    if(score >= 7){
      score -= 7;
      labelSeven.setText("Selected");
      closedThisTurn[6] = true;
    }
  }

  private static void closeEight(){
    if(score >= 8){
      score -= 8;
      labelEight.setText("Selected");
      closedThisTurn[7] = true;
    }
  }

  private static void closeNine(){
    if(score >= 9){
      score -= 9;
      labelNine.setText("Selected");
      closedThisTurn[8] = true;
    }
  }

  private static void closeTen(){
    if(score >= 10){
      score -= 10;
      labelTen.setText("Selected");
      closedThisTurn[9] = true;
    }
  }

  private static void closeEleven(){
    if(score >= 11){
      score -= 11;
      labelEleven.setText("Selected");
      closedThisTurn[10] = true;
    }
  }

  private static void closeTwelve(){
    if(score >= 12){
      score -= 12;
      labelTwelve.setText("Selected");
      closedThisTurn[11] = true;
    }
  }

  private static void openOne(){
    labelOne.setText("Open");
    score += 1;
    closedThisTurn[0] = false;
  }

  private static void openTwo(){
    labelTwo.setText("Open");
    score += 2;
    closedThisTurn[1] = false;
  }

  private static void openThree(){
    labelThree.setText("Open");
    score += 3;
    closedThisTurn[2] = false;
  }

  private static void openFour(){
    labelFour.setText("Open");
    score += 4;
    closedThisTurn[3] = false;
  }

  private static void openFive(){
    labelFive.setText("Open");
    score += 5;
    closedThisTurn[4] = false;
  }

  private static void openSix(){
    labelSix.setText("Open");
    score += 6;
    closedThisTurn[5] = false;
  }

  private static void openSeven(){
    labelSeven.setText("Open");
    score += 7;
    closedThisTurn[6] = false;
  }

  private static void openEight(){
    labelEight.setText("Open");
    score += 8;
    closedThisTurn[7] = false;
  }

  private static void openNine(){
    labelNine.setText("Open");
    score += 9;
    closedThisTurn[8] = false;
  }

  private static void openTen(){
    labelTen.setText("Open");
    score += 10;
    closedThisTurn[9] = false;
  }

  private static void openEleven(){
    labelEleven.setText("Open");
    score += 11;
    closedThisTurn[10] = false;
  }

  private static void openTwelve(){
    labelTwelve.setText("Open");
    score += 12;
    closedThisTurn[11] = false;
  }
	
	private static void gameOver()
	{
		int scoreLeft = 0;
		if(labelOne.getText() != "Closed"){
      scoreLeft += 1;
    }
    if(labelTwo.getText() != "Closed"){
      scoreLeft += 2;
    }
    if(labelThree.getText() != "Closed"){
      scoreLeft += 3;
    }
    if(labelFour.getText() != "Closed"){
      scoreLeft += 4;
    }
    if(labelFive.getText() != "Closed"){
      scoreLeft += 5;
    }
    if(labelSix.getText() != "Closed"){
      scoreLeft += 6;
    }
    if(labelSeven.getText() != "Closed"){
      scoreLeft += 7;
    }
    if(labelEight.getText() != "Closed"){
      scoreLeft += 8;
    }
    if(labelNine.getText() != "Closed"){
      scoreLeft += 9;
    }
    if(labelTen.getText() != "Closed"){
      scoreLeft += 10;
    }
    if(labelEleven.getText() != "Closed"){
      scoreLeft += 11;
    }
    if(labelTwelve.getText() != "Closed"){
      scoreLeft += 12;
    }
    one.setEnabled(false);	
		two.setEnabled(false);	
		three.setEnabled(false);	
		four.setEnabled(false);	
		five.setEnabled(false);	
		six.setEnabled(false);	
		seven.setEnabled(false);	
		eight.setEnabled(false);	
		nine.setEnabled(false);	
		ten.setEnabled(false);	
		eleven.setEnabled(false);	
		twelve.setEnabled(false);
		roll.setEnabled(false);
		JPanel popUpPanel = new JPanel();
		gameScore = new JLabel(Integer.toString(scoreLeft));
		Font currentFont = gameScore.getFont();
		Font newFont = currentFont.deriveFont(50f);
		gameScore.setFont(newFont);
    if(scoreLeft == 0){
      gameScore = new JLabel("You Win!");
      popUpPanel.add(gameScore);
      popUpPanel.setBackground(Color.LIGHT_GRAY);
      popUpDialog = new JDialog(f, "Winner ", true);
      popUpDialog.add(popUpPanel);
      popUpDialog.setSize(250, 150);
      popUpDialog.setLocationRelativeTo(f);
      popUpDialog.setVisible(true);
    }else{
      popUpPanel.add(gameScore);
      popUpPanel.setBackground(Color.LIGHT_GRAY);
      popUpDialog = new JDialog(f, "Open board score is: ", true);
      popUpDialog.add(popUpPanel);
      popUpDialog.setSize(250, 150);
      popUpDialog.setLocationRelativeTo(f);
      popUpDialog.setVisible(true);
    }
	}
	
	private static void resetGame()
	{
		labelOne.setText("Open");
		labelTwo.setText("Open");
		labelThree.setText("Open");
		labelFour.setText("Open");
		labelFive.setText("Open");
		labelSix.setText("Open");
		labelSeven.setText("Open");
		labelEight.setText("Open");
		labelNine.setText("Open");
		labelTen.setText("Open");
		labelEleven.setText("Open");
		labelTwelve.setText("Open");
		labelDice1.setIcon(new ImageIcon ("../images/dice_6.png"));
		labelDice2.setIcon(new ImageIcon ("../images/dice_6.png"));
		
		one.setEnabled(false);	
		two.setEnabled(false);	
		three.setEnabled(false);	
		four.setEnabled(false);	
		five.setEnabled(false);	
		six.setEnabled(false);	
		seven.setEnabled(false);	
		eight.setEnabled(false);	
		nine.setEnabled(false);	
		ten.setEnabled(false);	
		eleven.setEnabled(false);	
		twelve.setEnabled(false);
		roll.setEnabled(true);
		popUpDialog.setVisible(false);
    score = 0;
    empty.setIcon(pngZero);    
		
		for (int i = 0; i < 13; i++)
		{
			closedThisTurn[i] = false;
		}
	}
	
	static class ButtonActionListener implements java.awt.event.ActionListener
	{
		private javax.swing.JButton b;
		
		ButtonActionListener(javax.swing.JButton b)
		{
			this.b = b;
		}
		
		public void actionPerformed(java.awt.event.ActionEvent e)
		{
      if( b.getText().toLowerCase().equals("one") )
  	  {
        if(closedThisTurn[0]){
          openOne();
        }else{
          closeOne();
        }
        if(score == 0){
          empty.setIcon(pngZero);
        }
        if(score == 1){
          empty.setIcon(pngOne);
        }
        if(score == 2){
          empty.setIcon(pngTwo);
        }
        if(score == 3){
          empty.setIcon(pngThree);
        }
        if(score == 4){
          empty.setIcon(pngFour);
        }
        if(score == 5){
          empty.setIcon(pngFive);
        }
        if(score == 6){
          empty.setIcon(pngSix);
        }
        if(score == 7){
          empty.setIcon(pngSeven);
        }
        if(score == 8){
          empty.setIcon(pngEight);
        }
        if(score == 9){
          empty.setIcon(pngNine);
        }
        if(score == 10){
          empty.setIcon(pngTen);
        }
        if(score == 11){
          empty.setIcon(pngEleven);
        }
        if(score == 12){
          empty.setIcon(pngTwelve);
        }
      }
      if( b.getText().toLowerCase().equals("two") )
      {
        if(closedThisTurn[1]){
          openTwo();
        }else{
          closeTwo();
        }
        if(score == 0){
          empty.setIcon(pngZero);
        }
        if(score == 1){
          empty.setIcon(pngOne);
        }
        if(score == 2){
          empty.setIcon(pngTwo);
        }
        if(score == 3){
          empty.setIcon(pngThree);
        }
        if(score == 4){
          empty.setIcon(pngFour);
        }
        if(score == 5){
          empty.setIcon(pngFive);
        }
        if(score == 6){
          empty.setIcon(pngSix);
        }
        if(score == 7){
          empty.setIcon(pngSeven);
        }
        if(score == 8){
          empty.setIcon(pngEight);
        }
        if(score == 9){
          empty.setIcon(pngNine);
        }
        if(score == 10){
          empty.setIcon(pngTen);
        }
        if(score == 11){
          empty.setIcon(pngEleven);
        }
        if(score == 12){
          empty.setIcon(pngTwelve);
        }
      }
      if( b.getText().toLowerCase().equals("three") )
      {
        if(closedThisTurn[2]){
          openThree();
        }else{
          closeThree();
        }
        if(score == 0){
          empty.setIcon(pngZero);
        }
        if(score == 1){
          empty.setIcon(pngOne);
        }
        if(score == 2){
          empty.setIcon(pngTwo);
        }
        if(score == 3){
          empty.setIcon(pngThree);
        }
        if(score == 4){
          empty.setIcon(pngFour);
        }
        if(score == 5){
          empty.setIcon(pngFive);
        }
        if(score == 6){
          empty.setIcon(pngSix);
        }
        if(score == 7){
          empty.setIcon(pngSeven);
        }
        if(score == 8){
          empty.setIcon(pngEight);
        }
        if(score == 9){
          empty.setIcon(pngNine);
        }
        if(score == 10){
          empty.setIcon(pngTen);
        }
        if(score == 11){
          empty.setIcon(pngEleven);
        }
        if(score == 12){
          empty.setIcon(pngTwelve);
        }
      }
      if( b.getText().toLowerCase().equals("four") )
      {
        if(closedThisTurn[3]){
          openFour();
        }else{
          closeFour();
        }
        if(score == 0){
          empty.setIcon(pngZero);
        }
        if(score == 1){
          empty.setIcon(pngOne);
        }
        if(score == 2){
          empty.setIcon(pngTwo);
        }
        if(score == 3){
          empty.setIcon(pngThree);
        }
        if(score == 4){
          empty.setIcon(pngFour);
        }
        if(score == 5){
          empty.setIcon(pngFive);
        }
        if(score == 6){
          empty.setIcon(pngSix);
        }
        if(score == 7){
          empty.setIcon(pngSeven);
        }
        if(score == 8){
          empty.setIcon(pngEight);
        }
        if(score == 9){
          empty.setIcon(pngNine);
        }
        if(score == 10){
          empty.setIcon(pngTen);
        }
        if(score == 11){
          empty.setIcon(pngEleven);
        }
        if(score == 12){
          empty.setIcon(pngTwelve);
        }
      }
      if( b.getText().toLowerCase().equals("five") )
      {
        if(closedThisTurn[4]){
          openFive();
        }else{
          closeFive();
        }
        if(score == 0){
          empty.setIcon(pngZero);
        }
        if(score == 1){
          empty.setIcon(pngOne);
        }
        if(score == 2){
          empty.setIcon(pngTwo);
        }
        if(score == 3){
          empty.setIcon(pngThree);
        }
        if(score == 4){
          empty.setIcon(pngFour);
        }
        if(score == 5){
          empty.setIcon(pngFive);
        }
        if(score == 6){
          empty.setIcon(pngSix);
        }
        if(score == 7){
          empty.setIcon(pngSeven);
        }
        if(score == 8){
          empty.setIcon(pngEight);
        }
        if(score == 9){
          empty.setIcon(pngNine);
        }
        if(score == 10){
          empty.setIcon(pngTen);
        }
        if(score == 11){
          empty.setIcon(pngEleven);
        }
        if(score == 12){
          empty.setIcon(pngTwelve);
        }
      }
      if( b.getText().toLowerCase().equals("six") )
      {
        if(closedThisTurn[5]){
          openSix();
        }else{
          closeSix();
        }
        if(score == 0){
          empty.setIcon(pngZero);
        }
        if(score == 1){
          empty.setIcon(pngOne);
        }
        if(score == 2){
          empty.setIcon(pngTwo);
        }
        if(score == 3){
          empty.setIcon(pngThree);
        }
        if(score == 4){
          empty.setIcon(pngFour);
        }
        if(score == 5){
          empty.setIcon(pngFive);
        }
        if(score == 6){
          empty.setIcon(pngSix);
        }
        if(score == 7){
          empty.setIcon(pngSeven);
        }
        if(score == 8){
          empty.setIcon(pngEight);
        }
        if(score == 9){
          empty.setIcon(pngNine);
        }
        if(score == 10){
          empty.setIcon(pngTen);
        }
        if(score == 11){
          empty.setIcon(pngEleven);
        }
        if(score == 12){
          empty.setIcon(pngTwelve);
        }
      }
      if( b.getText().toLowerCase().equals("seven") )
      {
        if(closedThisTurn[6]){
          openSeven();
        }else{
          closeSeven();
        }
        if(score == 0){
          empty.setIcon(pngZero);
        }
        if(score == 1){
          empty.setIcon(pngOne);
        }
        if(score == 2){
          empty.setIcon(pngTwo);
        }
        if(score == 3){
          empty.setIcon(pngThree);
        }
        if(score == 4){
          empty.setIcon(pngFour);
        }
        if(score == 5){
          empty.setIcon(pngFive);
        }
        if(score == 6){
          empty.setIcon(pngSix);
        }
        if(score == 7){
          empty.setIcon(pngSeven);
        }
        if(score == 8){
          empty.setIcon(pngEight);
        }
        if(score == 9){
          empty.setIcon(pngNine);
        }
        if(score == 10){
          empty.setIcon(pngTen);
        }
        if(score == 11){
          empty.setIcon(pngEleven);
        }
        if(score == 12){
          empty.setIcon(pngTwelve);
        }
      }
      if( b.getText().toLowerCase().equals("eight") )
      {
        if(closedThisTurn[7]){
          openEight();
        }else{
          closeEight();
        }
        if(score == 0){
          empty.setIcon(pngZero);
        }
        if(score == 1){
          empty.setIcon(pngOne);
        }
        if(score == 2){
          empty.setIcon(pngTwo);
        }
        if(score == 3){
          empty.setIcon(pngThree);
        }
        if(score == 4){
          empty.setIcon(pngFour);
        }
        if(score == 5){
          empty.setIcon(pngFive);
        }
        if(score == 6){
          empty.setIcon(pngSix);
        }
        if(score == 7){
          empty.setIcon(pngSeven);
        }
        if(score == 8){
          empty.setIcon(pngEight);
        }
        if(score == 9){
          empty.setIcon(pngNine);
        }
        if(score == 10){
          empty.setIcon(pngTen);
        }
        if(score == 11){
          empty.setIcon(pngEleven);
        }
        if(score == 12){
          empty.setIcon(pngTwelve);
        }
      }
      if( b.getText().toLowerCase().equals("nine") )
      {
        if(closedThisTurn[8]){
          openNine();
        }else{
          closeNine();
        }
        if(score == 0){
          empty.setIcon(pngZero);
        }
        if(score == 1){
          empty.setIcon(pngOne);
        }
        if(score == 2){
          empty.setIcon(pngTwo);
        }
        if(score == 3){
          empty.setIcon(pngThree);
        }
        if(score == 4){
          empty.setIcon(pngFour);
        }
        if(score == 5){
          empty.setIcon(pngFive);
        }
        if(score == 6){
          empty.setIcon(pngSix);
        }
        if(score == 7){
          empty.setIcon(pngSeven);
        }
        if(score == 8){
          empty.setIcon(pngEight);
        }
        if(score == 9){
          empty.setIcon(pngNine);
        }
        if(score == 10){
          empty.setIcon(pngTen);
        }
        if(score == 11){
          empty.setIcon(pngEleven);
        }
        if(score == 12){
          empty.setIcon(pngTwelve);
        }
      }
      if( b.getText().toLowerCase().equals("ten") )
      {
        if(closedThisTurn[9]){
          openTen();
        }else{
          closeTen();
        }
        if(score == 0){
          empty.setIcon(pngZero);
        }
        if(score == 1){
          empty.setIcon(pngOne);
        }
        if(score == 2){
          empty.setIcon(pngTwo);
        }
        if(score == 3){
          empty.setIcon(pngThree);
        }
        if(score == 4){
          empty.setIcon(pngFour);
        }
        if(score == 5){
          empty.setIcon(pngFive);
        }
        if(score == 6){
          empty.setIcon(pngSix);
        }
        if(score == 7){
          empty.setIcon(pngSeven);
        }
        if(score == 8){
          empty.setIcon(pngEight);
        }
        if(score == 9){
          empty.setIcon(pngNine);
        }
        if(score == 10){
          empty.setIcon(pngTen);
        }
        if(score == 11){
          empty.setIcon(pngEleven);
        }
        if(score == 12){
          empty.setIcon(pngTwelve);
        }
      }
      if( b.getText().toLowerCase().equals("eleven") )
      {
        if(closedThisTurn[10]){
          openEleven();
        }else{
          closeEleven();
        }
        if(score == 0){
          empty.setIcon(pngZero);
        }
        if(score == 1){
          empty.setIcon(pngOne);
        }
        if(score == 2){
          empty.setIcon(pngTwo);
        }
        if(score == 3){
          empty.setIcon(pngThree);
        }
        if(score == 4){
          empty.setIcon(pngFour);
        }
        if(score == 5){
          empty.setIcon(pngFive);
        }
        if(score == 6){
          empty.setIcon(pngSix);
        }
        if(score == 7){
          empty.setIcon(pngSeven);
        }
        if(score == 8){
          empty.setIcon(pngEight);
        }
        if(score == 9){
          empty.setIcon(pngNine);
        }
        if(score == 10){
          empty.setIcon(pngTen);
        }
        if(score == 11){
          empty.setIcon(pngEleven);
        }
        if(score == 12){
          empty.setIcon(pngTwelve);
        }
      }
      if( b.getText().toLowerCase().equals("twelve") )
      {
        if(closedThisTurn[11]){
          openTwelve();
        }else{
          closeTwelve();
        }
        if(score == 0){
          empty.setIcon(pngZero);
        }
        if(score == 1){
          empty.setIcon(pngOne);
        }
        if(score == 2){
          empty.setIcon(pngTwo);
        }
        if(score == 3){
          empty.setIcon(pngThree);
        }
        if(score == 4){
          empty.setIcon(pngFour);
        }
        if(score == 5){
          empty.setIcon(pngFive);
        }
        if(score == 6){
          empty.setIcon(pngSix);
        }
        if(score == 7){
          empty.setIcon(pngSeven);
        }
        if(score == 8){
          empty.setIcon(pngEight);
        }
        if(score == 9){
          empty.setIcon(pngNine);
        }
        if(score == 10){
          empty.setIcon(pngTen);
        }
        if(score == 11){
          empty.setIcon(pngEleven);
        }
        if(score == 12){
          empty.setIcon(pngTwelve);
        }
      }
			if( b.getText().toLowerCase().equals("play") )
			{
        if(score != 0){
          gameOver();
        }else{
          if(closedThisTurn[0]){
            labelOne.setText("Closed");
          }
          if(closedThisTurn[1]){
            labelTwo.setText("Closed");
          }
          if(closedThisTurn[2]){
            labelThree.setText("Closed");
          }
          if(closedThisTurn[3]){
            labelFour.setText("Closed");
          }
          if(closedThisTurn[4]){
            labelFive.setText("Closed");
          }
          if(closedThisTurn[5]){
            labelSix.setText("Closed");
          }
          if(closedThisTurn[6]){
            labelSeven.setText("Closed");
          }
          if(closedThisTurn[7]){
            labelEight.setText("Closed");
          }
          if(closedThisTurn[8]){
            labelNine.setText("Closed");
          }
          if(closedThisTurn[9]){
            labelTen.setText("Closed");
          }
          if(closedThisTurn[10]){
            labelEleven.setText("Closed");
          }
          if(closedThisTurn[11]){
            labelTwelve.setText("Closed");
          }
          one.setEnabled(!(closedThisTurn[0]));
          two.setEnabled(!(closedThisTurn[1]));
          three.setEnabled(!(closedThisTurn[2]));
          four.setEnabled(!(closedThisTurn[3]));
          five.setEnabled(!(closedThisTurn[4]));
          six.setEnabled(!(closedThisTurn[5]));
          seven.setEnabled(!(closedThisTurn[6]));
          eight.setEnabled(!(closedThisTurn[7]));
          nine.setEnabled(!(closedThisTurn[8]));
          ten.setEnabled(!(closedThisTurn[9]));
          eleven.setEnabled(!(closedThisTurn[10]));
          twelve.setEnabled(!(closedThisTurn[11]));
          int dice1 = diceRoll();
          int dice2 = diceRoll();
          if(dice1 == 1){
            labelDice1.setIcon(new ImageIcon("../images/dice_1.png"));
          }
          if(dice1 == 2){
            labelDice1.setIcon(new ImageIcon("../images/dice_2.png"));
          }
          if(dice1 == 3){
            labelDice1.setIcon(new ImageIcon("../images/dice_3.png"));
          }
          if(dice1 == 4){
            labelDice1.setIcon(new ImageIcon("../images/dice_4.png"));
          }
          if(dice1 == 5){
            labelDice1.setIcon(new ImageIcon("../images/dice_5.png"));
          }
          if(dice1 == 6){
            labelDice1.setIcon(new ImageIcon("../images/dice_6.png"));
          }
          if(dice2 == 1){
            labelDice2.setIcon(new ImageIcon("../images/dice_1.png"));
          }
          if(dice2 == 2){
            labelDice2.setIcon(new ImageIcon("../images/dice_2.png"));
          }
          if(dice2 == 3){
            labelDice2.setIcon(new ImageIcon("../images/dice_3.png"));
          }
          if(dice2 == 4){
            labelDice2.setIcon(new ImageIcon("../images/dice_4.png"));
          }
          if(dice2 == 5){
            labelDice2.setIcon(new ImageIcon("../images/dice_5.png"));
          }
          if(dice2 == 6){
            labelDice2.setIcon(new ImageIcon("../images/dice_6.png"));
          }
          score = dice1 + dice2;
          if(score == 1){
            empty.setIcon(pngOne);
          }
          if(score == 2){
            empty.setIcon(pngTwo);
          }
          if(score == 3){
            empty.setIcon(pngThree);
          }
          if(score == 4){
            empty.setIcon(pngFour);
          }
          if(score == 5){
            empty.setIcon(pngFive);
          }
          if(score == 6){
            empty.setIcon(pngSix);
          }
          if(score == 7){
            empty.setIcon(pngSeven);
          }
          if(score == 8){
            empty.setIcon(pngEight);
          }
          if(score == 9){
            empty.setIcon(pngNine);
          }
          if(score == 10){
            empty.setIcon(pngTen);
          }
          if(score == 11){
            empty.setIcon(pngEleven);
          }
          if(score == 12){
            empty.setIcon(pngTwelve);
          }
        }
			}
		}
	}
	
	static class MenuItemActionListener implements java.awt.event.ActionListener
	{
		private javax.swing.JMenuItem m;
		
		MenuItemActionListener(javax.swing.JMenuItem m)
		{
			this.m = m;
		}
		
		public void actionPerformed(java.awt.event.ActionEvent e)
		{
			if( m.getText().toLowerCase().equals("exit") )
			{
				System.exit(0);
			}
			if( m.getText().toLowerCase().equals("reset") )
			{
				resetGame();
			}
		}
	}
}