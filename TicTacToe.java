public class TicTacToe
{
	Integer[][] winningConditions = {{1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}};
	Player player1 = new Player('X');
	Player player2 = new Player('O');
	Board board;
	Player currentPlayer;
	Player winner;

	TicTacToe()
	{
		board = new Board();
		currentPlayer = player1;
		winner = null;
	}

	void printWinner()
	{
		String result = "You won";
		if(winner == null)
			result = "No one won";
		System.out.println(result);
	}

	void game()
	{
		boolean playerWin;
		do {
			playerRole();
			playerWin = board.winCheck(currentPlayer.positions, winningConditions);
			switchPlayer();
		}while(!(playerWin || board.isGridFilled()) );
		switchPlayer();
		if(playerWin) {
			winner = currentPlayer;
		}
		printWinner();
	}

	void playerRole()
	{
		int position = currentPlayer.input();
		while(!board.isPositionValid(position))
		{
			position = currentPlayer.input();
		}
		currentPlayer.addNewPosition(position);
		board.placeSymbolInGrid(position,currentPlayer.symbol);
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
