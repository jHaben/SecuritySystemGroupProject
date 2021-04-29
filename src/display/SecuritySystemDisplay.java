package display;

import javafx.scene.text.Text;

/**
 * SecuritySystemDisplay class Parent class for the GUIDisplay. All methods will
 * be intialized here and be given functions in GUIDisplay.
 * 
 * @author Group: Mitchell Young, Kou Yang, Trung Pham, Jack Haben
 */
public interface SecuritySystemDisplay {

	/**
	 * Displays the time remaining
	 * 
	 * @param time: Time remaining
	 */
	public void showTimeLeft(int time);

	/**
	 * Displays in the GUI that the system is unarmed
	 */
	public void showUnarmed();

	/**
	 * Displays in the GUI that the system is ready
	 * to arm at the user's discretion
	 */
	public void showReady();

	/**
	 * Displays in the GUI that the system is not
	 * ready to be armed.
	 */
	public void showNotReady();

	/**
	 * Starts the countdown with the timer.	
	 */
	public void showCounDownStart();

	/**
	 * Show the timer that ran out.
	 */
	public void showTimeRunOut();

	/**
	 * Displays on the GUI that the system is armed
	 * in away mode.
	 */
	public void showAwayArmed();

	/**
	 * Displays on the GUI that the system is armed
	 * in stay mode.
	 */
	public void showStayArmed();

	/**
	 * Displays on the GUI that the system
	 * is asking for the password.
	 */
	public void showPasswordRequired();

	/**
	 * Show that the system is 
	 * currently in the warning state.
	 */
	public void showWarning(int time);

	/**
	 * Shows the password that is being entered.
	 * 
	 * @param numberButtonValue - The string value of the number button
	 */
	public void showingPassword(String numberButtonValue);

	/**
	 * Displays on the GUI that the
	 * SecuritySystem has since been breached
	 */
	public void showBreachState();

	/**
	 * Method that clears the text from
	 * the text area in the gui
	 */
	public void clearText();

	/**
	 * Method that gets the text in the GUI
	 * 
	 * @return 
	 */
	public Text getGuiText();

}
