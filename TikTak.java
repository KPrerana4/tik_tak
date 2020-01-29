import java.util.ArrayList;
import java.util.Scanner;
public class TikTak
{
	String[] all_success_positions={"123","456","789","147","258","369","159","357"};
	String[] player=new String[2];
	int filled_positions=0;
	Character[] placed=new Character[9];

	public static void main(String[] args) 
	{
		byte player_no,count=0;
		TikTak game=new TikTak();
		while(true)
		{
			player_no=1;
			if(count%2==0)
				player_no=0;
			if(game.input(player_no))
			{
				System.out.println("PLAYER "+(player_no+1)+" WON");
				break;
			}
			game.printGrid();
			count++;
			if(game.filled_positions==9)
			  { 
			  	System.out.println("Game Over,No one Won");
			  	break;
			  }
		}
	}


	void printGrid()
	{
		for(int pos=0;pos<9;pos++)
			{
				System.out.print(placed[pos]+" ");
				if(pos==2 || pos==5 || pos==8)
					System.out.println();
			}
	}


	boolean input(int player_no)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Player "+(player_no+1)+"'s turn:");
		int val;
		byte win=0;
		Character c='X';
		if(player_no==1)
			 c='O';
		while(true)
		{
			val=sc.nextInt();
			if(placed[val-1]==null && val<10)
			{	
				filled_positions++;
				player[player_no]+=Integer.toString(val);
				placed[val-1]=c;
				return (new gameCheck().check(player[player_no],all_success_positions));
			}
		}
	}		
}

class gameCheck
{
	boolean check(String player,String[] all_success_positions)
	{
	   int flag;
		for(int each_success=0;each_success<all_success_positions.length;each_success++)
		{
			flag=1;
			for(int pos=0;pos<all_success_positions[each_success].length();pos++)
				 if(!player.contains(Character.toString(all_success_positions[each_success].charAt(pos))))
				 	 flag=0;
			if(flag==1)
				return true;
		}
		return false;	
	}
}

