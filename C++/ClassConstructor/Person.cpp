#include "Person.h"
#include <iostream>

Person::Person(){}

Person::Person(std::string fName, std::string lName){
  this -> firstName = fName;
  this -> lastName = lName;
}

Person::Person(std::string fName, std::string lName, int age){
  this -> firstName = fName;
  this -> lastName = lName;
  this -> age = age;
}

Person::~Person(){}
