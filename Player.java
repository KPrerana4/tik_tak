import java.util.Scanner;
import java.util.ArrayList;
public class Player
{
	String name;
	Character symbol;
	ArrayList<Integer> positions;

	Player(Character symbol)
	{
		this.symbol = symbol;
		positions = new ArrayList<Integer>();
		name = "";
	}

	int input()
	{
		System.out.println("Player (symbol " + symbol + ") enter position:");
		Scanner read = new Scanner(System.in);
		int position = read.nextInt();
		return position;
	}

	void addNewPosition(int newPosition)
	{
		positions.add(newPosition);
	}

}
