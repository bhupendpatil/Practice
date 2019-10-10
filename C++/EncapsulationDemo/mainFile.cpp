#include <iostream>
#include "Person.h"

using namespace std;

int main(){
  Person p;

  p.SetFirstName("Bhupend");
  cout << p.GetFirstName() << endl;

  p.SetAge(-1);

  return 0;
}
