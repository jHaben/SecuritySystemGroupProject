# SecuritySystemGroupProject

Unarmed State
  - [x] Unarmed x All Doors Closed = Zone Ready: Unarmed

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
  - [ ] Away x Door(s) Opens = Warning
  - [ ] Away x Movement = Warning

Stay
  - [X] Stay x Door(s) Open = Breach
  - [ ] Stay x Cancel = Password Required

Password Required
  - [ ] Password Required x Door(s) Open = Breach
  - [ ] Password Required x Cancel Button = Stay
  - [ ] Password Required x Valid Password = Unarmed

Warning
  - [ ] Warning x Valid Password = Unarmed
  - [ ] Warning x 60 Second Pass = Breach

Breach
  - [ ] Breach x Valid Password = Unarmed
  
