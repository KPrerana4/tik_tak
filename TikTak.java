import java.util.Scanner;
import java.util.Arrays;
public class TikTak
{
    private Character[][] grid=new Character[3][3];
    int no_of_inputs;
    
	public static void main(String[] args) 
	{
		boolean f=false;
		TikTak obj=new TikTak();
		System.out.println("Player 1:X\t\tPlayer 2:O");
		int count=0;
		short player_no;
		
		while(true)
		{
		  player_no=2;
		  if(count%2==0)
		     player_no=1;
		  f=obj.take_input(player_no);
		  for(int i=0;i<3;i++)
		     System.out.println(Arrays.toString(obj.grid[i]));
		  if(f==true){System.out.println("\nPLAYER "+player_no+" WON");
		     break;}
		     
		  if(obj.no_of_inputs==9){
		      System.out.println("Game over,No one won");
		      break;
		   }
		   count++;
	   }
	}
	
	
    boolean check_row_coloum(int x,int y)
	{
	    Character c=grid[x][y];
	    int f1=1,i,j;
	            
	    for(i=0;i<3;i++)
	       if(grid[x][i]!=c)
	          f1=0;
	    if(f1==1)
	        return true;
	    
	    f1=1;
	    for(i=0;i<3;i++)
	       if(grid[i][y]!=c)
	           f1=0;
	   if(f1==1)
	      return true;
	      
	   return false;
	}
	
	
	boolean validate_diagonal_pos(int x,int y)
	{
	   Character c=grid[x][y];
	   int i,j,f1=1;
	   for(i=0,j=0;i<3;i++,j++)
	      if(grid[i][j]!=c)
	         f1=0;
	   if(f1==1)
	      return true;
	          
	   f1=1;
	   for(i=0,j=2;i<3;i++,j--)
	      if(grid[i][j]!=c)
	         f1=0;
	   if(f1==1)
	      return true;
	         
	   return false;
	}
	
	
    boolean take_input(short player_no)
	{
	    Scanner sc=new Scanner(System.in);
	    boolean row_coloum=false,diagonal=false;
	    Character c='O';
	    if(player_no==1)
	        c='X';
	    while(true)
		  {
		    System.out.println("\nPlayer "+player_no+", Enter position(as x y):");
		    int row_pos=sc.nextInt();
		    int coloum_pos=sc.nextInt();
		    if(row_pos<3 && coloum_pos<3 && grid[row_pos][coloum_pos]==null)
		    {
		        no_of_inputs++;
		        grid[row_pos][coloum_pos]=c;
		        row_coloum=check_row_coloum(row_pos,coloum_pos); 
		        diagonal=validate_diagonal_pos(row_pos,coloum_pos);
		           break;
		    }
		  }
		  if(row_coloum || diagonal)
		      return true; 
		  return false;
	}
}

