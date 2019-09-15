#include <iostream>
using namespace std;

int main(){
  struct details {
    string name;
    string lastName;
    string country;
  };

  details a1 = {"Bhupend", "Patil", "India"};
  details a2;
  a2.name = "ABC";
  a2.lastName = "XYZ";
  a2.country = "Unknown";

  cout << a1.name << " is from " << a1.country << endl;

  return 0;
}
