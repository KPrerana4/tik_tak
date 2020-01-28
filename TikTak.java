import java.util.Scanner;
import java.util.Arrays;
public class TikTak
{
    private Character[][] grid=new Character[3][3];
    int no_of_valid_inputs;    

	public static void main(String[] args) 
	{
		boolean game_win=false;
		TikTak game_obj=new TikTak();
		System.out.println("Player 1:X\t\tPlayer 2:O");
		int count=0;
		short player_no;
		
		while(true)
		{
		   player_no=2;
		   if(count%2==0)
		      player_no=1;
		   game_win=game_obj.start_game(player_no);
		   for(int i=0;i<3;i++)
		      System.out.println(Arrays.toString(game_obj.grid[i]));
		   if(game_win==true){System.out.println("\nPLAYER "+player_no+" WON");
		      break;}
		     
		   if(game_obj.no_of_valid_inputs==9){
		       System.out.println("Game over,No one won");
		       break;
		    } 
		    count++;
	   }
	}
	
		
    boolean start_game(short player_no)
	{
	    Scanner scanner_obj=new Scanner(System.in);
	    boolean row_coloum=false,diagonal=false;
	    Character c='O';
	    if(player_no==1)
	        c='X';
	    while(true)
		  {
		    System.out.println("\nPlayer "+player_no+", Enter position(as x y):");
		    int row_pos=scanner_obj.nextInt();
		    int coloum_pos=scanner_obj.nextInt();
		    if(row_pos<3 && coloum_pos<3 && grid[row_pos][coloum_pos]==null)
		    {
		        no_of_valid_inputs++;
		        grid[row_pos][coloum_pos]=c;
		        ValidateGame validate_obj=new ValidateGame();
		        row_coloum=validate_obj.check_row_coloum(row_pos,coloum_pos,grid); 
		        diagonal=validate_obj.validate_diagonal_pos(row_pos,coloum_pos,grid);
		           break;
		    }
		  }
		  if(row_coloum || diagonal)
		      return true; 
		  return false;
	}
}



class ValidateGame
{
 boolean check_row_coloum(int row_pos,int coloum_pos,Character[][] grid)
 {
    Character c=grid[row_pos][coloum_pos];
	    int win=1,i,j;
	            
	    for(i=0;i<3;i++)
	       if(grid[row_pos][i]!=c)
	          win=0;
	    if(win==1)
	        return true;
	    
	    win=1;
	    for(i=0;i<3;i++)
	       if(grid[i][coloum_pos]!=c)
	           win=0;
	   if(win==1)
	      return true;
	      
	   return false;
   }

   boolean validate_diagonal_pos(int row_pos,int coloum_pos,Character[][] grid)
   {
   	  Character c=grid[row_pos][coloum_pos];
	   int i,j,win=1;
	   for(i=0,j=0;i<3;i++,j++)
	      if(grid[i][j]!=c)
	         win=0;
	   if(win==1)
	      return true;
	          
	   win=1;
	   for(i=0,j=2;i<3;i++,j--)
	      if(grid[i][j]!=c)
	         win=0;
	   if(win==1)
	      return true;
	         
	   return false;
   }
  }