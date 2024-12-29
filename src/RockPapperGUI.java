import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class RockPapperGUI extends JFrame implements ActionListener{
	//player buttons
	JButton rockButton, paperButton, scissorButton;
	
	//will display the choice of the computer
	JLabel computerChoice;
	
	JLabel computerScoreLabel, playerScoreLabel;
	
	//backend obj;
	RockPaperScissor obj;

	public RockPapperGUI() {
		super("Rock Papper Scissor");
		
		setSize(450, 574);
		
		setLayout(null);
		
		//terminate the jvm when closing the gui
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//set layout to null to disable layout management 
		setLocationRelativeTo(null);
		
		//initialize the backend obj;
		obj = new RockPaperScissor();
		
		//add gui components
		addGuiComponents();
	}
	
	private void addGuiComponents() {
		//create computer score label
	    computerScoreLabel = new JLabel("Computer: 0");
		
		//set x,y coordinates and set width/height values
		computerScoreLabel.setBounds(0, 43, 450, 30);
		
		//set the font
		computerScoreLabel.setFont(new Font("Dialog", Font.BOLD, 26));
		
		//place the text in the center
		computerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		add(computerScoreLabel);
		
		//create computer choice
		computerChoice = new JLabel("?");
		computerChoice.setBounds(175,118, 98,81);
		computerChoice.setFont(new Font("Dialog", Font.PLAIN,18));
		computerChoice.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		//create a black border around 
		computerChoice.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(computerChoice);
		
		//create player score label
		playerScoreLabel = new JLabel("Player: 0");
		playerScoreLabel.setBounds(0,317, 450,30);
		playerScoreLabel.setFont(new Font("Dialog", Font.BOLD, 26));
		playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(playerScoreLabel);
		
		
		//player buttons
		
		//rock buttons
		rockButton = new JButton("Rock");
		rockButton.setBounds(40, 387, 105, 81);
		rockButton.setFont(new Font("Dialog", Font.PLAIN, 18));
		rockButton.addActionListener(this);
		add(rockButton);
		
		//paper button
		paperButton = new JButton("Paper");
		paperButton.setBounds(165, 387, 105, 81);
		paperButton.setFont(new Font("Dialog", Font.PLAIN, 18));
		paperButton.addActionListener(this);
		add(paperButton);
		
		//scissor button
		scissorButton = new JButton("Scissor");
		scissorButton.setBounds(290, 387, 105, 81);
		scissorButton.setFont(new Font("Dialog", Font.PLAIN, 18));
		scissorButton.addActionListener(this);
		add(scissorButton);
		
		showDialog("Test Message");
	}
	
	//displayes a message dialog which still show the winner and a try again button
	private void showDialog(String message)
	{
		JDialog resultDialog = new JDialog(this, "Result", true);
		resultDialog.setSize(227, 124);
		resultDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		resultDialog.setResizable(false);
		
		//message label
		JLabel resultLabel = new JLabel(message);
		resultLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		resultLabel.setHorizontalAlignment(SwingConstants.CENTER);;
		resultDialog.add(resultLabel,BorderLayout.CENTER);
		
		//try again button
		JButton tryAgainButton = new JButton("Try Again");
		tryAgainButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// reset computer choice
				computerChoice.setText("?");
				
				//close the dialog box
				resultDialog.dispose();
				
			}
		});
		resultDialog.add(tryAgainButton, BorderLayout.SOUTH);
		resultDialog.setLocationRelativeTo(this);
		
		resultDialog.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// get player choice
		String playerChoiceString = e.getActionCommand().toString();
		
		//play rock paper scissor
		String result = obj.playRockPaperScissor(playerChoiceString);
		
		//load computer choice
		
		computerChoice.setText(obj.getComputerChoice());
		
		//update Score
		computerScoreLabel.setText("Computer:" +obj.getComputerChoice());
		playerScoreLabel.setText("Player:"+obj.getPlayerScore());
		
		//display result;
		showDialog(result);
		
		
		
	}
}
