using System;
using System.Linq;

namespace Program {
    class LinqSelect {
        static void Main(string[] args) {

            string[] words = { "hell", "ooo", "dragon", "nothing", "bye" };

            var word = from i in words
                       select i;

            foreach (var a in word) { 
                Console.WriteLine(a);
            }

            Console.ReadLine();
        }
    }
}
