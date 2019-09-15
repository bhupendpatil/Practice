#include <iostream>
using namespace std;

class Rectangle {
  public:
    int get_area(){
      return _width * _height;
    }
    int _width;
    int _height;
};

int main(){
  Rectangle outer{20,10};
  Rectangle inner;

  inner._width = 10;
  inner._height = 5;

  cout << "Outer Area = " << outer.get_area() << endl;
  cout << "Inner Area = " << inner.get_area() << endl;

  return 0;
}
