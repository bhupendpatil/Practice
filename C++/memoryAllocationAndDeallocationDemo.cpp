#include <iostream>
using namespace std;


int main(){
  // allocate
  int *pint = new int;
  double *pdouble = new double;

  *pint = 2;
  *pdouble = 2.0;

  cout << *pint << endl;
  cout << pint << endl;
  cout << *pdouble << endl;
  cout << pdouble << endl;

  // deallocate
  delete pint;
  delete pdouble;

  return 0;
}
