#include <iostream>
using namespace std;

class Rectangle {
  private:
    int _width;
    int _height;
    void set_width(int _width){
      this -> _width = _width;
    }
    void set_height(int _height){
      this -> _height = _height;
    }
  public:
    int get_area(){
      return _width * _height;
    }
    void getValues(int a, int b){
      set_width(a);
      set_height(b);
    }
};

int main(){
  Rectangle outer;
  outer.getValues(10,20);

  cout << "Outer Area = " << outer.get_area() << endl;

  return 0;
}
