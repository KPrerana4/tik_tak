import java.util.Scanner;
class Board
{
	Character[] Grid=new Character[9];

	int input(Character playerLetter)
	{
		Scanner read=new Scanner(System.in);
		boolean continueInput=true;
		while(continueInput)
		{
			int position=read.nextInt();
			if(validateInput(position))
			{
				Grid[position-1]=playerLetter;
				return position;
			}
		}
		return -1;
	}

	boolean validateInput(int position)
	{
		if(position!=0 && position<10  && Grid[position-1]==null)
			return true;
		return false;
	}

	boolean winCheck(String playerPositions,int[][] successPositions)
	{
		for(int condition=0;condition<successPositions.length;condition++)
		{
			int count=0;
			for(int position=0;position<successPositions[condition].length;position++)
				if(playerPositions.contains(Integer.toString(successPositions[condition][position])))
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