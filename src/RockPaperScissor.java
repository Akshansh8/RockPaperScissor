//backend 

import java.util.Random;

public class RockPaperScissor {
	//all of the choices that a computer can make
	private static final String[] computerChoice = {"Rock", "Paper", "Scissor"};
    private String computerChoices;
	//use to generate a random number to randomly choose an option for the computer
	private Random random;
	
	//store the scores
	private int computerScore , playerScore;
	
	public String getComputerChoice() {
		return computerChoices;
	}
	
	public int getComputerScore() {
		return computerScore;
	}
	
	public int getPlayerScore() {
		return playerScore;
	}
	
	public RockPaperScissor() {
		random = new Random();
	}
	
	//call this method to begin playing rock paper scissor
	//playerChoice - is the choice made by the player
	//this method will return the result of the game
	public String playRockPaperScissor(String playerChoice)
	{
		//generate computer choice
		computerChoices  = computerChoice[random.nextInt(computerChoice.length)];
		
		//will contain the returning message
		String result;
		
		if(computerChoices.equals("Rock")) {
			if(playerChoice.equals("Paper")) {
				result = "Player wins";
				playerScore++;
			}
			else if (playerChoice.equals("Scissor")) {
				result = "Computer Wins";
				computerScore++;	
			}
			
			else {
				result = "Draw";
			}
		}
		
		else if(computerChoices.equals("Paper")) {
			if(playerChoice.equals("Scissor")) {
				result = "Player wins";
				playerScore++;
			}
			else if (playerChoice.equals("Rock")) {
				result = "Computer Wins";
				computerScore++;	
			}
			
			else {
				result = "Draw";
			}
		}
		
		else
		{
			if(playerChoice.equals("Rock")) {
				result = "Player wins";
				playerScore++;
			}
			else if (playerChoice.equals("Paper")) {
				result = "Computer Wins";
				computerScore++;	
			}
			
			else {
				result = "Draw";
			}
		}
		return result;
		
	}

}
