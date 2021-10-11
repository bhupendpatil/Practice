int my_integers[6] = {1,2,3,4,5,6};

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);

  while(!Serial) {
    
  }

  Serial.println("Your array numbers: ");

  for (int i=0;i<=5;i++){
    Serial.print("Index ");
    Serial.print(i);
    Serial.print(" contains value ");
    Serial.println(my_integers[i]);
  }

  Serial.println();
  
  Serial.println("Let's do some calculations: ");

  for (int i=0;i<=5;i++){
    Serial.print(my_integers[i]);
    Serial.print(" + ");
    Serial.print(my_integers[i+1]);
    Serial.print(" = ");
    Serial.println(my_integers[i] + my_integers[i+1]);
  }
}

void loop() {
  // put your main code here, to run repeatedly:

}
