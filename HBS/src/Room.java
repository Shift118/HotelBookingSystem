public class Room {
	int roomID;
	String type;
	boolean isAvailable;
	double price;
	
	Room(int id,String t, boolean isA,double p){
		this.roomID = id;
		this.type = t;
		this.isAvailable = isA;
		this.price = p;
	}
}
