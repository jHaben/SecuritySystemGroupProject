package buttons;

import events.AllDoorCloseEvent;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import states.SecuritySystemContext;

public class ZoneCheckBox extends GUICheckBox implements EventHandler<ActionEvent>{

	private boolean ready;
	public ZoneCheckBox(String string) {
		super(string);
		ready=false;
		 this.selectedProperty().addListener(
			      (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
			       changeStatus();
			      });
		 
	}

	private void changeStatus() {
		if(ready==false)ready=true;
		else ready=false;
	}

	public boolean isReady() {
		return ready;
	}

	public void setReady(boolean ready) {
		this.ready = ready;
	}
	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
