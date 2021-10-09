// if-else
int counter = 0;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
}

void loop() {
  // put your main code here, to run repeatedly:
  if (counter < 10) {
    Serial.print(counter);
    Serial.print(", ");
    Serial.println("Counter is smaller than 10"); 
  } else {
    Serial.print(counter);
    Serial.print(", ");
    Serial.println("Counter is greater than 10");
  }
  delay(500);
  counter++;
}
