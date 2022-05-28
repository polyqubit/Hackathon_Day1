import pkg.*;
import java.lang.Math;
public class Cell
{
    private int isAlive; // 1 alive 0 dead
    private int isFutureAlive;
    public Cell(int isAlive)
    {
        this.isAlive = isAlive;
        this.isFutureAlive = isAlive;
    }

    public int getIsAlive()
    {
        return isAlive;
    }
    public void setIsFutureAlive()
    {
        isFutureAlive = Math.abs(isFutureAlive-1);
    }
    public void update()
    {
        isAlive = isFutureAlive;
    }
}