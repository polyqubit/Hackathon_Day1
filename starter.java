import pkg.*;
import java.util.*;

public class starter implements InputControl, InputKeyControl {

	public static void main(String args[]) {
		// User input
		KeyController kC = new KeyController(Canvas.getInstance(),new starter());
		MouseController mC = new MouseController(Canvas.getInstance(),new starter());
	}

	public void onMouseClick(double x, double y) {
		// enter code here

	}

	public void keyPress(String s) {
		// enter code here

	}
}