import pkg.*;
import java.lang.Math;
public class Cell
{
    private int isAlive; // 1 alive 0 dead
    private int isFutureAlive;
    public Cell(int isAlive)
    {
        this.isAlive = isAlive;
    }

    public int getIsAlive()
    {
        return isAlive;
    }
    public void setFuture(int i)
    {
        isFutureAlive = i;
    }
    public void update()
    {
        isAlive = isFutureAlive;
    }
}