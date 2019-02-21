using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {
            ServiceReference1.TimeServerClient c = new ServiceReference1.TimeServerClient();
            Console.WriteLine("Time is " + c.getTimeAsString());
            Console.WriteLine("Elapsed Time is " + c.getTimeAsElapsed());
            Console.ReadLine();

        }
    }
}
