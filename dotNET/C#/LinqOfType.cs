using System;
using System.Collections;
using System.Linq;

namespace Program {
	class LinqOfType {
		static void Main(string[] args){
			IList a = new ArrayList();
			a.Add(1);
			a.Add("Hello");
			a.Add(8);
			a.Add(34);
			a.Add("Hell no");

			var s = from st in a.OfType<string>()
				select st;

			var i = from it in a.OfType<int>()
				select it;

			foreach(var st in s){
				Console.WriteLine(st);
			}

			foreach(var it in i){
				Console.WriteLine(it);
			}

			Console.ReadLine();
		}
	}
}
