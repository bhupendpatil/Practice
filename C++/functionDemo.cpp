#include <iostream>
using namespace std;

int Sum(int x, int y){
  return x+y;
}
int Sum(int x,int y, int z){
  return x+y+z;
}

int main(){
  int result = Sum(1,2);
  cout<<result<<endl;

  return 0;
}
