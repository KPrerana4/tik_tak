class TicTacToe
{
	private int[][] winningPositions={{1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}};
	private Player[] players={new Player(),new Player()};
	private Board board=new Board();
	private Character playerLetter;
	private int noOfFilledPositions=0,currentPlayerNo;

	void startGame()
	{
		boolean shouldContinueGame=true;
		while(shouldContinueGame)
		{
			playerLetter=(currentPlayerNo=switchPlayer())==0 ? 'X': 'O';
			System.out.println("Player"+(currentPlayerNo+1)+" enter position:");
			int positionIndex=players[currentPlayerNo].positionIndex;
			players[currentPlayerNo].input(board,playerLetter,currentPlayerNo);
			boolean win=board.winCheck(players[currentPlayerNo].positions,winningPositions);
			if(win) 
			{
				System.out.println("You Won");
				break;
			}
			board.gridPrinting();
			shouldContinueGame=isGridFilled();
		}
	}

	int switchPlayer()
	{
		return noOfFilledPositions%2==0 ? 0 : 1;
	}

	boolean isGridFilled()
	{
		if(++noOfFilledPositions>8)
			{
				System.out.println("No one Won");
				return false;
			}
			return true;
	}
}