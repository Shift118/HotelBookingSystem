import java.util.Date;

public class Customer {
	String firstname;
	String lastname;
	String email;
	int customerID;
	static int id_variable;
	
	Customer(String firstname, String lastname ,String email){
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.customerID = ++id_variable;
	}
	
	void postCustomer(Customer c) {
		DatabaseManager dbManager = new DatabaseManager();
		dbManager.insertUser(c.firstname,c.lastname,c.email,c.customerID);
	}
	void bookHotel(Customer currentUser, Date checkInDate, Date checkOutDate, Room room, Hotel hotel) {
		Booking b = new Booking(checkInDate, checkOutDate, room, hotel,currentUser);
		if (room.isAvailable)
			b.makeBooking(b, room, currentUser);
		else
			System.out.println("Room is not Available!");
	}
}
