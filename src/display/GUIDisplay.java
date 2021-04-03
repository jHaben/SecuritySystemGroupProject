package display;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUIDisplay extends Application {

	// Button Stand-ins. We'll have to change these later accordingly.
	private Button button1 = new Button("1");
	private Button button2 = new Button("2");
	private Button button3 = new Button("3");
	private Button button4 = new Button("4");
	private Button button5 = new Button("5");
	private Button button6 = new Button("6");
	private Button button7 = new Button("7");
	private Button button8 = new Button("8");
	private Button button9 = new Button("9");
	private Button button0 = new Button("0");
	private Button stayButton = new Button("Stay");
	private Button awayButton = new Button("Away");
	private Button cancelButton = new Button("Cancel");
	private Button motionDetectorButton = new Button("Motion Detector");

	// Check boxes
	private CheckBox zone1CheckBox = new CheckBox("Zone 1");
	private CheckBox zone2CheckBox = new CheckBox("Zone 2");
	private CheckBox zone3CheckBox = new CheckBox("Zone 3");

	// Text area to advise the user of what's going on
	private TextArea textArea = new TextArea();

	// Label
	private Label readyStatusLabel = new Label("Ready Status");

	// GridPanes to put the gui together.
	GridPane userInterfacePane = new GridPane();
	GridPane topPane = new GridPane(); // Pane for the top half
	GridPane bottomPane = new GridPane(); // Pane for the bottom half.
	GridPane numbersGridPane = new GridPane();

	@Override
	public void start(Stage primaryStage) throws Exception {

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
		textArea.setPrefHeight(100);
		textArea.setPrefWidth(375);
		topPane.add(textArea, 1, 0);

		// Putting together bottom pane. Starting with checkboxes
		bottomPane.add(zone1CheckBox, 0, 0);
		bottomPane.add(zone2CheckBox, 1, 0);
		bottomPane.add(zone3CheckBox, 2, 0);

		// Adding buttons and labels to bottom pane
		bottomPane.add(stayButton, 4, 0);
		bottomPane.add(awayButton, 5, 0);
		bottomPane.add(cancelButton, 6, 0);
		bottomPane.add(readyStatusLabel, 2, 1);
		bottomPane.add(motionDetectorButton, 2, 2);

		// Adding all the panes together
		userInterfacePane.add(topPane, 0, 0);
		userInterfacePane.add(bottomPane, 0, 1);

		// Displaying the panes
		Scene scene = new Scene(userInterfacePane);
		primaryStage.setTitle("Security System");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		Application.launch(null);
	}

}
