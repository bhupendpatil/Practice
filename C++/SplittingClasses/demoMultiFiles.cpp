#include "Math.h"
#include <iostream>

using namespace std;

int main(){
  int a = Math::pow(4,3);
  cout << "Power is " << a << endl;

  cout << "Addition is " << Math::add(4,3) << endl;

  cout << "Substract is " << Math::sub(4,3) << endl;

  cout << "Multiplication is " << Math2::mul(4,3) << endl;

  return 0;
}
