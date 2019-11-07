int redLed = 9;
int yellowLed = 10;
int greenLed = 11;

void setColor(int red, int green, int yellow){
  #ifdef COMMON_ANODE
    red = 255 - red;
    green = 255 - green;
    yellow = 255 - yellow;
  #endif
  analogWrite(redLed, red);
  analogWrite(greenLed, green);
  analogWrite(yellowLed , yellow);
}

void setup() {
  pinMode(redLed, OUTPUT);
  pinMode(yellowLed, OUTPUT);
  pinMode(greenLed, OUTPUT);
}

void loop() {
  setColor(255,0,0); //red
  delay(1000);
  setColor(0,255,0); //green
  delay(1000);
  setColor(0,0,255); //yellow
  delay(1000);
  setColor(80,0,80);
  delay(1000);
  setColor(255,255,0); // red & green
  delay(1000);
  setColor(0xFF,0xFF,0xFF); // all, hex of FFFFFF
  delay(1000);
}
