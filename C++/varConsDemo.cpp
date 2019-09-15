#include <iostream>
using namespace std;

int main(){
  int var1 = 2;
  int var2{3};
  const int var3 = 4;
  const int var4{5};

  cout << var1 << endl << var2 << endl << var3 << endl << var4 << endl;

  return 0;
}
