void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  Serial.println("Simple Calculation using function");
  do_a_calc(4,5);
}

void loop() {
  // put your main code here, to run repeatedly:
  
}

int do_a_calc(int number_1, int number_2) {
  Serial.println(number_1 + number_2);
}
