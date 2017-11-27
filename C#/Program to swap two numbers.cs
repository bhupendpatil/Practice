//Write a C# Sharp program to swap two numbers

using System;

class Program
{
    static void Main(string[] args)
    {
        int a, b, c;
        Console.Write("Input the First Number: ");
        a = Int32.Parse(Console.ReadLine()); //3

        Console.Write("Input the Second Number: ");
        b = Int32.Parse(Console.ReadLine()); //4

        c = a;  //3
        a = b;  //4
        b = c;  //3

        Console.WriteLine("First Number becomes {0} and Second Number becomes {1}",a,b);
        Console.ReadLine();
    }
}
