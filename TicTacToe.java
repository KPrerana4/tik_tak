class TicTacToe
{
	private int[][] successPositions={{1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}};
	private Player[] players={new Player(),new Player()};
	private Board board=new Board();
	private Character playerLetter;
	private int noOfFilledPositions=0,currentPlayerNo;

	void startGame()
	{
		boolean continueGame=true;
		while(continueGame)
		{
			playerLetter='O';
			if((currentPlayerNo=switchPlayer())==0)
				playerLetter='X';
			System.out.println("Player"+(currentPlayerNo+1)+" enter position:");
			players[currentPlayerNo].positions+=Integer.toString(board.input(playerLetter));
			if(board.winCheck(players[currentPlayerNo].positions,successPositions)) 
			{
				System.out.println("You Won");
				break;
			}
			board.gridPrinting();
			continueGame=isGridFilled();
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