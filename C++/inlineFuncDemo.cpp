#include <iostream>
using namespace std;

inline void swap(int & a, int & b){
  int temp = a;
  a = b;
  b = temp;
}

int main(){

  int a = 2;
  int b = 3;

  swap(a,b);

  cout << "a is " << a << endl << "b is " << b << endl;

  return 0;
}
