void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  Serial.println("Simple Calculation using function");

  int first_number = 5;
  int second_number;
  second_number = 9;
  Serial.println(do_a_calc(first_number,second_number));
}

void loop() {
  // put your main code here, to run repeatedly:
  
}

int do_a_calc(int number_1, int number_2) {
  // Serial.println(number_1 + number_2);
  int result = number_1 + number_2;
  return result;
}
