import pkg.*;
import java.util.*;

public class starter implements InputControl, InputKeyControl
{
    public static void p(String s) {System.out.print(s);}
	public static void main(String args[])
    {
		// User input
		KeyController kC = new KeyController(Canvas.getInstance(),new starter());
		MouseController mC = new MouseController(Canvas.getInstance(),new starter());

        // clearTest();

        Scanner sc = new Scanner(System.in);
        Grid g; // dimensions

        p("Enter side length of grid: ");

	}

	public void onMouseClick(double x, double y)
    {
		// enter code here

	}

	public void keyPress(String s)
    {
		// enter code here

	}

    // public static void clearTest() {   clear is confirmed to work
    //     Random rand = new Random();
    //     for(int i=0;i<10;i++) {
    //         for(int j=0;j<50000;j++) {
    //             Ellipse e = new Ellipse(rand.nextInt(1000),rand.nextInt(600),rand.nextInt(100),rand.nextInt(100));
    //             e.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
    //             e.fill();
    //         }
    //         System.out.println("pausing!");
    //         Canvas.pause(1000);
    //         Canvas.getInstance().clear();
    //         Canvas.pause(1000);
    //     }
    // }
}