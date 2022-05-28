import pkg;
import Cell;
import java.lang.Math.random();

public class Grid
{
    private Cell[][] grid;
    public Grid(int size)
    {
        grid = new Cell[size][size];
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; i < grid[0].length; j++) {
                grid[i][j] = ne
            }
        }

    }
    public Grid(int sizex, int sizey)
    {
        grid = new Cell[sizex+1][sizey+1];

    }
    public Grid()
    {
        grid = new Cell[51][51];
    }


    public void advance()
    {
        for(int i = 1; i < grid.length-1; i++)
        {
            for(int j = 1; i < grid[0].length-1; j++)
            {
                int counter = 0;
                // def a cleaner way to do this :/
                counter += grid[i-1][j];
                counter += grid[i-1][j-1];
                counter += grid[i-1][j+1];
                counter += grid[i][j-1];
                counter += grid[i][j+1];
                counter += grid[i+1][j];
                counter += grid[i+1][j-1];
                counter += grid[i+1][j+1];
                if(grid[i][j].getIsAlive == 1 && (counter < 2 || counter > 3))
                    grid[i][j].setIsFutureAlive();
                if(grid[i][j].getIsAlive == 0 && counter == 3)
                    grid[i][j].setIsFutureAlive();
            }
        }
        for(Cell cell : grid)
            cell.update();
    }
}