public class TicTacToe
{
	Integer[][] winningConditions = {{1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}};
	Player player1 = new Player('X',0);
	Player player2 = new Player('O',1);
	Board board;
	Player currentPlayer;

	TicTacToe()
	{
		board = new Board();
		currentPlayer = player1;
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
			playerWin = board.winCheck(currentPlayer.positions, winningConditions);
			if(playerWin)
				return currentPlayer.playerNo;
			shouldContinueGame = !board.isGridFilled();
			switchPlayer();
		}
		return -1;
	}

	void playerMove()
	{
		boolean shouldContinueInput = true;
		while(shouldContinueInput)
		{
			int position = currentPlayer.input();
			if(board.validatePosition(position))
			{
				shouldContinueInput = false;
				currentPlayer.addNewPosition(position);
				currentPlayer.placeSymbol(board,position);
			}
		}
		board.gridPrinting();
	}

	void switchPlayer()
	{
		if(currentPlayer == player1)
			currentPlayer = player2;
		else
			currentPlayer = player1;

	}

}
