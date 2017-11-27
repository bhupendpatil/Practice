class Rectangle {
	int length, width;
	void get(int a, int b){
		length = a;
		width = b;
	}
	int area() {
		return (2*length + 2*width);
	}
}

class square extends Rectangle{
	int side;
	void getdata(int s){
		side = s;
	}
	int squr_area(){
		return (4*side);
	}
}

class circle extends square{
	float radius, pi = 3.14f;
	void getdata(float r){
		radius=r;
	}

	float cir_area(){
		return (radius*pi);
	}
}

class TotalArea{
	public static void main(String[] args) {
		circle c = new circle();
		c.getvalue(12);
		float u = c.cir_area();
		c.getdata(6);
		int v = c.squr_area();
		c.get(20,25);
		int w = c.area();
		System.out.println("The area of retangle = "+w);
		System.out.println("The area of square = "+v);
		System.out.println("The area of circle = "+u);

	}
}