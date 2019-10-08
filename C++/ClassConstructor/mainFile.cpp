#include <iostream>
#include "Person.h"

using namespace std;

int main(){
  Person *pone = new Person();
  Person *ptwo = new Person("Bhupend","Patil");
  Person *pthree = new Person("Bhupend","Patil",24);
  
  return 0;
}
