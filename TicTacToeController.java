class TicTacToeController
{
	void Game()
	{
		int[][] successPositions={{1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}};
		Player[] players=new Player[2];
		players[0]=new Player();
		players[1]=new Player();
		Board board=new Board();
		Character c;
		int count=0,player_no,positions_length;
		while(true)
		{
			player_no=1;c='O';
			if(count%2==0){player_no=0;c='X';}
			System.out.println("Player"+player_no+" enter position(count="+count+"):");
			players[player_no].positions+=Integer.toString(board.input(c));
			boolean f=board.winCheck(players[player_no].positions,successPositions);
			if(f)    //(board.winCheck(players[player_no].positions,successPositions))
			{
				System.out.println("You Won");
				break;
			}
			board.gridPrinting();
			count++;
			if(count>8)
			{
				System.out.print("No one Won");
				break;
			}
		}
	}	
}
