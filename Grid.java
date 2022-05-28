import pkg.*;
import java.util.Random;

public class Grid
{
    private Cell[][] grid;
    public Grid(int size)
    {
        this(size, size);
    }
    
    public Grid(int sizex, int sizey)
    {
        grid = new Cell[sizex+2][sizey+2];
        for(int i = 0; i < sizex+2; i++)
        {
            for(int j = 0; j < sizey+2; j++)
            {
                grid[i][j] = new Cell((int)(Math.random()*2));
            }
        }

    }
    public Grid()
    {
        this(50,50);
    }


    public void update()
    {
        for(int i = 1; i < grid.length-1; i++)
        {
            for(int j = 1; i < grid[0].length-1; j++)
            {
                int counter = 0;
                // def a cleaner way to do this :/
                // counter += grid[i-1][j];    <-- First solution
                // counter += grid[i-1][j-1];
                // counter += grid[i-1][j+1];
                // counter += grid[i][j-1];
                // counter += grid[i][j+1];
                // counter += grid[i+1][j];
                // counter += grid[i+1][j-1];
                // counter += grid[i+1][j+1];


                for(int x=j-1;x<3;x++)
                {
                    counter += grid[i-1][x].getIsAlive();
                }
                for(int y=i-1;y<3;y++)
                {
                    counter += grid[y][j+1].getIsAlive();
                }
                for(int x=j-1;x<2;x++)
                {
                    counter += grid[i+1][x].getIsAlive();
                }
                counter += grid[i][j-1].getIsAlive();


                if(grid[i][j].getIsAlive() == 1 && (counter < 2 || counter > 3))
                    grid[i][j].setIsFutureAlive();
                if(grid[i][j].getIsAlive() == 0 && counter == 3)
                    grid[i][j].setIsFutureAlive();
            }
        }
        for(Cell[] cellRow : grid)
        {
            for(Cell cell : cellRow)
            {
                cell.update();
            }
        }
    }
}
