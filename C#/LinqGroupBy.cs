using System;
using System.Linq;

namespace Program {
	class LinqGroupBy {
		static void Main(string[] args) {
			int[] numbers = {0,1,2,3,4,5,6,7,8,9}

			var group = from n in numbers
				    group n by n % 2 into g
				    select new {x = g.Key, y = g};

			foreach(var i in group) {
				Console.Write(i.x);
				foreach(var j in i.y) {
					Console.WriteLine(j);
				}
			}
			Console.ReadLine();
		}
	}
}
