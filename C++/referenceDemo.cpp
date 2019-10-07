#include <iostream>
using namespace std;

void passByValue(int &num1);

void passByValue(int &num1){
  cout << "In passByValue() Value of num1 is " << num1 << endl;

  num1++;

  cout << "num1 is now " << num1 << endl;
}

int main(){
  int num = 3;
  cout << "In main Value of num is " << num << endl;

  passByValue(num);
  cout << "Back in main and the value of num is " << num << endl;

  return 0;
}


/*
Before using reference "&"

C:\Users\Bhupend\Desktop\temp>a.exe
In main Value of num is 3
In passByValue() Value of num1 is 3
num1 is now 4
Back in main and the value of num is 3


After using reference "&" 
C:\Users\Bhupend\Desktop\temp>c++ -o a.exe referenceDemo.cpp

C:\Users\Bhupend\Desktop\temp>a.exe
In main Value of num is 3
In passByValue() Value of num1 is 3
num1 is now 4
Back in main and the value of num is 4

*/
