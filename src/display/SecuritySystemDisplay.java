package display;

/**
 * SecuritySystemDisplay class
 * Parent class for the GUIDisplay.
 * All methods will be intialized here and be given 
 * functions in GUIDisplay.
 * 
 * @author Group: Mitchell Young, Kou Yang, Trung Pham, Jack Haben
 */
public interface  SecuritySystemDisplay {
	
	/**
	 * Displays the time remaining
	 * 
	 * @param time: Time remaining
	 */
	public void showTimeLeft(int time);
	
	public void showUnarmed();

	public void showReady();
	
	public void showNotReady();

	public void showCounDownStart();
	

	public void showTimeRunOut();

	public void showAwayArmed();

	public void showStayArmed();

	public void showPasswordRequired();

	public void showingPassword(String numberButtonValue);

	public void showBreachState();

       
    
	

	
	
}
