// Light Fade using potentio meter control

int led_pin = 5;

void setup() {
  // put your setup code here, to run once:
  pinMode(led_pin,OUTPUT);
}

void loop() {
  // put your main code here, to run repeatedly:
  int potValue = analogRead(A0);

  int mappedValue = map(potValue,0,1023,0,255);

  analogWrite(led_pin,mappedValue);
}
