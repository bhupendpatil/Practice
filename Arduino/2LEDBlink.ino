int led = 11;
int ledbuiltin = 13;

void setup() {
  pinMode(led, OUTPUT);
  pinMode(ledbuiltin, OUTPUT);
}

void loop() {
  digitalWrite(led, HIGH);
  digitalWrite(ledbuiltin,LOW);
  delay(100);
  digitalWrite(led,LOW);
  digitalWrite(ledbuiltin, HIGH);
  delay(100);
}
