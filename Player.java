import java.util.Scanner;
class Player
{
	String name;
	int[] positions;
	int noOfPositions;
	Player()
	{
		name="";
		positions=new int[6];
		noOfPositions=0;
	}

	Player(String name)
	{
		this.name=name;
	}
	void input(Board board,Character playerLetter,int player_no)
	{
		
		Scanner read=new Scanner(System.in);
		boolean shouldContinueInput=true;
		while(shouldContinueInput)
		{
			int position=read.nextInt();
			if(board.validateInput(position))
			{
				positions[noOfPositions]=position;
				noOfPositions+=1;
				board.Grid[position-1]=playerLetter;
				shouldContinueInput=false;
			}
		}	
	}
}