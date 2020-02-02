public class TicTacToe
{
	Integer[][] winningConditions = {{1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}};
	Player player1 = new Player('X',0);
	Player player2 = new Player('O',1);
	Player players[] = {player1,player2};
	Board board;
	int currentPlayerNo;

	TicTacToe()
	{
		board = new Board();
	}

	void game()
	{
		int winnerNo = startGame();
		String result = "You won";
		if(winnerNo == -1)
			result = "No one won";
		System.out.println(result);
	}

	int startGame()
	{
		boolean shouldContinueGame=true;
		boolean playerWin;
		while(shouldContinueGame)
		{
			playerMove();
			playerWin = board.winCheck(players[currentPlayerNo].positions, winningConditions);
			shouldContinueGame = !(playerWin || board.isGridFilled());
			switchPlayer();
		}
		return board.isGridFilled() ? -1 : players[currentPlayerNo].playerNo;
	}

	void playerMove()
	{
		boolean shouldContinueInput = true;
		while(shouldContinueInput)
		{
			int position = players[currentPlayerNo].input();
			if(board.validatePosition(position))
			{
				shouldContinueInput = false;
				players[currentPlayerNo].addNewPosition(position);
				players[currentPlayerNo].placeSymbol(board,position);
			}
		}
		board.gridPrinting();
	}

	void switchPlayer()
	{
		currentPlayerNo = 1-currentPlayerNo;
	}

}
