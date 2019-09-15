#include <iostream>
using namespace std;

int main(){
  cout << "Till what number ? ";
  int response;
  cin >> response;

  for(int i=1;i<response+1;i++){
    cout << i << endl;
  }

  return 0;
}
