package buttons;

import events.AllDoorCloseEvent;
import events.DoorOpensEvent;
import javafx.event.ActionEvent;
import states.SecuritySystemContext;
import states.UnarmedStage;
import states.ZoneReadyState;

public class CheckBoxes  implements Runnable  {
	private ZoneCheckBox zone1;
	private ZoneCheckBox zone2;
	private ZoneCheckBox zone3;
	private Boolean zonesReady;
	private Thread thread = new Thread(this);
	private static CheckBoxes instance;
	
	
	
	public CheckBoxes() {
	zone1= new ZoneCheckBox("zone1");
	zone2= new ZoneCheckBox("zone2");	
	zone3= new ZoneCheckBox("zone3");
	zonesReady=true;
	thread.start();

	}

	public static CheckBoxes instance()  {
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
	public Thread getThread() {
		return thread;
	}
	public void setThread(Thread thread) {
		this.thread = thread;
	}
	public Boolean checkZonesReady() {
		if(zone1.isReady()&&zone2.isReady()&&zone3.isReady())	{	
				zonesReady=true;
			return zonesReady;
		}
		if(!zone1.isReady()||!zone2.isReady()||!zone3.isReady()) {
			zonesReady=false;
			return zonesReady;
		}
		return zonesReady;
		
	}
	
	 public Boolean getZonesReady() {
		return zonesReady;
	}
	public void setZonesReady(Boolean zonesReady) {
		this.zonesReady = zonesReady;
	}
	public void handle(ActionEvent event) {
	 }

	@Override
	public void run() {
		while(true) {
			
		 while(!this.checkZonesReady()
				 &&SecuritySystemContext.instance().getCurrentState()instanceof UnarmedStage)
		 {
			 try {
				    Thread.sleep(10);
				} catch (InterruptedException e) {
				    e.printStackTrace();
				    Thread.currentThread().interrupt();
				}
		 }
	     SecuritySystemContext.instance().handleEvent(AllDoorCloseEvent.instance());
	     
	     
	     while(this.checkZonesReady()
	    		 &&SecuritySystemContext.instance().getCurrentState()instanceof ZoneReadyState)
	     {
	    	 try {
	    		    Thread.sleep(10);
	    		} catch (InterruptedException e) {
	    		    e.printStackTrace();
	    		    Thread.currentThread().interrupt();
	    		}

	      }
	     SecuritySystemContext.instance().handleEvent(DoorOpensEvent.instance());
	     
	     }
	}
	
}

		 


	     
	


