#include <iostream>
using namespace std;

int main(){
  cout << "'Y' or 'N' ? ";
  char response;
  cin >> response;

  if (response=='Y' || response=='y'){
    cout << "Yes" << endl;
  } else if (response=='N' || response=='n'){
    cout << "No" << endl;
  } else {
    cout << "Something else" << endl;
  }

  return 0;
}
