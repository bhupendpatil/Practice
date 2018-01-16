using System;

namespace DivNumber {
    class ExceptionDivideByZero {
        static void Main(string[] args){
            try {
                int x = 1;
                int y = 0;
                int z = x / y;
                Console.WriteLine(z);
            }
            catch (DivideByZeroException e) {
                Console.WriteLine("You cannot divide by Zero");
            }
            Console.ReadLine();
        }
    }
}
