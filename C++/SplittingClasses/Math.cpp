#include "Math.h"

int Math::pow(int a, int b) {
  int result = 1;
  for(int i=0;i<b;i++){
    result = result * a;
  }
  return result;
}

int Math::add(int i, int b) {
  return i + b;
}

int Math::sub(int a, int b) {
  return a - b;
}

int Math2::mul(int a, int w) {
  return a * w;
}
