#define RED_PIN 5
#define GREEN_PIN 6
#define BLUE_PIN 3

void setup() {
  // initialize digital pin LED_BUILTIN as an output.
  pinMode(RED_PIN, OUTPUT);
  pinMode(GREEN_PIN, OUTPUT);
  pinMode(BLUE_PIN, OUTPUT);
}

void loop() {
  //  digitalWrite(RED_PIN, HIGH);
  //  digitalWrite(GREEN_PIN, HIGH);
  //  digitalWrite(BLUE_PIN, HIGH);
  analogWrite(GREEN_PIN,50);
  analogWrite(RED_PIN,100);
  analogWrite(BLUE_PIN,100);
}
