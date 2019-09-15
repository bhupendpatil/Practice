#include <iostream>
#include "Rectangle.h"
using namespace std;

int main(){

  Rectangle outer{20,10};
  Rectangle inner;

  inner._width = 10;
  inner._height = 5;

  cout << "Outer Area = " << Area(outer._width,outer._height) << endl;
  cout << "Inner Area = " << Area(inner._width,inner._height) << endl;

  return 0;
}
