import java.util.Scanner;
class Player
{
	String name;
	int[] positions;
	int positionIndex;
	Player()
	{
		name="";
		positions=new int[6];
		positionIndex=0;
	}

	Player(String name)
	{
		this.name=name;
	}
	void input(Board board,Character playerLetter,int player_no)
	{
		
		Scanner read=new Scanner(System.in);
		boolean continueInput=true;
		while(continueInput)
		{
			int position=read.nextInt();
			if(board.validateInput(position))
			{
				positionIndex+=1;
				positions[positionIndex]=position;
				board.Grid[position-1]=playerLetter;
				break;
			}
		}	
	}
}