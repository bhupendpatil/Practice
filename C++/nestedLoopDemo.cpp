#include <iostream>
using namespace std;

int main(){
  cout << "Till what number ? ";
  int response;
  cin >> response;

  for(int i=1;i<response+1;i++){
    for(int j=1;j<i+1;j++){
      cout << i << endl << j << endl;
    }
  }
}
