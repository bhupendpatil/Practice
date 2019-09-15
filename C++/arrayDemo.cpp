#include <iostream>
using namespace std;

int main(){
  int a1[10];
  a1[0] = 10;
  a1[1] = 1;
  a1[2] = 3;
  a1[3] = 8;
  a1[4] = 4;
  a1[5] = 5;
  a1[6] = 6;
  a1[7] = 4;
  a1[8] = 9;
  a1[9] = 7;

  int a2[] = {1,2,3,4,5,6,7,8};
  int a3[3] = {1,2,3};

  for(int i=0;i<10;i++){
    cout << a1[i] << endl;
  }

  for(int i=0;i<8;i++){
    cout << a2[i] << endl;
  }

  for(int i=0;i<3;i++){
    cout << a3[i] << endl;
  }

  return 0;
}
