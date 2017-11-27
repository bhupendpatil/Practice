class Room {
    int length, width;
    Room(int x, int y){
        length = x; length =y;
    }
    int area(){
        return (length*width);
    }
}

class BedRoom extends Room{
    int height;
    BedRoom(int x,int y,int z){
        super(x,y);
        height = z;
    }
    int volume(){
        return(length*height*width);
    }
}

class InhertTest {
    public static void main(String args[]){
        BedRoom r1 = new BedRoom(14,12,10);
        int area1 = r1.area();
        int volume1 = r1.volume();
        System.out.println("Area = "+area1);
        System.out.println("Volume = "+volume1);
    }
}