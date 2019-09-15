#include <iostream>
using namespace std;

int main(){
  cout << "Till what number ? ";
  int response;
  cin >> response;

  int i = 1;
  do {
    cout << i << endl;
    i++;
  } while(i<response+1);

  return 0;
}
