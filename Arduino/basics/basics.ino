void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  Serial.println("Hello");
  Serial.print("hello again");
}

void loop() {
  // put your main code here, to run repeatedly:
  Serial.println(millis());
  delay(1000);
}
