#include <iostream>
using namespace std;

class Rectangle {
  public:
    int _width;
    int _height;
};

int main(){

  Rectangle outer{2,3};
  Rectangle inner;

  inner._width = 10;
  inner._height = 5;

  cout << "Outer Area = " << outer._width *  outer._height << endl;
  cout << "Inner Area = " << inner._width *  inner._height << endl;

  return 0;
}
