#include <iostream>
using namespace std;

int main(){
  cout << "Till what number ? ";
  int response;
  cin >> response;

  int i = 1;
  while(i<response+1){
    cout << i << endl;
    i++;
  }

  return 0;
}
