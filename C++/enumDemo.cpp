#include <iostream>
using namespace std;

int main(){
  enum Day {
    Sunday, Monday, Tuesday, Thursday, Friday, Saturday
  };

  Day payDay;
  payDay = Thursday;
  cout << payDay << endl;

  enum Day2 {
    Sunday1=1, Monday1, Tuesday1, Thursday1, Friday1, Saturday1
  };

  Day2 payDay1;
  payDay1 = Thursday1;
  cout << payDay1 << endl;

  return 0;
}
