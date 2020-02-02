import java.util.Scanner;
import java.util.ArrayList;
public class Player
{
	String name;
	Character symbol;
	ArrayList<Integer> positions;
	int playerNo;

	Player(Character symbol,int playerNo)
	{
		this.symbol = symbol;
		positions = new ArrayList<Integer>();
		name = "";
		this.playerNo = playerNo;
	}

	int input()
	{
		System.out.println("Player "+(playerNo+1)+", enter position:");
		Scanner read = new Scanner(System.in);
		int position = read.nextInt();
		return position;
	}

	void addNewPosition(int newPosition)
	{
		positions.add(newPosition);
	}

	void placeSymbol(Board board,int position)
	{
		board.placeSymbolInGrid(position,symbol);
	}

}
