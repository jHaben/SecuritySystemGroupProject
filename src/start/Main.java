package start;
import display.GUIDisplay;
import javafx.application.Application;

public class Main {
	public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                Application.launch(GUIDisplay.class, null);
                System.out.println("GUI ran successfully.");
            }
        }.start();
	}
}
