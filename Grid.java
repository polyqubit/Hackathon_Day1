import pkg.*;
import java.util.Random;

public class Grid
{
    private Cell[][] grid;

    public Grid()
    {
        this(50,50);
    }

    public Grid(int size)
    {
        this(size, size);
    }
    
    public Grid(int sizex, int sizey)
    {
        grid = new Cell[sizex+2][sizey+2];
        for(int i = 1; i < sizey+1; i++) 
        {
            for(int j = 1; j < sizex+1; j++)
            {
                grid[i][j] = new Cell((int)(Math.random()*2));
            }
        }

        for(int i=0;i<grid[0].length;i++) {
            grid[0][i] = new Cell(0);
        }
        for(int i=0;i<grid[0].length;i++) {
            grid[grid.length-1][i] = new Cell(0);
        }
        for(int i=1;i<grid.length-1;i++) {
            grid[i][grid.length-1] = new Cell(0);
        }
        for(int i=1;i<grid.length-1;i++) {
            grid[i][0] = new Cell(0);
        }
    }

    public void update()
    {

        for(int i = 1; i < grid.length-1; i++)
        {
            for(int j = 1; j < grid[0].length-1; j++)
            {
                int counter = 0;
                //def a cleaner way to do this :/

                counter += grid[i-1][j].getIsAlive();    //<-- First solution
                counter += grid[i-1][j-1].getIsAlive();
                counter += grid[i-1][j+1].getIsAlive();
                counter += grid[i][j-1].getIsAlive();
                counter += grid[i][j+1].getIsAlive();
                counter += grid[i+1][j].getIsAlive();
                counter += grid[i+1][j-1].getIsAlive();
                counter += grid[i+1][j+1].getIsAlive();

                /*
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
                */

                if(grid[i][j].getIsAlive() == 1 && (counter < 2 || counter > 3))
                    System.out.println(counter);
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

    public void draw()
    {
        Canvas.getInstance().clear();
        for(int i = 1; i < grid.length-1; i++)
        {
            for(int j = 1; j < grid[1].length-1; j++)
            {
                drawBox(j*5, i*5, grid[i][j].getIsAlive());
            }
        }
        update();
        update();
    }
    private void drawBox(int x, int y, int alive)
    {
        Rectangle r = new Rectangle(x,y,5,5);
        r.setColor(new Color(alive*255,alive*255,alive*255));
        r.fill(0,y,500,5);
        // r.fill();
    }
}
