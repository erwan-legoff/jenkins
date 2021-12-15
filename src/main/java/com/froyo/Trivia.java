package com.froyo;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Trivia {
		 Logger logger = Logger.getLogger(getClass().getName());

    ArrayList<String> players = new ArrayList<>();
    int[] places = new int[6];
    int[] purses  = new int[6];
		boolean[] inPenaltyBox = new boolean[6];
		static final  String POP =	"Pop";
		static final  String SCIENCE = "Science";
		static final  String SPORTS = "Sports";
		static final  String ROCK = "Rock";

    LinkedList<String> popQuestions = new LinkedList<>();
    LinkedList<String> scienceQuestions = new LinkedList<>();
    LinkedList<String> sportsQuestions = new LinkedList<>();
    LinkedList<String> rockQuestions = new LinkedList<>();
    
    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;
    
    public  Trivia(){
    	for (int i = 0; i < 50; i++) {
			popQuestions.addLast(String.format("Pop Question %02d", i));
			scienceQuestions.addLast(String.format("Science Question %02d", i));
			sportsQuestions.addLast(String.format("Sports Question %d", i));
			rockQuestions.addLast(createRockQuestion(i));
    	}
    }
    public static void main(String[] args) {
        System.out.println("Bonjour");
    }

	public String createRockQuestion(int index){
		return String.format( "Rock Question %d", index);
	}
	
	public boolean isPlayable() {
		return (howManyPlayers() >= 2);
	}

	public boolean add(String playerName) {
		
		
	    players.add(playerName);
	    places[howManyPlayers()] = 0;
	    purses[howManyPlayers()] = 0;
	    inPenaltyBox[howManyPlayers()] = false;
			if (logger.getLevel() == Level.INFO) {
				logger.info(String.format("%s was added", playerName));
				logger.info(String.format("They are player number %d", players.size()));
			}

		return true;
	}
	
	public int howManyPlayers() {
		return players.size();
	}

	public void roll(int roll) {
		if(logger.getLevel() == Level.INFO) {
			logger.info(String.format("%s is the current player", players.get(currentPlayer)));
			logger.info(String.format("They have rolled a %d", roll));
		}

		if (inPenaltyBox[currentPlayer]) {
			if (roll % 2 != 0) {
				goodRoll(roll);
			} else {
				if (logger.getLevel() == Level.INFO) 
					logger.info(String.format("%s is not getting out of the penalty box", players.get(currentPlayer)));
				
					
				
				isGettingOutOfPenaltyBox = false;
			}

		} else {

			places[currentPlayer] = places[currentPlayer] + roll;
			if (places[currentPlayer] > 11)
				places[currentPlayer] = places[currentPlayer] - 12;
			if (logger.getLevel() == Level.INFO) {
				logger.info(String.format("%s is the current player", players.get(currentPlayer)));
				logger.info(String.format("The category is %s", currentCategory()));
			}
			askQuestion();
		}

	}

	private void goodRoll(int roll) {
		isGettingOutOfPenaltyBox = true;
		if(logger.getLevel() == Level.INFO)
			logger.info(String.format("%s is getting out of the penalty box", players.get(currentPlayer)));
		places[currentPlayer] = places[currentPlayer] + roll;
		if (places[currentPlayer] > 11)
			places[currentPlayer] = places[currentPlayer] - 12;
		if(logger.getLevel() == Level.INFO)
			logger.info(String.format("%s's new location is %d", players.get(currentPlayer), places[currentPlayer]));

		if(logger.getLevel() == Level.INFO)
			logger.info(String.format("The category is %s", currentCategory()));

		askQuestion();
	}

	private void askQuestion() {
		if (logger.getLevel() == Level.INFO) {

			if (currentCategory().equals(POP))
				logger.info(String.format("%s", rockQuestions.removeFirst()));
			if (currentCategory().equals(SCIENCE))
				logger.info(String.format("%s", rockQuestions.removeFirst()));
			if (currentCategory().equals(SPORTS))
				logger.info(String.format("%s", rockQuestions.removeFirst()));
			if (currentCategory().equals(ROCK))
				logger.info(String.format("%s", rockQuestions.removeFirst()));
		}
	}
	
	
	private String currentCategory() {
		if (places[currentPlayer] == 0) return POP;
		if (places[currentPlayer] == 4) return POP;
		if (places[currentPlayer] == 8) return POP;
		if (places[currentPlayer] == 1) return SCIENCE;
		if (places[currentPlayer] == 5) return SCIENCE;
		if (places[currentPlayer] == 9) return SCIENCE;
		if (places[currentPlayer] == 2) return SPORTS;
		if (places[currentPlayer] == 6) return SPORTS;
		if (places[currentPlayer] == 10) return SPORTS;
		return "Rock";
	}

	public boolean wasCorrectlyAnswered() {
		if (inPenaltyBox[currentPlayer]) {
			if (isGettingOutOfPenaltyBox) {
				boolean winner = currentPlayerWin();
				setPlayerToZero();

				return winner;
			} else {
				currentPlayer++;
				setPlayerToZero();
				return true;
			}

		} else {

			currentPlayerWin();

			boolean winner = didPlayerWin();
			currentPlayer++;
			setPlayerToZero();

			return winner;
		}
	}

	private void setPlayerToZero() {
		if (currentPlayer == players.size())
			currentPlayer = 0;
	}

	private boolean currentPlayerWin() {
		logger.info("Answer was correct!!!!");
		purses[currentPlayer]++;
		if (logger.getLevel() == Level.INFO) 
			logger.info(String.format("%s now has %d Gold Coins.", players.get(currentPlayer), purses[currentPlayer]));
		
		

		boolean winner = didPlayerWin();
		currentPlayer++;
		return winner;
	}
	
	
	public boolean wrongAnswer(){
		logger.info("Question was incorrectly answered");
		//use String.format instead
		if (logger.getLevel() == Level.INFO) 
			logger.info(String.format("%s was sent to the penalty box", players.get(currentPlayer)));

		inPenaltyBox[currentPlayer] = true;
		
		currentPlayer++;
		setPlayerToZero();
		return true;
	}


	private boolean didPlayerWin() {
		return (purses[currentPlayer] != 6);
	}
}
