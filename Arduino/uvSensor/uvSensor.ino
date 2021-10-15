// UV Sensor

void setup() {
  Serial.begin(9600);
}

void loop() {
  int sensorValue = analogRead(A0);

  float voltage = sensorValue * (5.0 / 1023.0);

  Serial.print(sensorValue);
  Serial.print(",");

  Serial.print(voltage/0.1);
  delay(100);
}
