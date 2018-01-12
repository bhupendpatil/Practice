//Write a C# Sharp program to print the output of multiplication of three numbers which will be entered by the user

using System;

class Program
{
    static void Main(string[] args)
    {
        int a, b, c;
        Console.Write("Input the fist number to multiply: ");
        a = Int32.Parse(Console.ReadLine());
        Console.Write("Input the second number to multiply: ");
        b = Int32.Parse(Console.ReadLine());
        Console.Write("Input the third number to multiply: ");
        c = Int32.Parse(Console.ReadLine());

        Console.WriteLine("{0} x {1} x {2} = {3}",a,b,c,(a*b*c));
        Console.ReadLine();
    }
}
