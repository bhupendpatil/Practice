#include <iostream>
using namespace std;

int main(){
  union numeros {
    int intVal;
    long longVal;
    double doubleVal;
  };

  numeros nos;
  nos.intVal = 3;

  cout << nos.intVal << endl;

  nos.doubleVal = 4.5;

  cout << nos.intVal << endl << nos.doubleVal << endl;

  return 0;
}
