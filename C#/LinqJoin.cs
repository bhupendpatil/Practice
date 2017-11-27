using System;
using System.Linq;

namespace Program {
    class LinqJoin {
        static void Main(string[] args) {

            string[] a = {"ok","none","okaaay","bye"};

            List<b> b = GetbList();

            var join = from n in a
                       join m in b on n equals m.b
                       select new { x = n, y = m };

            foreach (var i in join) {
                Console.WriteLine(i.x + " : " + i.y);
            }

            Console.ReadLine();
        }
    }
}
