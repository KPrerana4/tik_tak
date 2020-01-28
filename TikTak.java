import java.util.Scanner;
import java.util.Arrays;
public class TikTak
{
    static Character[][] tik=new Character[3][3];
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		boolean f=false;
		int ip=0;
		System.out.println("Player 1:X\t\tPlayer 2:O");
		
		while(true)
		{
		  while(true)
		  {
		    System.out.println("\nPlayer 1, Enter position(as x y):");
		    int x1=sc.nextInt();
		    int y1=sc.nextInt();
		    if(tik[x1][y1]==null && x1<3 && y1<3)
		    {
		        ip++;
		        tik[x1][y1]='X';
		        f=check(x1,y1);      
		           break;
		    }
		  }
		  for(int i=0;i<3;i++)
		     System.out.println(Arrays.toString(tik[i]));
		  if(f==true){System.out.println("\nPLAYER 1 WON");
		     break;}
		     
		  if(ip==9){
		      System.out.println("Game over,No one won");
		      break;
		   }
		   
		   
		   
		  while(true)
		  {
		     System.out.println("\nPlayer 2, Enter position(as x y):");
		     int x2=sc.nextInt();
		     int y2=sc.nextInt();
		     if(tik[x2][y2]==null && x2<3 && y2<3)
		     {ip++;
		       tik[x2][y2]='O';    
		       f=check(x2,y2);     
		        break;
		     }
		  } 
		  for(int i=0;i<3;i++)
		     System.out.println(Arrays.toString(tik[i]));
		  if(f==true){System.out.println("\nPLAYER 2 WON");
		     break;}
		     
		   if(ip==9){
		      System.out.println("Game over,No one won");
		      break;
		   }
	   }
	}
	
	
	static boolean check(int x,int y)
	{
	    Character c=tik[x][y];
	    int f1=1,i,j;
	            
	    for(i=0;i<3;i++)
	       if(tik[x][i]!=c)
	          f1=0;
	             
	    if(f1==1)return true;
	    f1=1;
	    for(i=0;i<3;i++)
	       if(tik[i][y]!=c)
	           f1=0;
	           
	   if(f1==1)
	      return true;
	   f1=1;
	   for(i=0,j=0;i<3;i++,j++)
	      if(tik[i][j]!=c)
	         f1=0;
	   if(f1==1)
	      return true;
	          
	   f1=1;
	   for(i=0,j=2;i<3;i++,j--)
	      if(tik[i][j]!=c)
	         f1=0;
	   if(f1==1)
	      return true;
	          
	   
	   return false;
	}

}
