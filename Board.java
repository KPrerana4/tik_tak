import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Board
{
	private Character[] grid = {'-','-','-','-','-','-','-','-','-'};

	void placeSymbolInGrid(int position,Character symbol)
	{
		grid[position-1] = symbol;
	}

	boolean isPositionValid(int position)
	{
		Character gridDefaultSymbol = '-';
		boolean isPositionValueDefault = grid[position-1] == gridDefaultSymbol;
		int gridLength = grid.length;
		boolean isValidPosition = position>0 && position<=gridLength && isPositionValueDefault;
		return isValidPosition;
	}

	void gridPrinting()
	{
		Character[] delimeters = {' ',' ','\n',' ',' ','\n',' ',' ','\n'};
		int gridLength = grid.length;
		for(int position = 0; position < gridLength ; position++)
		{
			System.out.print(grid[position] + " " +delimeters[position]);
		}
	}

	boolean isGridFilled()
	{
		int gridPosition,gridLength = grid.length;
		boolean gridFilled=false;
		for(gridPosition = 0; gridPosition < gridLength && grid[gridPosition] != '-' ; gridPosition++)
		{
			gridFilled=true;
		}
		return gridFilled && (gridPosition == gridLength);
	}

	boolean winCheck(ArrayList<Integer> playerPositions,Integer[][] winningConditions)
	{
		int noOfWinningConditions = winningConditions.length;
		for(int condition = 0; condition < noOfWinningConditions ; condition++)
		{
			List<Integer>  positions = Arrays.asList(winningConditions[condition]);
			if(playerPositions.containsAll(positions))
			{
				return true;
			}
		}
		return false;
	}
}