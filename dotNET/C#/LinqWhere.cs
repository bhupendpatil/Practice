using System;
using System.Linq;

namespace Program {
	class LinqWhere {
		static void Main(string[] args) {
			string[] words = {"hell","ooo","dragon","nothing","bye"};

			var word5 = from word in words 
				    where word.Length > 5
				    select word;

			foreach(var word in word5) {
				Console.WriteLine(word);
			}

			Console.ReadLine();
		}
	}
}
