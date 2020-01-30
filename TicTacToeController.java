class TicTacToeController
{
	void Game()
	{
		int[][] successPositions={{1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}};
		Player[] players={new Player(),new Player()};
		Board board=new Board();
		Character XorO;
		int count=0,player_no;
		while(true)
		{
			XorO='O';
			if((player_no=switchPlayer(count))==0)
				XorO='X';
			System.out.println("Player"+(player_no+1)+" enter position:");
			players[player_no].positions+=Integer.toString(board.input(XorO));
			if(board.winCheck(players[player_no].positions,successPositions)) 
			{
				System.out.println("You Won");
				break;
			}
			board.gridPrinting();
			if((++count)>8)
			{
				System.out.println("No one Won");
				break;
			}
		}
	}
	int switchPlayer(int count)
	{
		return ((count%2==0)?0:1);
	}	
}