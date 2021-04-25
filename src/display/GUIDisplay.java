package display;

import buttons.AwayButton;
import buttons.CancelButton;
import buttons.CheckBoxes;
import buttons.CurrentStateButton;
import buttons.GUIButton;
import buttons.MotionDetectedButton;
import buttons.NumberButton;
import buttons.StayButton;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import states.SecuritySystemContext;

/**
 * GUI Display class. The class essentially puts together the GUI.
 * 
 * @author Group: Mitchell Young, Kou Yang, Trung Pham, Jack Haben
 */

public class GUIDisplay extends Application implements SecuritySystemDisplay {

	public String passwordEntered = "";
	// ==== TEMPORARY BUTTON FOR DEBUGGING ====
	private GUIButton currentStateButton = new CurrentStateButton("Click for current state");

	// Number buttons
	private GUIButton button1;
	private GUIButton button2;
	private GUIButton button3;
	private GUIButton button4;
	private GUIButton button5;
	private GUIButton button6;
	private GUIButton button7;
	private GUIButton button8;
	private GUIButton button9;
	private GUIButton button0;

	// Event buttons
	private GUIButton stayButton;
	private GUIButton awayButton;
	private GUIButton cancelButton;
	private GUIButton motionDetectorButton;

	private CheckBoxes zones = CheckBoxes.instance();

	// Text area to advise the user of what's going on
	private Text textArea = new Text();
	//TODO: ADD ANOTHER TEXT AREA SO WE CAN ASSIGN ONE TO PW AND ONE TO STATE MESSAGE? If so, refractor textArea to messageTextArea - KOU
	//private Text inputTextArea = newText();

	// Label
	private Label readyStatusLabel = new Label("Ready Status");

	// GridPanes to put the gui together.
	GridPane userInterfacePane = new GridPane(); // The entire pane.
	GridPane topPane = new GridPane(); // Pane for the top half
	GridPane bottomPane = new GridPane(); // Pane for the bottom half.
	GridPane numbersGridPane = new GridPane(); // Number pane for the numbers

	// Singleton information
	private static SecuritySystemDisplay display;
	private SecuritySystemContext securitySystemContext;

	public static SecuritySystemDisplay getInstance() {
		return display;
	}

	/**
	 * Start method that puts together the GUI.
	 * 
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {

		securitySystemContext = SecuritySystemContext.instance();
		securitySystemContext.setDisplay(this);
		display = this;

		// Number buttons
		button1 = new NumberButton("1");
		button2 = new NumberButton("2");
		button3 = new NumberButton("3");
		button4 = new NumberButton("4");
		button5 = new NumberButton("5");
		button6 = new NumberButton("6");
		button7 = new NumberButton("7");
		button8 = new NumberButton("8");
		button9 = new NumberButton("9");
		button0 = new NumberButton("0");

		// Event buttons
		stayButton = new StayButton("Stay");
		awayButton = new AwayButton("Away");
		cancelButton = new CancelButton("Cancel");
		motionDetectorButton = new MotionDetectedButton("Motion Detector");

		// Buttons sitting in their own pane.
		numbersGridPane.add(button1, 0, 0);
		numbersGridPane.add(button2, 1, 0);
		numbersGridPane.add(button3, 2, 0);
		numbersGridPane.add(button4, 0, 1);
		numbersGridPane.add(button5, 1, 1);
		numbersGridPane.add(button6, 2, 1);
		numbersGridPane.add(button7, 0, 2);
		numbersGridPane.add(button8, 1, 2);
		numbersGridPane.add(button9, 2, 2);
		numbersGridPane.add(button0, 1, 3);

		// Adding the buttons to the main pane
		topPane.add(numbersGridPane, 0, 0);

		// Text area that'll display what's going on
		// textArea.setPrefHeight(100);
		// textArea.setPrefWidth(375);
		topPane.add(textArea, 1, 0);

		// Adding buttons and labels to bottom pane
		bottomPane.add(stayButton, 4, 0);
		bottomPane.add(awayButton, 5, 0);
		bottomPane.add(cancelButton, 7, 0);
		bottomPane.add(readyStatusLabel, 2, 1);
		bottomPane.add(motionDetectorButton, 2, 2);

		// Check boxes
		// Putting together bottom pane. Starting with check boxes
		bottomPane.add(zones.getZone1(), 0, 0);
		bottomPane.add(zones.getZone2(), 1, 0);
		bottomPane.add(zones.getZone3(), 2, 0);

		// ====TEMPORARY BUTTON FOR DEBUGGING (TO CHECK CURRENT STATE) =====
		bottomPane.add(currentStateButton, 2, 3);

		// Adding all the panes together
		userInterfacePane.add(topPane, 0, 0);
		userInterfacePane.add(bottomPane, 0, 1);

		// Displaying the panes
		Scene scene = new Scene(userInterfacePane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Security System");

		try {
			while (securitySystemContext == null) {
				Thread.sleep(1000);
			}
		} catch (Exception e) {

		}
		primaryStage.show();
		primaryStage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent window) {
				System.exit(0);
			}
		});

		securitySystemContext.instance().getCurrentState().enter();
	}

	@Override
	public void showTimeLeft(int time) {
		textArea.setText("Time Left: " + time + " s");

	}

	@Override
	public void showReady() {
		// textArea.clear();
		textArea.setText("Ready to arm");
	}

	@Override
	public void showNotReady() {
		textArea.setText("Not ready to arm. One or more doors are open.");
	}

	@Override
	public void showUnarmed() {
		textArea.setText("Not ready to arm. One or more doors are open.");
	}

	@Override
	public void showCounDownStart() {
		textArea.setText("Time coundown start");
	}

	@Override
	public void showTimeRunOut() {
		textArea.setText("Time coundown start");
	}

	@Override
	public void showAwayArmed() {
		textArea.setText("Away Armed");

	}

	@Override
	public void showStayArmed() {
		textArea.setText("Stay Armed");
	}

	@Override
	public void showPasswordRequired() {
		textArea.setText("Enter password to disarm alarm");

	}

	//TODO: THIS ISN'T BEING USED/SHOWN ON GUI - KOU
	@Override
	public void showWarning() {
		textArea.setText("Warning!\nEnter password to disarm system.");

	}

	@Override
	public void showingPassword(String numberButtonValue) {
		textArea.setText(textArea.getText() + numberButtonValue);
	}

	@Override
	public void showBreachState() {
		textArea.setText("BREACHED!\nEnter password to disarm system.");
	}

	@Override
	public void clearText() {
		textArea.setText("");
	}

	@Override
	public Text getGuiText() {
		return textArea;

	}

}
