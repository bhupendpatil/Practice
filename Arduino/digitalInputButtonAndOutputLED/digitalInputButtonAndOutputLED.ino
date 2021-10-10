int buttonState = 0;

int button_pin = 2; // input
int led_pin = 10; // output

void setup() {
  pinMode(button_pin,INPUT);
  pinMode(led_pin,OUTPUT);

  Serial.begin(9600);
}

void loop() {
  buttonState = digitalRead(button_pin);
  
  if (buttonState == HIGH) {
    digitalWrite(led_pin,HIGH);
    Serial.println("HIGH");
  } else {
    digitalWrite(led_pin,LOW);
    Serial.println("LOW");
  }
}
