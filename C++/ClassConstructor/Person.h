#include <string>

class Person {
  private:
    std::string firstName;
    std::string lastName;
    int age;
  public:
    Person();
    Person(std::string fName, std::string lName);
    Person(std::string fName, std::string lName, int age);
    ~Person();
};
