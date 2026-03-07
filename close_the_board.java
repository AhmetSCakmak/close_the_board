import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.math.*;

class close_the_board
{
	private static int width = 700;
	private static int height = 400;
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
	private static JButton twelwe;
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
	private static JLabel labelTwelwe;
	private static JLabel empty;
  private static JLabel gameScore;
	private static JDialog popUpDialog;
	private static int score;
	private static JFrame f;
  private static boolean[] closedThisTurn;
	
	public static void main(String[] args)
	{
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
		leftButtonPanel.setPreferredSize(new Dimension(330, 300));
		leftButtonPanel.setMinimumSize(new Dimension(330, 300));
		
		JPanel rightButtonPanel = new JPanel();
		rightButtonPanel.setBorder(new javax.swing.border.LineBorder(new Color(0, 0, 0, 255), 2));
		GridBagLayout gridBagLayoutRight = new GridBagLayout();
		GridBagConstraints buttonPanelConstraintsRight = new GridBagConstraints();
		rightButtonPanel.setLayout(gridBagLayoutRight);
		rightButtonPanel.setPreferredSize(new Dimension(330, 300));
		rightButtonPanel.setMinimumSize(new Dimension(330, 300));
		
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
		dicePanel.setPreferredSize(new Dimension(680, 100));
		dicePanel.setMinimumSize(new Dimension(680, 100));
		panelConstraintsDice.fill = GridBagConstraints.NONE;
		panelConstraintsDice.anchor = GridBagConstraints.LINE_START;
		panelConstraintsDice.weightx = 1;
		panelConstraintsDice.weighty = 1;
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(new javax.swing.border.LineBorder(new Color(0, 0, 0, 255), 2));
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(menuBar, BorderLayout.NORTH);
		mainPanel.add(mainButtonPanel, BorderLayout.CENTER);
		mainPanel.add(dicePanel, BorderLayout.SOUTH);
		
		one = new JButton("1");
		two = new JButton("2");
		three = new JButton("3");
		four = new JButton("4");
		five = new JButton("5");
		six = new JButton("6");
		seven = new JButton("7");
    eight = new JButton("8");
    nine = new JButton("9");
    ten = new JButton("10");
    eleven = new JButton("11");
    twelwe = new JButton("12");
		
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
		ButtonActionListener twelweAL = new ButtonActionListener(twelwe);
		
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
		twelwe.addActionListener(twelweAL);

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
		twelwe.setEnabled(false);	
		
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
		labelTwelwe = new JLabel("Open");
		empty = new JLabel(Integer.toString(score));
		
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
		
		buttonPanelConstraintsLeft.gridx = 0;
		buttonPanelConstraintsLeft.gridy = 6;
		buttonPanelConstraintsLeft.gridwidth = 1;
		gridBagLayoutLeft.setConstraints(empty, buttonPanelConstraintsLeft);
		
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
		leftButtonPanel.add(empty);
		
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
		gridBagLayoutRight.setConstraints(twelwe, buttonPanelConstraintsRight);
		
		buttonPanelConstraintsRight.gridx = 1;
		buttonPanelConstraintsRight.gridy = 5;
		buttonPanelConstraintsRight.gridwidth = GridBagConstraints.REMAINDER;
		gridBagLayoutRight.setConstraints(labelTwelwe, buttonPanelConstraintsRight);
		
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
		rightButtonPanel.add(twelwe);
		rightButtonPanel.add(labelTwelwe);
		
		roll = new JButton("Play");
		ButtonActionListener rollAL = new ButtonActionListener(roll);
		roll.addActionListener(rollAL);
		roll.setEnabled(true);
		
		labelDice1 = new JLabel("0");
		labelDice2 = new JLabel("0");
		
		panelConstraintsDice.gridx = 0;
		panelConstraintsDice.gridy = 0;
		panelConstraintsDice.gridwidth = 1;
		gridBagLayoutDice.setConstraints(labelDice1, panelConstraintsDice);
		
		panelConstraintsDice.gridx = 1;
		panelConstraintsDice.gridy = 0;
		panelConstraintsDice.gridwidth = 1;
		gridBagLayoutDice.setConstraints(labelDice2, panelConstraintsDice);
		
		panelConstraintsDice.gridx = 0;
		panelConstraintsDice.gridy = 2;
		panelConstraintsDice.gridwidth = GridBagConstraints.REMAINDER;
		roll.setPreferredSize(new Dimension(600,25));
		gridBagLayoutDice.setConstraints(roll, panelConstraintsDice);
		
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
      labelOne.setText("Closed");
      closedThisTurn[0] = true;
    }
  }

  private static void closeTwo(){
    if(score >= 2){
      score -= 2;
      labelTwo.setText("Closed");
      closedThisTurn[1] = true;
    }
  }

  private static void closeThree(){
    if(score >= 3){
      score -= 3;
      labelThree.setText("Closed");
      closedThisTurn[2] = true;
    }
  }

  private static void closeFour(){
    if(score >= 4){
      score -= 4 ;
      labelFour.setText("Closed");
      closedThisTurn[3] = true;
    }
  }

  private static void closeFive(){
    if(score >= 5){
      score -= 5 ;
      labelFive.setText("Closed");
      closedThisTurn[4] = true;
    }
  }

  private static void closeSix(){
    if(score >= 6){
      score -= 6;
      labelSix.setText("Closed");
      closedThisTurn[5] = true;
    }
  }

  private static void closeSeven(){
    if(score >= 7){
      score -= 7;
      labelSeven.setText("Closed");
      closedThisTurn[6] = true;
    }
  }

  private static void closeEight(){
    if(score >= 8){
      score -= 8;
      labelEight.setText("Closed");
      closedThisTurn[7] = true;
    }
  }

  private static void closeNine(){
    if(score >= 9){
      score -= 9;
      labelNine.setText("Closed");
      closedThisTurn[8] = true;
    }
  }

  private static void closeTen(){
    if(score >= 10){
      score -= 10;
      labelTen.setText("Closed");
      closedThisTurn[9] = true;
    }
  }

  private static void closeEleven(){
    if(score >= 11){
      score -= 11;
      labelEleven.setText("Closed");
      closedThisTurn[10] = true;
    }
  }

  private static void closeTwelwe(){
    if(score >= 12){
      score -= 12;
      labelTwelwe.setText("Selected");
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

  private static void openTwelwe(){
    labelTwelwe.setText("Open");
    score += 12;
    closedThisTurn[11] = false;
  }
	
	private static void gameOver()
	{
		int scoreLeft = 0;
		if(labelOne.getText() == "Open"){
      scoreLeft += 1;
    }
    if(labelTwo.getText() == "Open"){
      scoreLeft += 2;
    }
    if(labelThree.getText() == "Open"){
      scoreLeft += 3;
    }
    if(labelFour.getText() == "Open"){
      scoreLeft += 4;
    }
    if(labelFive.getText() == "Open"){
      scoreLeft += 5;
    }
    if(labelSix.getText() == "Open"){
      scoreLeft += 6;
    }
    if(labelSeven.getText() == "Open"){
      scoreLeft += 7;
    }
    if(labelEight.getText() == "Open"){
      scoreLeft += 8;
    }
    if(labelNine.getText() == "Open"){
      scoreLeft += 9;
    }
    if(labelTen.getText() == "Open"){
      scoreLeft += 10;
    }
    if(labelEleven.getText() == "Open"){
      scoreLeft += 11;
    }
    if(labelTwelwe.getText() == "Open"){
      scoreLeft += 12;
    }
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
		labelTwelwe.setText("Open");
		labelDice1.setText("Open");
		labelDice2.setText("Open");
		
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
		twelwe.setEnabled(false);
		roll.setEnabled(true);
		popUpDialog.setVisible(false);
    score = 0;
    empty.setText(Integer.toString(score));    
		
		for (int i = 0; i < 13; i++)
		{
			closedThisTurn[i] = false;
		}
	}
	
	private static void selectionSort(int[] array)
	{
		for ( int i = 0; i < array.length - 1; i++ )
		{
			int minIndex = i;
			for ( int j = i + 1; j < array.length; j++ )
			{
				if ( array[j] < array[minIndex] )
				{
					minIndex = j;
				}
			}
			if ( minIndex != i)
			{
				int temp = array[i];
				array[i] = array[minIndex];
				array[minIndex] = temp;
			}
		}
	}
	
	private static int searchArray(int[] array, int num)
	{
		int random_int = 0;
		for( int i = 0; i < array.length; i++)
		{
			if(num == array[i])
			{
				random_int++;
			}
		}
		return random_int;
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
      if( b.getText().toLowerCase().equals("1") )
  	  {
        if(closedThisTurn[0]){
          openOne();
        }else{
          closeOne();
        }
        empty.setText(Integer.toString(score));
      }
      if( b.getText().toLowerCase().equals("2") )
      {
        if(closedThisTurn[1]){
          openTwo();
        }else{
          closeTwo();
        }
        empty.setText(Integer.toString(score));
      }
      if( b.getText().toLowerCase().equals("3") )
      {
        if(closedThisTurn[2]){
          openThree();
        }else{
          closeThree();
        }
        empty.setText(Integer.toString(score));
      }
      if( b.getText().toLowerCase().equals("4") )
      {
        if(closedThisTurn[3]){
          openFour();
        }else{
          closeFour();
        }
        empty.setText(Integer.toString(score));
      }
      if( b.getText().toLowerCase().equals("5") )
      {
        if(closedThisTurn[4]){
          openFive();
        }else{
          closeFive();
        }
        empty.setText(Integer.toString(score));
      }
      if( b.getText().toLowerCase().equals("6") )
      {
        if(closedThisTurn[5]){
          openSix();
        }else{
          closeSix();
        }
        empty.setText(Integer.toString(score));
      }
      if( b.getText().toLowerCase().equals("7") )
      {
        if(closedThisTurn[6]){
          openSeven();
        }else{
          closeSeven();
        }
        empty.setText(Integer.toString(score));
      }
      if( b.getText().toLowerCase().equals("8") )
      {
        if(closedThisTurn[7]){
          openEight();
        }else{
          closeEight();
        }
        empty.setText(Integer.toString(score));
      }
      if( b.getText().toLowerCase().equals("9") )
      {
        if(closedThisTurn[8]){
          openNine();
        }else{
          closeNine();
        }
        empty.setText(Integer.toString(score));
      }
      if( b.getText().toLowerCase().equals("10") )
      {
        if(closedThisTurn[9]){
          openTen();
        }else{
          closeTen();
        }
        empty.setText(Integer.toString(score));
      }
      if( b.getText().toLowerCase().equals("11") )
      {
        if(closedThisTurn[10]){
          openEleven();
        }else{
          closeEleven();
        }
        empty.setText(Integer.toString(score));
      }
      if( b.getText().toLowerCase().equals("12") )
      {
        if(closedThisTurn[11]){
          openTwelwe();
        }else{
          closeTwelwe();
        }
        empty.setText(Integer.toString(score));
      }
			if( b.getText().toLowerCase().equals("play") )
			{
        if(score != 0){
          gameOver();
        }else{
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
          twelwe.setEnabled(!(closedThisTurn[11]));
          int dice1 = diceRoll();
          int dice2 = diceRoll();
          labelDice1.setText(Integer.toString(dice1));
          labelDice2.setText(Integer.toString(dice2));
          score = dice1 + dice2;
          empty.setText(Integer.toString(score));
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