// S.O.S Morse Code

int led_pin = 8;

void setup() {
  // put your setup code here, to run once:
  pinMode(led_pin,OUTPUT);
}

void loop() {
  // put your main code here, to run repeatedly:
  s();
  delay(300);
  o();
  delay(300);
  s();
  delay(1000);
}

void s() {
  for(int i=1; i<=3; i++){
    digitalWrite(led_pin,HIGH);
    delay(200);
    digitalWrite(led_pin,LOW);
    delay(200);
  }
}

void o() {
  for(int i=1; i<=3; i++){
    digitalWrite(led_pin,HIGH);
    delay(500);
    digitalWrite(led_pin,LOW);
    delay(500);
  }
}
