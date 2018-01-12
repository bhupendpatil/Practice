//Write a C# Sharp program to print the sum of two numbers

using System;

class Program
{
    static void Main(string[] args)
    {
        int Add(int a, int b)
        {
            return (a + b);
        }


        int i, j;
        Console.Write("Enter 1st value: ");
        i = Int32.Parse(Console.ReadLine());

        Console.Write("Enter 2nd value: ");
        j = Int32.Parse(Console.ReadLine());

        Console.WriteLine("Addition of {0} and {1} is {2}",i,j,Add(i, j));

        Console.ReadLine();
    }
}
