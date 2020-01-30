import java.util.Scanner;
class Board
{
	Character[] Grid=new Character[9];
	int input(Character c)
	{
		Scanner read=new Scanner(System.in);
		while(true)
		{
			int pos=read.nextInt();
			if(validateInput(pos))
			{
				Grid[pos-1]=c;
				return pos;
			}
		}
	}
	boolean validateInput(int pos)
	{
		if(pos<10 && Grid[pos-1]==null)
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
		for(int pos=0;pos<Grid.length;pos++)
		{
			System.out.print(Grid[pos]+" ");
			if(pos==2 ||pos==5 ||pos==8)
				System.out.println();
		}
	}
}
