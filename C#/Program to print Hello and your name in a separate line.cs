/* 
Write a C# Sharp program to print Hello and your name in a separate line. Go to the editor
Expected Output : 
Hello: Bhupend Patil
*/

using System;

class Program
{
    static void Main(string[] args)
    {
        Console.Write("What is your first name? ");
        string fname = Console.ReadLine();

        Console.Write("What is your last name? ");
        string lname = Console.ReadLine();

        Console.WriteLine("Hello: {0} {1}",fname,lname);

        Console.ReadLine();
    }
}
