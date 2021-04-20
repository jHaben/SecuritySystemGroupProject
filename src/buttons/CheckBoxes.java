package buttons;

//import checkbox.panel.ZoneCheckBox;
import events.AllDoorCloseEvent;
import events.DoorOpensEvent;
import javafx.event.ActionEvent;
import states.SecuritySystemContext;

public class CheckBoxes  implements Runnable  {
	private ZoneCheckBox zone1;
	private ZoneCheckBox zone2;
	private ZoneCheckBox zone3;
	private Boolean zonesReady;
	private Thread thread = new Thread(this);
	private static CheckBoxes instance;
	
	
	public CheckBoxes(){
	zone1= new ZoneCheckBox("zone1");
	zone2= new ZoneCheckBox("zone2");	
	zone3= new ZoneCheckBox("zone3");	
	zonesReady= false;
	thread.start();

	}
	public static CheckBoxes instance() {
        if (instance == null) {
            instance = new CheckBoxes();
        }
        return instance;
    }	
	public ZoneCheckBox getZone1() {
		return zone1;
	}

	public void setZone1(ZoneCheckBox zone1) {
		this.zone1 = zone1;
	}

	public ZoneCheckBox getZone2() {
		return zone2;
	}

	public void setZone2(ZoneCheckBox zone2) {
		this.zone2 = zone2;
	}

	public ZoneCheckBox getZone3() {
		return zone3;
	}

	public void setZone3(ZoneCheckBox zone3) {
		this.zone3 = zone3;
	}

	public Boolean checkZonesReady() {
		if(zone1.isReady()&&zone2.isReady()&&zone3.isReady())	{	
				zonesReady=true;
			return zonesReady;
		}
		else {
			zonesReady=false;
			return zonesReady;
		}
		
	}
	
	 public void handle(ActionEvent event) {
	 }

	@Override
	public void run() {
		 
			 while(!checkZonesReady()) {System.out.printf("");}
	          
	            	SecuritySystemContext.instance().handleEvent(AllDoorCloseEvent.instance());
	}
	}	 


	     
	


