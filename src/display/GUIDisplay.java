package display;

import buttons.AwayButton;
import buttons.CancelButton;
import buttons.CheckBoxes;
import buttons.CurrentStateButton;
import buttons.GUIButton;
import buttons.GUICheckBox;
import buttons.MotionDetectedButton;
import buttons.NumberButton;
import buttons.StayButton;
import buttons.ZoneCheckBox;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import states.SecuritySystemContext;

/**
 * GUI Display class. 
 * The class essentially puts together the GUI.
 * 
 * @author Group: Mitchell Young, Kou Yang, Trung Pham, Jack Haben
 */

public class GUIDisplay extends Application implements SecuritySystemDisplay {

	// ==== TEMPORARY BUTTON FOR DEBUGGING ====
	private GUIButton currentStateButton = new CurrentStateButton("Click for current state");
	
	// Number buttons
	private GUIButton button1 = new NumberButton("1");
	private GUIButton button2 = new NumberButton("2");
	private GUIButton button3 = new NumberButton("3");
	private GUIButton button4 = new NumberButton("4");
	private GUIButton button5 = new NumberButton("5");
	private GUIButton button6 = new NumberButton("6");
	private GUIButton button7 = new NumberButton("7");
	private GUIButton button8 = new NumberButton("8");
	private GUIButton button9 = new NumberButton("9");
	private GUIButton button0 = new NumberButton("0");
	
	// Event buttons
	private GUIButton stayButton = new StayButton("Stay");
	private GUIButton awayButton = new AwayButton("Away");
	private GUIButton cancelButton = new CancelButton("Cancel");
	private GUIButton motionDetectorButton = new MotionDetectedButton("Motion Detector");

	// Check boxes
	private CheckBoxes zones= CheckBoxes.instance();
	//private GUICheckBox zone1CheckBox = new ZoneCheckBox("Zone 1");
	//private GUICheckBox zone2CheckBox = new Zone2CheckBox("Zone 2");
	//private GUICheckBox zone3CheckBox = new Zone3CheckBox("Zone 3");

	// Text area to advise the user of what's going on
	private Text textArea = new Text();
	
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
		//textArea.setPrefHeight(100);
		//textArea.setPrefWidth(375);
		topPane.add(textArea, 1, 0);

		// Putting together bottom pane. Starting with check boxes
		bottomPane.add(zones.getZone1(), 0, 0);
		bottomPane.add(zones.getZone2(), 1, 0);
		bottomPane.add(zones.getZone3(), 2, 0);

		// Adding buttons and labels to bottom pane
		bottomPane.add(stayButton, 4, 0);
		bottomPane.add(awayButton, 5, 0);
		bottomPane.add(cancelButton, 7, 0);
		bottomPane.add(readyStatusLabel, 2, 1);
		bottomPane.add(motionDetectorButton, 2, 2);
		
		// ====TEMPORARY BUTTON FOR DEBUGGING (TO CHECK CURRENT STATE) =====
		bottomPane.add(currentStateButton, 2,3);

		// Adding all the panes together
		userInterfacePane.add(topPane, 0, 0);
		userInterfacePane.add(bottomPane, 0, 1);

		// Displaying the panes
		Scene scene = new Scene(userInterfacePane);
		primaryStage.setTitle("Security System");
		primaryStage.setScene(scene);
		primaryStage.show();

		securitySystemContext.instance().getCurrentState().enter();
	}



	@Override
	public void showTimeLeft(int time) {
		textArea.setText(" " + time);
		
	}
	
	@Override
	public void showReady() {
		//textArea.clear();
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

}
