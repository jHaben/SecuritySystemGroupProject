# SecuritySystemGroupProject

<h1> ToDo List </h1>
Unarmed State

  - [X] Unarmed x All Doors Closed = Zone Ready: Unarmed

Zone Ready Unarmed
  - [X] Zone Ready Unarmed x Away Button = Away Countdown
  - [X] Zone Ready Unarmed x Stay Button = Stay Countdown
  - [X] Zone Ready Unarmed x Door(s) Open = Unarmed

Away Countdown
  - [X] Away Countdown x 60 Second Pass = Away Check Doors

Stay Countdown
  - [X] Stay Countdown x 60 Second Pass = Stay Check Doors

Away Check Doors
  - [X] Away Check Doors x All Doors Closed = Away
  - [X] Away Check Doors x Door(s) Opens = Unarmed

Stay Check Doors
  - [X] Stay Check Doors x All Doors Closed = Stay
  - [X] Stay Check Doors x Door(s) Opens = Unarmed

Away
  - [X] Away x Door(s) Opens = Warning
  - [X] Away x Movement = Warning

Stay
  - [X] Stay x Door(s) Open = Breach
  - [X] Stay x Cancel = Password Required

Password Required
  - [X] Password Required x Door(s) Open = Breach
  - [X] Password Required x Cancel Button = Stay
  - [X] Password Required x Valid Password = Unarmed

Warning
  - [X] Warning x Valid Password = Unarmed
  - [X] Warning x 60 Second Pass = Breach

Breach
  - [X] Breach x Valid Password + Door(s) Open = Unarmed
  - [X] Breach x Valid Password + MotionDetected = ZoneReady: Unarmed
  
  
<h1> Why things work </h1>

So everything's super confusing. Hopefully this makes it all easier. 
Lets take a look at the GUI and look into the scenario in which all zones are Checked.
Thanks to Trung's **CheckBoxes.java** class, we'll see on line 100, how events determine what happens.

<b>SecuritySystemContext.instance().handleEvent(AllDoorCloseEvent.instance());</b> 
I'll explain what the SecuritySystemContext does later. But for now we'll focus on where it says **AllDoorCloseEvent.instance()**. What's important is that we know the AllDoorCloseEvent.instance() actually triggers the event. But if we go to the **AllDoorCloseEvent.java**, it looks like it's the end of the line and nothing happens after.

Well, that's where we look to the current **State**. The system defaults to **UnarmedStage.java**. So if we look there at the handleEvent method, we'll see a line of code that says
**SecuritySystemContext.instance().changeState(ZoneReadyState.instance());**
This line of code actually changes the state, where as the previous code determine what events are occuring.

Because the line of code called the method **changeState()** (SecuritySystemContext.instance().**changeState**), the system will now be in SecuritySystemContext.java > changeState()

Here, it performs the current state's leave() method (Line 35 of UnarmedStage.java), and changes the state to the new state. In this case,**ZoneReadyState.java**

Because it's changing the state to ZoneReadyState.instance(), SecuritySystemContext.java > changeState() now calls on it's enter() method.

And that's it!

Now anytime an event happens, it only allow swhatever event that ZoneReadyState.java has. In this case, 
handleEvent(DoorsOpenEvent event )
handleEvent(StayPressEvent event )
handleEvent(AwayPressEvent event )

then repeats the cycle.

<h2>SystemSecurityContext</h2>
The class itself has instances of the Display and state. 
The methods on the bottom control the GUI screen by calling 

display.**Action here**

