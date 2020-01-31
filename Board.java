import java.util.Scanner;
class Board
{
	Character[] Grid=new Character[9];

	boolean validateInput(int position)
	{
		if(position!=0 && position<10  && Grid[position-1]==null)
			return true;
		return false;
	}

	boolean winCheck(int[] playerPositions,int[][] successPositions)
	{
		for(int condition=0;condition<successPositions.length;condition++)
		{
			int count=0;
			for(int position=0;position<successPositions[condition].length;position++)
				for(int playerPosition=0;playerPosition<playerPositions.length;playerPosition++)
					if(playerPositions[playerPosition]==successPositions[condition][position])
						count++;
			if(count==successPositions[condition].length)
				return true;
		}
		return false;
	}

	void gridPrinting()
	{
		for(int position=0;position<Grid.length;position++)
		{
			System.out.print(Grid[position]+" ");
			if(position==2 ||position==5 ||position==8)
				System.out.println();
		}
	}
}