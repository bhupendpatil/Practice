int led = 4;
int butOne = 8;
int butTwo = 9;

void setup() {
  pinMode(led, OUTPUT);
  pinMode(butOne, INPUT_PULLUP);
  pinMode(butTwo, INPUT_PULLUP);
}

void loop() {
  if (digitalRead(butOne) == LOW){
    digitalWrite(led,HIGH);
  }
  if (digitalRead(butTwo) == LOW) {
    digitalWrite(led,LOW); 
  }  
}
