#include <iostream>
using namespace std;

int main(){
  cout << "'Y' or 'N' ? ";
  char response;
  cin >> response;

  switch(response){
    case 'y':
      cout << "yes" << endl;
      break;
    case 'Y':
      cout << "YES" << endl;
      break;
    case 'n':
      cout << "no" << endl;
      break;
    case 'N':
      cout << "NO" << endl;
      break;
    default:
      cout << "Something else" << endl;
      break;
  }

  return 0;
}
